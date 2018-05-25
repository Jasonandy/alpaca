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
package cn.ucaner.alpaca.framework.utils.tools.http;

import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.http   
* @ClassName：HttpException   
* @Description：   <p> HTTP异常 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午11:04:14   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class HttpException extends RuntimeException{
	private static final long serialVersionUID = 8247610319171014183L;

	public HttpException(Throwable e) {
		super(e.getMessage(), e);
	}
	
	public HttpException(String message) {
		super(message);
	}
	
	public HttpException(String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params));
	}
	
	public HttpException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public HttpException(Throwable throwable, String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params), throwable);
	}
}
