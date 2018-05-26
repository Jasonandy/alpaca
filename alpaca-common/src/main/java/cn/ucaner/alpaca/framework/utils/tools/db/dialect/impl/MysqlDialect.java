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

import cn.ucaner.alpaca.framework.utils.tools.db.Page;
import cn.ucaner.alpaca.framework.utils.tools.db.dialect.DialectName;
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
	protected SqlBuilder wrapPageSql(SqlBuilder find, Page page) {
		return find.append(" LIMIT ").append(page.getStartPosition()).append(", ").append(page.getPageSize());
	}
	
	@Override
	public DialectName dialectName() {
		return DialectName.MYSQL;
	}
}
