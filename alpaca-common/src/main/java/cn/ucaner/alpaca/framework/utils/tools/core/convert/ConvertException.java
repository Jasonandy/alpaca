package cn.ucaner.alpaca.framework.utils.tools.core.convert;

import cn.ucaner.alpaca.framework.utils.tools.core.exceptions.ExceptionUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.convert   
* @ClassName：ConvertException   
* @Description：   <p> 转换异常 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午1:23:40   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class ConvertException extends RuntimeException{
	private static final long serialVersionUID = 4730597402855274362L;

	public ConvertException(Throwable e) {
		super(ExceptionUtil.getMessage(e), e);
	}
	
	public ConvertException(String message) {
		super(message);
	}
	
	public ConvertException(String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params));
	}
	
	public ConvertException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public ConvertException(Throwable throwable, String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params), throwable);
	}
}
