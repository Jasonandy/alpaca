package cn.ucaner.alpaca.framework.utils.tools.core.io.resource;

import cn.ucaner.alpaca.framework.utils.tools.core.exceptions.ExceptionUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.io.IORuntimeException;
import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.io.resource   
* @ClassName：NoResourceException   
* @Description：   <p> 资源文件或资源不存在异常 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午11:42:50   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class NoResourceException extends IORuntimeException {
	
	private static final long serialVersionUID = -623254467603299129L;

	public NoResourceException(Throwable e) {
		super(ExceptionUtil.getMessage(e), e);
	}

	public NoResourceException(String message) {
		super(message);
	}

	public NoResourceException(String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params));
	}

	public NoResourceException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public NoResourceException(Throwable throwable, String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params), throwable);
	}

	/**
	 * 导致这个异常的异常是否是指定类型的异常
	 * 
	 * @param clazz 异常类
	 * @return 是否为指定类型异常
	 */
	public boolean causeInstanceOf(Class<? extends Throwable> clazz) {
		Throwable cause = this.getCause();
		if (null != cause && clazz.isInstance(cause)) {
			return true;
		}
		return false;
	}
}
