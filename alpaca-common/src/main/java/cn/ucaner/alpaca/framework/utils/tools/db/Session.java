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
import java.sql.SQLException;
import java.sql.Savepoint;

import javax.sql.DataSource;

import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;
import cn.ucaner.alpaca.framework.utils.tools.db.dialect.DialectFactory;
import cn.ucaner.alpaca.framework.utils.tools.log.Log;
import cn.ucaner.alpaca.framework.utils.tools.log.LogFactory;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db   
* @ClassName：Session   
* @Description：   <p> 数据库SQL执行会话 </p>
* 一个会话只维护一个连接，推荐在执行完后关闭Session，避免重用<br>
* 本对象并不是线程安全的，多个线程共用一个Session将会导致不可预知的问题
* @Author： -    
* @CreatTime：2018年5月25日 下午2:18:14   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class Session extends AbstractSqlRunner implements Closeable{
	private final static Log log = LogFactory.get();
	
	private Connection conn = null;
	private Boolean isSupportTransaction = null;
	
	/**
	 * 创建会话
	 * @param ds 数据源
	 * @return this
	 */
	public static Session create(DataSource ds) {
		return new Session(ds);
	}
	
	/**
	 * 创建会话
	 * @param conn 数据库连接对象
	 * @return this
	 */
	public static Session create(Connection conn) {
		return new Session(conn);
	}

	//---------------------------------------------------------------------------- Constructor start
	/**
	 * 构造
	 * @param ds 数据源
	 */
	public Session(DataSource ds) {
		try {
			this.conn = ds.getConnection();
		} catch (SQLException e) {
			throw new DbRuntimeException("Get connection error!", e);
		}
		this.runner = new SqlConnRunner(DialectFactory.newDialect(conn));
	}
	
	/**
	 * 构造
	 * @param conn 数据库连接对象
	 */
	public Session(Connection conn) {
		this.conn = conn;
		this.runner = new SqlConnRunner(DialectFactory.newDialect(conn));
	}
	
	//---------------------------------------------------------------------------- Constructor end
	
	//---------------------------------------------------------------------------- Getters and Setters end
	/**
	 * 获得{@link Connection}
	 * @return {@link Connection}
	 */
	public Connection getConn() {
		return conn;
	}
	/**
	 * 设置{@link Connection}
	 * @param conn {@link Connection}
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * 获得{@link SqlConnRunner}
	 * @return {@link SqlConnRunner}
	 */
	public SqlConnRunner getRunner() {
		return runner;
	}
	/**
	 * 设置{@link SqlConnRunner}
	 * @param runner {@link SqlConnRunner}
	 */
	public void setRunner(SqlConnRunner runner) {
		this.runner = runner;
	}
	//---------------------------------------------------------------------------- Getters and Setters end
	
	//---------------------------------------------------------------------------- Transaction method start
	/**
	 * 开始事务
	 * @throws SQLException SQL执行异常
	 */
	public void beginTransaction() throws SQLException {
		if(null == isSupportTransaction) {
			isSupportTransaction = conn.getMetaData().supportsTransactions();
		}
		if(false == isSupportTransaction) {
			throw new SQLException("Transaction not supported for current database!");
		}
		conn.setAutoCommit(false);
	}
	
	/**
	 * 提交事务
	 * @throws SQLException SQL执行异常
	 */
	public void commit() throws SQLException{
		try {
			conn.commit();
		} catch (SQLException e) {
			throw e;
		}finally {
			try {
				conn.setAutoCommit(true);	//事务结束，恢复自动提交
			} catch (SQLException e) {
				log.error(e);
			}
		}
	}
	
	/**
	 * 回滚事务
	 * @throws SQLException SQL执行异常
	 */
	public void rollback() throws SQLException {
		try {
			conn.rollback();
		} catch (SQLException e) {
			throw e;
		}finally {
			try {
				conn.setAutoCommit(true);	//事务结束，恢复自动提交
			} catch (SQLException e) {
				log.error(e);
			}
		}
	}
	
	/**
	 * 静默回滚事务<br>
	 * 回滚事务
	 */
	public void quietRollback() {
		try {
			conn.rollback();
		} catch (Exception e) {
			log.error(e);
		}finally {
			try {
				conn.setAutoCommit(true);	//事务结束，恢复自动提交
			} catch (SQLException e) {
				log.error(e);
			}
		}
	}
	
	/**
	 * 回滚到某个保存点，保存点的设置请使用setSavepoint方法
	 * 
	 * @param savepoint 保存点
	 * @throws SQLException SQL执行异常
	 */
	public void rollback(Savepoint savepoint) throws SQLException {
		try {
			conn.rollback(savepoint);
		} catch (SQLException e) {
			throw e;
		}finally {
			try {
				conn.setAutoCommit(true);	//事务结束，恢复自动提交
			} catch (SQLException e) {
				log.error(e);
			}
		}
	}
	
	/**
	 * 静默回滚到某个保存点，保存点的设置请使用setSavepoint方法
	 * @param savepoint 保存点
	 * @throws SQLException SQL执行异常
	 */
	public void quietRollback(Savepoint savepoint) throws SQLException {
		try {
			conn.rollback(savepoint);
		} catch (Exception e) {
			log.error(e);
		}finally {
			try {
				conn.setAutoCommit(true);	//事务结束，恢复自动提交
			} catch (SQLException e) {
				log.error(e);
			}
		}
	}
	
	/**
	 * 设置保存点
	 * @return 保存点对象
	 * @throws SQLException SQL执行异常
	 */
	public Savepoint setSavepoint() throws SQLException {
		return conn.setSavepoint();
	}
	
	/**
	 * 设置保存点
	 * @param name 保存点的名称
	 * @return 保存点对象
	 * @throws SQLException SQL执行异常
	 */
	public Savepoint setSavepoint(String name) throws SQLException {
		return conn.setSavepoint(name);
	}
	
	/**
	 * 设置事务的隔离级别<br>
	 * 
	 * Connection.TRANSACTION_NONE                             驱动不支持事务<br>
	 * Connection.TRANSACTION_READ_UNCOMMITTED   允许脏读、不可重复读和幻读<br>
	 * Connection.TRANSACTION_READ_COMMITTED        禁止脏读，但允许不可重复读和幻读<br>
	 * Connection.TRANSACTION_REPEATABLE_READ         禁止脏读和不可重复读，单运行幻读<br>
	 * Connection.TRANSACTION_SERIALIZABLE                 禁止脏读、不可重复读和幻读<br>
	 * 
	 * @param level 隔离级别
	 * @throws SQLException SQL执行异常
	 */
	public void setTransactionIsolation(int level) throws SQLException {
		if(conn.getMetaData().supportsTransactionIsolationLevel(level) == false) {
			throw new SQLException(StrUtil.format("Transaction isolation [{}] not support!", level));
		}
		conn.setTransactionIsolation(level);
	}
	//---------------------------------------------------------------------------- Transaction method end
	
	/**
	 * 获得连接，Session中使用同一个连接
	 * @return {@link Connection}
	 * @throws SQLException SQL执行异常
	 */
	@Override
	public Connection getConnection() throws SQLException {
		//Session中使用同一个连接操作
		return this.conn;
	}

	/**
	 * Session中不关闭连接
	 * @param conn {@link Connection}
	 */
	@Override
	public void closeConnection(Connection conn) {
		//Session中不关闭连接
	}
	
	@Override
	public void close() {
		DbUtil.close(conn);
	}
}
