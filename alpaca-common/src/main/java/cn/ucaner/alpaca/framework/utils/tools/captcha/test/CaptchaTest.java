package cn.ucaner.alpaca.framework.utils.tools.captcha.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import cn.ucaner.alpaca.framework.utils.tools.captcha.CaptchaUtil;
import cn.ucaner.alpaca.framework.utils.tools.captcha.CircleCaptcha;
import cn.ucaner.alpaca.framework.utils.tools.captcha.LineCaptcha;
import cn.ucaner.alpaca.framework.utils.tools.captcha.ShearCaptcha;
import cn.ucaner.alpaca.framework.utils.tools.core.lang.Console;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.captcha.test   
* @ClassName：CaptchaTest   
* @Description：   <p> 直线干扰验证码单元测试 </p>
* @Author： -    
* @CreatTime：2018年5月26日 下午2:18:18   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class CaptchaTest {

	@Test
	public void lineCaptchaTest1() {
		// 定义图形验证码的长和宽
		LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
		Assert.assertNotNull(lineCaptcha.getCode());
		Assert.assertTrue(lineCaptcha.verify(lineCaptcha.getCode()));
	}

	@Test
	@Ignore
	public void lineCaptchaTest2() {

		// 定义图形验证码的长和宽
		LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
		// LineCaptcha lineCaptcha = new LineCaptcha(200, 100, 4, 150);
		// 图形验证码写出，可以写出到文件，也可以写出到流
		lineCaptcha.write("d:/line.png");
		Console.log(lineCaptcha.getCode());
		// 验证图形验证码的有效性，返回boolean值
		lineCaptcha.verify("1234");

		lineCaptcha.createCode();
		lineCaptcha.write("d:/line.png");
		Console.log(lineCaptcha.getCode());
		// 验证图形验证码的有效性，返回boolean值
		lineCaptcha.verify("1234");
	}

	@Test
	@Ignore
	public void circleCaptchaTest() {

		// 定义图形验证码的长和宽
		CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
		// CircleCaptcha captcha = new CircleCaptcha(200, 100, 4, 20);
		// 图形验证码写出，可以写出到文件，也可以写出到流
		captcha.write("d:/circle.png");
		// 验证图形验证码的有效性，返回boolean值
		captcha.verify("1234");
	}

	@Test
	@Ignore
	public void ShearCaptchaTest() {

		// 定义图形验证码的长和宽
		ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 100, 4, 4);
		// ShearCaptcha captcha = new ShearCaptcha(200, 100, 4, 4);
		// 图形验证码写出，可以写出到文件，也可以写出到流
		captcha.write("d:/shear.png");
		// 验证图形验证码的有效性，返回boolean值
		captcha.verify("1234");
	}
}
