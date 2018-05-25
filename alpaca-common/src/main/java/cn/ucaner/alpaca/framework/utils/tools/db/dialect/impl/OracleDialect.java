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

import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;
import cn.ucaner.alpaca.framework.utils.tools.db.DbRuntimeException;
import cn.ucaner.alpaca.framework.utils.tools.db.DbUtil;
import cn.ucaner.alpaca.framework.utils.tools.db.Page;
import cn.ucaner.alpaca.framework.utils.tools.db.dialect.DialectName;
import cn.ucaner.alpaca.framework.utils.tools.db.sql.Query;
import cn.ucaner.alpaca.framework.utils.tools.db.sql.SqlBuilder;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.dialect.impl   
* @ClassName：OracleDialect   
* @Description：   <p> Oracle 方言 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:31:52   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class OracleDialect extends AnsiSqlDialect{
	
	public OracleDialect() {
//		wrapper = new Wrapper('"');	//Oracle所有字段名用双引号包围，防止字段名或表名与系统关键字冲突
	}
	
	@Override
	public PreparedStatement psForPage(Connection conn, Query query) throws SQLException {
		//验证
		if(query == null || StrUtil.hasBlank(query.getTableNames())) {
			throw new DbRuntimeException("Table name is null !");
		}
		final Page page = query.getPage();
		if(null == page){
			//无分页信息默认使用find
			return super.psForFind(conn, query);
		}
		
		final SqlBuilder find = SqlBuilder.create(wrapper)
				.query(query)
				.orderBy(page.getOrders());
		
		int[] startEnd = page.getStartEnd();
		final SqlBuilder sql = SqlBuilder.create(wrapper);
		sql.append("SELECT * FROM ( SELECT row_.*, rownum rownum_ from ( ")
			.append(find)
			.append(" ) row_ where rownum <= ").append(startEnd[1])
			.append(") table_alias")
			.append(" where table_alias.rownum_ >= ").append(startEnd[0]);
		
		final PreparedStatement ps = conn.prepareStatement(sql.build());
		DbUtil.fillParams(ps, find.getParamValues());
		return ps;
	}
	
	@Override
	public DialectName dialectName() {
		return DialectName.ORACLE;
	}
}
