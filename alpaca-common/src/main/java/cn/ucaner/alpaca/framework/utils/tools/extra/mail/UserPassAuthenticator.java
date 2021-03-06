package cn.ucaner.alpaca.framework.utils.tools.extra.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.extra.mail   
* @ClassName：UserPassAuthenticator   
* @Description：   <p> 用户名密码验证器</p>
* @Author： -    
* @CreatTime：2018年5月25日 下午10:32:03   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class UserPassAuthenticator extends Authenticator {

	private String user;
	private String pass;

	/**
	 * 构造
	 * 
	 * @param user 用户名
	 * @param pass 密码
	 */
	public UserPassAuthenticator(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(this.user, this.pass);
	}

}
