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
package cn.ucaner.alpaca.framework.utils.tools.db;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cn.ucaner.alpaca.framework.utils.tools.core.io.IoUtil;
import cn.ucaner.alpaca.framework.utils.tools.db.dialect.Dialect;
import cn.ucaner.alpaca.framework.utils.tools.db.dialect.DialectFactory;
import cn.ucaner.alpaca.framework.utils.tools.db.ds.DSFactory;
import cn.ucaner.alpaca.framework.utils.tools.db.sql.SqlBuilder;
import cn.ucaner.alpaca.framework.utils.tools.log.Log;
import cn.ucaner.alpaca.framework.utils.tools.log.LogFactory;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db   
* @ClassName：DbUtil   
* @Description：   <p> 数据库操作工具类 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:20:17   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public final class DbUtil {
	
	private final static Log log = LogFactory.get();

	/**
	 * 实例化一个新的SQL运行对象
	 * 
	 * @param dialect 数据源
	 * @return SQL执行类
	 */
	public static SqlConnRunner newSqlConnRunner(Dialect dialect) {
		return SqlConnRunner.create(dialect);
	}
	
	/**
	 * 实例化一个新的SQL运行对象
	 * 
	 * @param ds 数据源
	 * @return SQL执行类
	 */
	public static SqlConnRunner newSqlConnRunner(DataSource ds) {
		return SqlConnRunner.create(ds);
	}
	
	/**
	 * 实例化一个新的SQL运行对象
	 * 
	 * @param conn 数据库连接对象
	 * @return SQL执行类
	 */
	public static SqlConnRunner newSqlConnRunner(Connection conn) {
		return SqlConnRunner.create(DialectFactory.newDialect(conn));
	}
	
	/**
	 * 实例化一个新的SQL运行对象，使用默认数据源
	 * 
	 * @return SQL执行类
	 */
	public static SqlRunner newSqlRunner() {
		return SqlRunner.create(getDs());
	}
	
	/**
	 * 实例化一个新的SQL运行对象
	 * 
	 * @param ds 数据源
	 * @return SQL执行类
	 */
	public static SqlRunner newSqlRunner(DataSource ds) {
		return SqlRunner.create(ds);
	}
	
	/**
	 * 实例化一个新的SQL运行对象
	 * 
	 * @param ds 数据源
	 * @param dialect SQL方言
	 * @return SQL执行类
	 */
	public static SqlRunner newSqlRunner(DataSource ds, Dialect dialect) {
		return SqlRunner.create(ds, dialect);
	}
	
	/**
	 * 新建数据库会话，使用默认数据源
	 * @return 数据库会话
	 */
	public static Session newSession(){
		return Session.create(getDs());
	}
	
	/**
	 * 新建数据库会话
	 * @param ds 数据源
	 * @return 数据库会话
	 */
	public static Session newSession(DataSource ds){
		return Session.create(ds);
	}
	
	/**
	 * 新建数据库会话
	 * @param conn 数据库连接对象
	 * @return 数据库会话
	 */
	public static Session newSession(Connection conn){
		return Session.create(conn);
	}
	
	/**
	 * 连续关闭一系列的SQL相关对象<br>
	 * 这些对象必须按照顺序关闭，否则会出错。
	 * 
	 * @param objsToClose 需要关闭的对象
	 */
	public static void close(Object... objsToClose) {
		for (Object obj : objsToClose) {
			if (obj instanceof AutoCloseable) {
				IoUtil.close((AutoCloseable) obj);
			} else if (obj instanceof Closeable) {
				IoUtil.close((Closeable) obj);
			} else {
				try {
					if (obj != null) {
						if (obj instanceof ResultSet) {
							((ResultSet) obj).close();
						} else if (obj instanceof Statement) {
							((Statement) obj).close();
						} else if (obj instanceof PreparedStatement) {
							((PreparedStatement) obj).close();
						} else if (obj instanceof Connection) {
							((Connection) obj).close();
						} else {
							log.warn("Object {} not a ResultSet or Statement or PreparedStatement or Connection!", obj.getClass().getName());
						}
					}
				} catch (SQLException e) {
				}
			}
		}
	}
	
	/**
	 * 获得默认数据源
	 * @return 默认数据源
	 */
	public static DataSource getDs(){
		return DSFactory.get();
	}
	
	/**
	 * 获取指定分组的数据源
	 * @param group 分组
	 * @return 数据源
	 */
	public static DataSource getDs(String group){
		return DSFactory.get(group);
	}
	
	/**
	 * 获得JNDI数据源
	 * @param jndiName JNDI名称
	 * @return 数据源
	 */
	public static DataSource getJndiDsWithLog(String jndiName) {
		try {
			return getJndiDs(jndiName);
		} catch (DbRuntimeException e) {
			log.error(e.getCause(), "Find JNDI datasource error!");
		}
		return null;
	}
	
	/**
	 * 获得JNDI数据源
	 * @param jndiName JNDI名称
	 * @return 数据源
	 */
	public static DataSource getJndiDs(String jndiName) {
		try {
			return (DataSource) new InitialContext().lookup(jndiName);
		} catch (NamingException e) {
			throw new DbRuntimeException(e);
		}
	}

	/**
	 * 设置全局配置：是否通过debug日志显示SQL
	 * 
	 * @param isShowSql 是否显示SQL
	 * @param isFormatSql 是否格式化显示的SQL
	 * @param isShowParams 是否打印参数
	 * @since 4.0.3
	 */
	public static void setShowSqlGlobal(boolean isShowSql, boolean isFormatSql, boolean isShowParams) {
		SqlBuilder.setShowSql(isShowSql, isFormatSql, isShowParams);
	}
}
