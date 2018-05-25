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
import cn.ucaner.alpaca.framework.utils.tools.db.sql.Wrapper;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.dialect.impl   
* @ClassName：MysqlDialect   
* @Description：   <p> MySQL方言 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:30:41   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class MysqlDialect extends AnsiSqlDialect{
	
	public MysqlDialect() {
		wrapper = new Wrapper('`');
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
		
		find.append(" LIMIT ").append(page.getStartPosition()).append(", ").append(page.getNumPerPage());
		
		final PreparedStatement ps = conn.prepareStatement(find.build());
		DbUtil.fillParams(ps, find.getParamValueArray());
		return ps;
	}
	
	@Override
	public DialectName dialectName() {
		return DialectName.MYSQL;
	}
}
