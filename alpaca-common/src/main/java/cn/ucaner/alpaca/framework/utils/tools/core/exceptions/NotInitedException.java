package cn.ucaner.alpaca.framework.utils.tools.core.exceptions;

import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.exceptions   
* @ClassName：NotInitedException   
* @Description：   <p> 未初始化异常 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:29:46   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class NotInitedException extends RuntimeException{
	private static final long serialVersionUID = 8247610319171014183L;

	public NotInitedException(Throwable e) {
		super(e);
	}
	
	public NotInitedException(String message) {
		super(message);
	}
	
	public NotInitedException(String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params));
	}
	
	public NotInitedException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public NotInitedException(Throwable throwable, String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params), throwable);
	}
}
