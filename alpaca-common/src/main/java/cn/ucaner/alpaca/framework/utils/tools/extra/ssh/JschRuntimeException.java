package cn.ucaner.alpaca.framework.utils.tools.extra.ssh;

import cn.ucaner.alpaca.framework.utils.tools.core.exceptions.ExceptionUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.extra.ssh   
* @ClassName：JschRuntimeException   
* @Description：   <p> Jsch异常</p>
* @Author： -    
* @CreatTime：2018年5月25日 下午10:37:00   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class JschRuntimeException extends RuntimeException{
	private static final long serialVersionUID = 8247610319171014183L;

	public JschRuntimeException(Throwable e) {
		super(ExceptionUtil.getMessage(e), e);
	}
	
	public JschRuntimeException(String message) {
		super(message);
	}
	
	public JschRuntimeException(String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params));
	}
	
	public JschRuntimeException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public JschRuntimeException(Throwable throwable, String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params), throwable);
	}
}
