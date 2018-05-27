package cn.ucaner.alpaca.framework.utils.tools.extra.mail;

import cn.ucaner.alpaca.framework.utils.tools.core.io.IORuntimeException;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.extra.mail   
* @ClassName：GlobalMailAccount   
* @Description：   <p> 全局邮件帐户，依赖于邮件配置文件{@link MailAccount#MAIL_SETTING_PATH}或{@link MailAccount#MAIL_SETTING_PATH2} </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午10:29:55   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public enum GlobalMailAccount {
	
	INSTANCE;

	private final MailAccount mailAccount;

	/**
	 * 构造
	 */
	private GlobalMailAccount() {
		mailAccount = createDefaultAccount();
	}

	/**
	 * 获得邮件帐户
	 * 
	 * @return 邮件帐户
	 */
	public MailAccount getAccount() {
		return this.mailAccount;
	}

	/**
	 * 创建默认帐户
	 * 
	 * @return MailAccount
	 */
	private MailAccount createDefaultAccount() {
		MailAccount mailAccount;
		try {
			mailAccount = new MailAccount(MailAccount.MAIL_SETTING_PATH);
		} catch (IORuntimeException e) {
			mailAccount = new MailAccount(MailAccount.MAIL_SETTING_PATH2);
		}
		return mailAccount;
	}
}
