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

import cn.ucaner.alpaca.framework.utils.tools.db.DbRuntimeException;
import cn.ucaner.alpaca.framework.utils.tools.db.dialect.DriverUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.ds.pooled   
* @ClassName：DbConfig   
* @Description：   <p> 数据库配置 </p>
* @Author： - wubin   
* @CreatTime：2018年5月25日 下午2:46:11   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class DbConfig {
	
	//-------------------------------------------------------------------- Fields start
	private String driver;		//数据库驱动
	private String url;			//jdbc url
	private String user;			//用户名
	private String pass;			//密码
	
	private int initialSize;		//初始连接数
	private int minIdle;			//最小闲置连接数
	private int maxActive;		//最大活跃连接数
	private long maxWait;		//获取连接的超时等待
	//-------------------------------------------------------------------- Fields end
	
	//-------------------------------------------------------------------- Constructor start
	public DbConfig() {
	}
	
	/**
	 * 构造
	 * @param url jdbc url
	 * @param user 用户名
	 * @param pass 密码
	 */
	public DbConfig(String url, String user, String pass) {
		init(url, user, pass);
	}
	//-------------------------------------------------------------------- Constructor end
	
	/**
	 * 初始化
	 * @param url jdbc url
	 * @param user 用户名
	 * @param pass 密码
	 */
	public void init(String url, String user, String pass) {
		this.url = url;
		this.user = user;
		this.pass = pass;
		this.driver = DriverUtil.identifyDriver(url);
		try {
			Class.forName(this.driver);
		} catch (ClassNotFoundException e) {
			throw new DbRuntimeException(e, "Get jdbc driver from [{}] error!", url);
		}
	}
	
	//-------------------------------------------------------------------- Getters and Setters start
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public int getInitialSize() {
		return initialSize;
	}
	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}
	public int getMinIdle() {
		return minIdle;
	}
	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}
	public int getMaxActive() {
		return maxActive;
	}
	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}
	public long getMaxWait() {
		return maxWait;
	}
	public void setMaxWait(long maxWait) {
		this.maxWait = maxWait;
	}
	//-------------------------------------------------------------------- Getters and Setters end
}