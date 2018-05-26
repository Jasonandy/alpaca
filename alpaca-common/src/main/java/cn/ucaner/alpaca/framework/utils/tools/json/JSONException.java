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
package cn.ucaner.alpaca.framework.utils.tools.json;

import cn.ucaner.alpaca.framework.utils.tools.core.exceptions.ExceptionUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.json   
* @ClassName：JSONException   
* @Description：   <p> JSON异常 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:59:19   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class JSONException extends RuntimeException {
	private static final long serialVersionUID = 0;
	
	public JSONException(Throwable e) {
		super(ExceptionUtil.getMessage(e), e);
	}

	public JSONException(String message) {
		super(message);
	}
	
	public JSONException(String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params));
	}

	public JSONException(String message, Throwable cause) {
		super(message, cause);
	}

	public JSONException(Throwable throwable, String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params), throwable);
	}
}
