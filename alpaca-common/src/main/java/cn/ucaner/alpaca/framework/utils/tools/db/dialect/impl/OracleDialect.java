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
	protected SqlBuilder wrapPageSql(SqlBuilder find, Page page) {
		final int[] startEnd = page.getStartEnd();
		return SqlBuilder.create(wrapper)
			.append("SELECT * FROM ( SELECT row_.*, rownum rownum_ from ( ")//
			.append(find)//
			.append(" ) row_ where rownum <= ").append(startEnd[1])//
			.append(") table_alias")//
			.append(" where table_alias.rownum_ >= ").append(startEnd[0]);//
	}
	
	@Override
	public DialectName dialectName() {
		return DialectName.ORACLE;
	}
}
