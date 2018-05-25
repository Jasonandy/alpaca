package cn.ucaner.alpaca.framework.utils.tools.core.date;

import cn.ucaner.alpaca.framework.utils.tools.core.exceptions.ExceptionUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.date   
* @ClassName：DateException   
* @Description：   <p> 日期类异常</p>
* @Author： -    
* @CreatTime：2018年5月25日 下午1:20:27   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class DateException extends RuntimeException{
	private static final long serialVersionUID = 8247610319171014183L;

	public DateException(Throwable e) {
		super(ExceptionUtil.getMessage(e), e);
	}
	
	public DateException(String message) {
		super(message);
	}
	
	public DateException(String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params));
	}
	
	public DateException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public DateException(Throwable throwable, String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params), throwable);
	}
}
