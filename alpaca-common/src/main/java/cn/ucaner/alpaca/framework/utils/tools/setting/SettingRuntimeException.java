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
* @ClassName：SettingRuntimeException   
* @Description：   <p> 设置异常 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:07:21   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class SettingRuntimeException extends RuntimeException{
	
	private static final long serialVersionUID = 7941096116780378387L;

	public SettingRuntimeException(Throwable e) {
		super(e);
	}
	
	public SettingRuntimeException(String message) {
		super(message);
	}
	
	public SettingRuntimeException(String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params));
	}
	
	public SettingRuntimeException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public SettingRuntimeException(Throwable throwable, String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params), throwable);
	}
}
