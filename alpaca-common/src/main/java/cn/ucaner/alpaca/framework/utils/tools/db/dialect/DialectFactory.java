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
package cn.ucaner.alpaca.framework.utils.tools.db.dialect;

import java.sql.Connection;

import javax.sql.DataSource;

import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;
import cn.ucaner.alpaca.framework.utils.tools.db.DbUtil;
import cn.ucaner.alpaca.framework.utils.tools.db.dialect.impl.AnsiSqlDialect;
import cn.ucaner.alpaca.framework.utils.tools.db.dialect.impl.MysqlDialect;
import cn.ucaner.alpaca.framework.utils.tools.db.dialect.impl.OracleDialect;
import cn.ucaner.alpaca.framework.utils.tools.db.dialect.impl.PostgresqlDialect;
import cn.ucaner.alpaca.framework.utils.tools.db.dialect.impl.Sqlite3Dialect;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.dialect   
* @ClassName：DialectFactory   
* @Description：   <p> 方言工厂类 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:30:15   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class DialectFactory {
	
	/** JDBC 驱动 MySQL */
	public final static String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	/** JDBC 驱动 Oracle */
	public final static String DRIVER_ORACLE = "oracle.jdbc.driver.OracleDriver";
	/** JDBC 驱动 PostgreSQL */
	public final static String DRIVER_POSTGRESQL = "org.postgresql.Driver";
	/** JDBC 驱动 SQLLite3 */
	public final static String DRIVER_SQLLITE3 = "org.sqlite.JDBC";
	/** JDBC 驱动 SQLServer */
	public final static String DRIVER_SQLSERVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	/** JDBC 驱动 Hive */
	public final static String DRIVER_HIVE = "org.apache.hadoop.hive.jdbc.HiveDriver";
	/** JDBC 驱动 Hive2 */
	public final static String DRIVER_HIVE2 = "org.apache.hive.jdbc.HiveDriver";
	
	private DialectFactory() {
	}
	
	/**
	 * 创建方言
	 * @param driverName JDBC驱动类名
	 * @return 方言
	 */
	public static Dialect newDialect(String driverName) {
		if(StrUtil.isNotBlank(driverName)) {
			if(DRIVER_MYSQL.equalsIgnoreCase(driverName)) {
				return new MysqlDialect();
			}else if(DRIVER_ORACLE.equalsIgnoreCase(driverName)) {
				return new OracleDialect();
			}else if(DRIVER_SQLLITE3.equalsIgnoreCase(driverName)) {
				return new Sqlite3Dialect();
			}else if(DRIVER_POSTGRESQL.equalsIgnoreCase(driverName)) {
				return new PostgresqlDialect();
			}
		}
		
		//无法识别可支持的数据库类型默认使用ANSI方言，可兼容大部分SQL语句
		return new AnsiSqlDialect();
	}
	
	/**
	 * 创建方言
	 * @param ds 数据源
	 * @return 方言
	 */
	public static Dialect newDialect(DataSource ds) {
		return newDialect(DbUtil.identifyDriver(ds));
	}
	
	/**
	 * 创建方言
	 * @param conn 数据库连接对象
	 * @return 方言
	 */
	public static Dialect newDialect(Connection conn) {
		return newDialect(DbUtil.identifyDriver(conn));
	}
	
}
