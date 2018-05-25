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
package cn.ucaner.alpaca.framework.utils.tools.extra.mail;

import java.io.Serializable;
import java.util.Properties;

import cn.ucaner.alpaca.framework.utils.tools.setting.Setting;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.extra.mail   
* @ClassName：MailAccount   
* @Description：   <p> 邮件账户对象 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:21:09   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class MailAccount implements Serializable {
	private static final long serialVersionUID = -6937313421815719204L;
	
	private static final String SMTP_HOST = "mail.smtp.host";
	private static final String SMTP_PORT = "mail.smtp.port";
	private static final String SMTP_AUTH = "mail.smtp.auth";

	public static final String MAIL_SETTING_PATH = "config/mailAccount.setting";

	private String host;
	private String port = "25";
	private boolean auth;
	private String user;
	private String pass;
	private String from;

	//-------------------------------------------------------------- Constructor start
	/**
	 * 构造
	 */
	public MailAccount() {
	}

	/**
	 * 构造
	 * @param settingPath 配置文件路径
	 */
	public MailAccount(String settingPath) {
		this(new Setting(settingPath));
	}

	/**
	 * 构造
	 * @param setting 配置文件
	 */
	public MailAccount(Setting setting) {
		setting.toBean(this);
	}
	//-------------------------------------------------------------- Constructor end

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public boolean isAuth() {
		return auth;
	}

	public void setAuth(boolean isAuth) {
		this.auth = isAuth;
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

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@Override
	public String toString() {
		return "MailAccount [host=" + host + ", port=" + port + ", isAuth=" + auth + ", user=" + user + ", pass=******, from=" + from + "]";
	}
	
	/**
	 * 获得SMTP相关信息
	 * @return {@link Properties}
	 */
	public Properties getSmtpProps() {
		final Properties p = new Properties();
		p.put(SMTP_HOST, this.host);
		p.put(SMTP_PORT, this.port);
		p.put(SMTP_AUTH, this.auth);
		
		return p;
	}
}
