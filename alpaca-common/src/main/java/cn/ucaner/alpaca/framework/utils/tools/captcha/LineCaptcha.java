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

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.util.concurrent.ThreadLocalRandom;

import cn.ucaner.alpaca.framework.utils.tools.core.io.FileUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.io.IORuntimeException;
import cn.ucaner.alpaca.framework.utils.tools.core.util.ImageUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.RandomUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;


/**
* @Package：cn.ucaner.alpaca.framework.utils.captcha   
* @ClassName：LineCaptcha   
* @Description：   <p> 使用干扰线方式生成的图形验证码 </p>
* @Author： - Jason   
* @CreatTime：2018年5月25日 上午9:31:11   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class LineCaptcha extends AbstractCaptcha {
	private static final long serialVersionUID = 8691294460763091089L;

	// -------------------------------------------------------------------- Constructor start
	/**
	 * 构造，默认5位验证码，150条干扰线
	 * 
	 * @param width 图片宽
	 * @param height 图片高
	 */
	public LineCaptcha(int width, int height) {
		this(width, height, 5, 150);
	}

	/**
	 * 构造
	 * 
	 * @param width 图片宽
	 * @param height 图片高
	 * @param codeCount 字符个数
	 * @param lineCount 干扰线条数
	 */
	public LineCaptcha(int width, int height, int codeCount, int lineCount) {
		super(width, height, codeCount, lineCount);
	}
	// -------------------------------------------------------------------- Constructor end

	@Override
	public Image createImage(String code) {
		// 图像buffer
		final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		final ThreadLocalRandom random = RandomUtil.getRandom();
		final Graphics2D g = ImageUtil.createGraphics(image, ImageUtil.randomColor(random));
		// 创建字体
		g.setFont(this.font);

		// 干扰线
		drawInterfere(g, random);

		// 文字
		int charWidth = width / (codeCount + 2);
		for (int i = 0; i < codeCount; i++) {
			// 产生随机的颜色值，让输出的每个字符的颜色值都将不同。
			g.setColor(ImageUtil.randomColor(random));
			g.drawString(String.valueOf(code.charAt(i)), i * charWidth + (charWidth >> 1), RandomUtil.randomInt(height >> 1) + (height >> 1));
		}
		
		return image;
	}

	// ----------------------------------------------------------------------------------------------------- Private method start
	/**
	 * 绘制干扰线
	 * 
	 * @param g {@link Graphics2D}画笔
	 * @param random 随机对象
	 */
	private void drawInterfere(Graphics2D g, ThreadLocalRandom random) {
		// 干扰线
		for (int i = 0; i < this.interfereCount; i++) {
			int xs = random.nextInt(width);
			int ys = random.nextInt(height);
			int xe = xs + random.nextInt(width / 8);
			int ye = ys + random.nextInt(height / 8);
			g.setColor(ImageUtil.randomColor(random));
			g.drawLine(xs, ys, xe, ye);
		}
	}
	// ----------------------------------------------------------------------------------------------------- Private method start
}