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

import java.io.OutputStream;
import java.io.Serializable;

/**
* @Package：cn.ucaner.alpaca.framework.utils.captcha   
* @ClassName：ICaptcha   
* @Description：   <p> 验证码接口，提供验证码对象接口定义 </p>
* @Author： - Jason   
* @CreatTime：2018年5月25日 上午9:30:48   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface ICaptcha extends Serializable{

	/**
	 * 创建验证码，实现类需同时生成随机验证码字符串和验证码图片
	 */
	void createCode();

	/**
	 * 获取验证码的文字内容
	 * 
	 * @return 验证码文字内容
	 */
	String getCode();

	/**
	 * 验证验证码是否正确，建议忽略大小写
	 * 
	 * @param userInputCode 用户输入的验证码
	 * @return 是否与生成的一直
	 */
	boolean verify(String userInputCode);

	/**
	 * 将验证码写出到目标流中
	 * 
	 * @param out 目标流
	 */
	void write(OutputStream out);
}
