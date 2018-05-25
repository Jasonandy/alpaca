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
package cn.ucaner.alpaca.framework.utils.tools.captcha;

/**
* @Package：cn.ucaner.alpaca.framework.utils.captcha   
* @ClassName：CaptchaUtil   
* @Description：   <p> 图形验证码工具</p>
* @Author： - Jason   
* @CreatTime：2018年5月25日 上午9:30:27   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class CaptchaUtil {
	
	/**
	 * 创建线干扰的验证码，默认4位验证码，150条干扰线
	 * 
	 * @param width 图片宽
	 * @param height 图片高
	 * @return {@link LineCaptcha}
	 */
	public static LineCaptcha createLineCaptcha(int width, int height) {
		return new LineCaptcha(width, height);
	}
	
	/**
	 * 创建线干扰的验证码
	 * 
	 * @param width 图片宽
	 * @param height 图片高
	 * @param codeCount 字符个数
	 * @param lineCount 干扰线条数
	 * @return {@link LineCaptcha}
	 */
	public static LineCaptcha createLineCaptcha(int width, int height, int codeCount, int lineCount) {
		return new LineCaptcha(width, height, codeCount, lineCount);
	}
}
