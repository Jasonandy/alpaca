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

import cn.ucaner.alpaca.framework.utils.tools.db.dialect.DialectName;
import cn.ucaner.alpaca.framework.utils.tools.db.sql.Wrapper;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.dialect.impl   
* @ClassName：Sqlite3Dialect   
* @Description：   <p> SqlLite3方言</p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:32:46   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class Sqlite3Dialect extends AnsiSqlDialect{
	public Sqlite3Dialect() {
		wrapper = new Wrapper('[', ']');
	}
	
	@Override
	public DialectName dialectName() {
		return DialectName.SQLITE3;
	}
}
