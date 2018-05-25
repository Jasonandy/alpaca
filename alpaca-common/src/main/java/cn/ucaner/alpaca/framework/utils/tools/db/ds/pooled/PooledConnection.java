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
package cn.ucaner.alpaca.framework.utils.tools.db.ds.pooled;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import cn.ucaner.alpaca.framework.utils.tools.db.DbUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.ds.pooled   
* @ClassName：PooledConnection   
* @Description：   <p> 池化 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:46:44   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class PooledConnection extends ConnectionWraper{
	
	private PooledDataSource ds;
	private boolean isClosed;
	
	public PooledConnection(PooledDataSource ds) throws SQLException {
		this.ds = ds;
		DbConfig config = ds.getConfig();
		this.raw = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPass());
	}
	
	public PooledConnection(PooledDataSource ds, Connection conn) {
		this.ds = ds;
		this.raw = conn;
	}

	/**
	 * 重写关闭连接，实际操作是归还到连接池中
	 */
	@Override
	public void close() throws SQLException {
		this.ds.free(this);
		this.isClosed = true;
	}

	/**
	 * 连接是否关闭，关闭条件：<br>
	 * 1、被归还到池中
	 * 2、实际连接已关闭
	 */
	@Override
	public boolean isClosed() throws SQLException {
		return isClosed || raw.isClosed();
	}
	
	/**
	 * 打开连接
	 * @return this
	 */
	protected PooledConnection open() {
		this.isClosed = false;
		return this;
	}

	/**
	 * 释放连接
	 * @return this
	 */
	protected PooledConnection release() {
		DbUtil.close(this.raw);
		return this;
	}
}
