package cn.ucaner.alpaca.framework.utils.tools.core.exceptions;

import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.exceptions   
* @ClassName：StatefulException   
* @Description：   <p> 带有状态码的异常 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:30:05   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class StatefulException extends Exception{
	private static final long serialVersionUID = 6057602589533840889L;
	
	//异常状态码
	private int status;

	public StatefulException() {
	}
	
	public StatefulException(String msg) {
		super(msg);
	}
	
	public StatefulException(String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params));
	}
	
	public StatefulException(Throwable throwable) {
		super(throwable);
	}
	
	public StatefulException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
	
	public StatefulException(int status, String msg) {
		super(msg);
		this.status = status;
	}
	
	public StatefulException(int status, Throwable throwable) {
		super(throwable);
		this.status = status;
	}
	
	public StatefulException(int status, String msg, Throwable throwable) {
		super(msg, throwable);
		this.status = status;
	}
	
	/**
	 * @return 获得异常状态码
	 */
	public int getStatus() {
		return status;
	}
}
