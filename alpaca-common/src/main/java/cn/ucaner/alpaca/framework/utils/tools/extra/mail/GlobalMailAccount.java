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

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.extra.mail   
* @ClassName：GlobalMailAccount   
* @Description：   <p> 全局邮件帐户，依赖于邮件配置文件{@link MailAccount#MAIL_SETTING_PATH} </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:20:42   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public enum GlobalMailAccount {
	INSTANCE;
	
	private final MailAccount mailAccount = new MailAccount(MailAccount.MAIL_SETTING_PATH);
	
	/**
	 * 获得邮件帐户
	 * @return 邮件帐户
	 */
	public MailAccount getAccount() {
		return this.mailAccount;
	}
}
