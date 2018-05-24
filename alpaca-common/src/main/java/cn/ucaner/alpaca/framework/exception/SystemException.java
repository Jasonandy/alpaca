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
package cn.ucaner.alpaca.framework.exception;

/**
* @Package：cn.ucaner.framework.exception   
* @ClassName：SystemException   
* @Description：   <p> 系统异常</p>
* @Author： -  Jason
* @CreatTime：2017年8月30日 下午1:50:19   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class SystemException extends RuntimeException {
	
	private static final long serialVersionUID = 1401593546385403720L;

	public SystemException() {
		super();
	}

	public SystemException(String message) {
		super(message);
	}

	public SystemException(Throwable cause) {
		super(cause);
	}

	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}
}
