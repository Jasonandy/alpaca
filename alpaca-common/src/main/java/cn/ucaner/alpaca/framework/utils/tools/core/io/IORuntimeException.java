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
package cn.ucaner.alpaca.framework.utils.tools.core.io;

import cn.ucaner.alpaca.framework.utils.tools.core.exceptions.ExceptionUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.io   
* @ClassName：IORuntimeException   
* @Description：   <p> IO运行时异常异常 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午1:07:45   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class IORuntimeException extends RuntimeException{
	private static final long serialVersionUID = 8247610319171014183L;

	public IORuntimeException(Throwable e) {
		super(ExceptionUtil.getMessage(e), e);
	}
	
	public IORuntimeException(String message) {
		super(message);
	}
	
	public IORuntimeException(String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params));
	}
	
	public IORuntimeException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public IORuntimeException(Throwable throwable, String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params), throwable);
	}
	
	/**
	 * 导致这个异常的异常是否是指定类型的异常
	 * @param clazz 异常类
	 * @return 是否为指定类型异常
	 */
	public boolean causeInstanceOf(Class<? extends Throwable> clazz){
		Throwable cause = this.getCause();
		if(null != cause && clazz.isInstance(cause)){
			return true;
		}
		return false;
	}
}
