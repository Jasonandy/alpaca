package cn.ucaner.alpaca.framework.utils.tools.extra.mail;

import cn.ucaner.alpaca.framework.utils.tools.core.exceptions.ExceptionUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.extra.mail   
* @ClassName：MailException   
* @Description：   <p> 邮件异常 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午10:31:24   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class MailException extends RuntimeException{
	private static final long serialVersionUID = 8247610319171014183L;

	public MailException(Throwable e) {
		super(ExceptionUtil.getMessage(e), e);
	}
	
	public MailException(String message) {
		super(message);
	}
	
	public MailException(String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params));
	}
	
	public MailException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public MailException(Throwable throwable, String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params), throwable);
	}
}
