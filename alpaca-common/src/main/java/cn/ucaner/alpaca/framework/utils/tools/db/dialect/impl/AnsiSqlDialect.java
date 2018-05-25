/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 19941115</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.alpaca.framework.utils.tools.db.dialect.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import cn.ucaner.alpaca.framework.utils.tools.core.util.ArrayUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.CollectionUtil;
import cn.ucaner.alpaca.framework.utils.tools.db.DbRuntimeException;
import cn.ucaner.alpaca.framework.utils.tools.db.DbUtil;
import cn.ucaner.alpaca.framework.utils.tools.db.Entity;
import cn.ucaner.alpaca.framework.utils.tools.db.Page;
import cn.ucaner.alpaca.framework.utils.tools.db.dialect.Dialect;
import cn.ucaner.alpaca.framework.utils.tools.db.dialect.DialectName;
import cn.ucaner.alpaca.framework.utils.tools.db.sql.Condition;
import cn.ucaner.alpaca.framework.utils.tools.db.sql.LogicalOperator;
import cn.ucaner.alpaca.framework.utils.tools.db.sql.Query;
import cn.ucaner.alpaca.framework.utils.tools.db.sql.SqlBuilder;
import cn.ucaner.alpaca.framework.utils.tools.db.sql.Wrapper;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.dialect.impl   
* @ClassName：AnsiSqlDialect   
* @Description：   <p> ANSI SQL 方言 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:31:21   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class AnsiSqlDialect implements Dialect {
	
	protected Wrapper wrapper = new Wrapper();
	
	@Override
	public Wrapper getWrapper() {
		return this.wrapper;
	}

	@Override
	public void setWrapper(Wrapper wrapper) {
		this.wrapper = wrapper;
	}
	

	@Override
	public PreparedStatement psForInsert(Connection conn, Entity entity) throws SQLException {
		final SqlBuilder insert = SqlBuilder.create(wrapper).insert(entity, this.dialectName());

		final PreparedStatement ps = conn.prepareStatement(insert.build(), Statement.RETURN_GENERATED_KEYS);
		DbUtil.fillParams(ps, insert.getParamValues());
		return ps;
	}
	
	@Override
	public PreparedStatement psForInsertBatch(Connection conn, Entity... entities) throws SQLException {
		if(ArrayUtil.isEmpty(entities)) {
			throw new DbRuntimeException("Entities for batch insert is empty !");
		}
		// 批量
		final SqlBuilder insert = SqlBuilder.create(wrapper).insert(entities[0], this.dialectName());
		
		final PreparedStatement ps = conn.prepareStatement(insert.build(), Statement.RETURN_GENERATED_KEYS);
		for (Entity entity : entities) {
			DbUtil.fillParams(ps, CollectionUtil.valuesOfKeys(entity, insert.getFields()));
			ps.addBatch();
		}
		return ps;
	}
	
	@Override
	public PreparedStatement psForDelete(Connection conn, Query query) throws SQLException {
		if (null == query) {
			throw new NullPointerException("query is null !");
		}
		
		Condition[] where = query.getWhere();
		if(ArrayUtil.isEmpty(where)){
			// 对于无条件的删除语句直接抛出异常禁止，防止误删除
			throw new SQLException("No 'WHERE' condition, we can't prepared statement for delete everything.");
		}
		final SqlBuilder delete = SqlBuilder.create(wrapper)
			.delete(query.getFirstTableName())
			.where(LogicalOperator.AND, where);

		final PreparedStatement ps = conn.prepareStatement(delete.build());
		DbUtil.fillParams(ps, delete.getParamValues());
		return ps;
	}

	@Override
	public PreparedStatement psForUpdate(Connection conn, Entity entity, Query query) throws SQLException {
		if (null == query) {
			throw new NullPointerException("query is null !");
		}
		
		Condition[] where = query.getWhere();
		if(ArrayUtil.isEmpty(where)){
			// 对于无条件的删除语句直接抛出异常禁止，防止误删除
			throw new SQLException("No 'WHERE' condition, we can't prepared statement for update everything.");
		}
		
		final SqlBuilder update = SqlBuilder.create(wrapper)
				.update(entity)
				.where(LogicalOperator.AND, where);

		final PreparedStatement ps = conn.prepareStatement(update.build());
		DbUtil.fillParams(ps, update.getParamValues());
		return ps;
	}

	@Override
	public PreparedStatement psForFind(Connection conn, Query query) throws SQLException {
		//验证
		if (null == query) {
			throw new NullPointerException("query is null !");
		}
		
		final SqlBuilder find = SqlBuilder.create(wrapper).query(query);
		final PreparedStatement ps = conn.prepareStatement(find.build());
		DbUtil.fillParams(ps, find.getParamValues());
		return ps;
	}

	@Override
	public PreparedStatement psForPage(Connection conn, Query query) throws SQLException {
		final Page page = query.getPage();
		if(null == page){
			//无分页信息默认使用find
			return this.psForFind(conn, query);
		}
		
		final SqlBuilder find = SqlBuilder.create(wrapper)
				.query(query)
				.orderBy(page.getOrders());
		
		//limit  A  offset  B 表示：A就是你需要多少行，B就是查询的起点位置。
		find.append(" limit ").append(page.getNumPerPage()).append(" offset ").append(page.getStartPosition());
		
		final PreparedStatement ps = conn.prepareStatement(find.build());
		DbUtil.fillParams(ps, find.getParamValues());
		return ps;
	}

	@Override
	public PreparedStatement psForCount(Connection conn, Query query) throws SQLException {
		query.setFields(CollectionUtil.newArrayList("count(1)"));
		return psForFind(conn, query);
	}
	
	@Override
	public DialectName dialectName() {
		return DialectName.ANSI;
	}

	// ---------------------------------------------------------------------------- Protected method start
	// ---------------------------------------------------------------------------- Protected method end

}
