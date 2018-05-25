package cn.ucaner.alpaca.framework.utils.tools.core.exceptions;

import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.exceptions   
* @ClassName：ValidateException   
* @Description：   <p> 验证异常 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:30:40   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class ValidateException extends StatefulException {
	private static final long serialVersionUID = 6057602589533840889L;

	public ValidateException() {
	}

	public ValidateException(String msg) {
		super(msg);
	}
	
	public ValidateException(String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params));
	}

	public ValidateException(Throwable throwable) {
		super(throwable);
	}

	public ValidateException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public ValidateException(int status, String msg) {
		super(status, msg);
	}

	public ValidateException(int status, Throwable throwable) {
		super(status, throwable);
	}

	public ValidateException(int status, String msg, Throwable throwable) {
		super(status, msg, throwable);
	}
}
