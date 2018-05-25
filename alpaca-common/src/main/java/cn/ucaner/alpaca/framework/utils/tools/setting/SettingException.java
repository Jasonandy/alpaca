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
package cn.ucaner.alpaca.framework.utils.tools.setting;

import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.setting   
* @ClassName：SettingException   
* @Description：   <p> 设置异常 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:08:16   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class SettingException extends Exception{
	private static final long serialVersionUID = -4134588858314744501L;

	public SettingException(Throwable e) {
		super(e);
	}
	
	public SettingException(String message) {
		super(message);
	}
	
	public SettingException(String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params));
	}
	
	public SettingException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public SettingException(Throwable throwable, String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params), throwable);
	}
}
