/**
 * <html>
 * <body>
 *  <P> Copyright JasonInternational </p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年5月24日 下午8:25:20</p>
 *  <p> Created by wubin</p>
 *  </body>
 * </html>
 */
package cn.ucaner.alpaca.framework.exception;

/**     
* @Package：cn.ucaner.alpaca.framework.exception   
* @ClassName：NumberFormatException   
* @Description：   <p> 数字格式化异常 </p>
* @Author： - Jason   
* @CreatTime：2018年5月24日 下午8:25:20   
* @Modify By：   
* @ModifyTime：  2018年5月24日
* @Modify marker：   
* @version    V1.0
*/
public class NumberFormatException extends RuntimeException{

	private static final long serialVersionUID = -281825988853825152L;
	
	public NumberFormatException() {
		super();
	}

	public NumberFormatException(String message) {
		super(message);
	}

	public NumberFormatException(Throwable cause) {
		super(cause);
	}

	public NumberFormatException(String message, Throwable cause) {
		super(message, cause);
	}

}
