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
package cn.ucaner.alpaca.framework.utils.validate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

/**
* @Package：cn.ucaner.framework.utils   
* @ClassName：ValidateCode   
* @Description：   <p> [验证码生成工具.]可生成数字,大写,小写字母及三者混合类型的验证码.
*  支持自定义验证码字符数量; 支持自定义验证码图片的大小; 支持自定义需排除的特殊字符;
*  支持自定义干扰线的数量; 支持自定义验证码图文颜色</p>
* @Author： - Jason
* @CreatTime：2017年10月20日 下午4:04:15   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class ValidateCode {
	
	// 图片的宽度。  
	private int width = 160;
	// 图片的高度。  
	private int height = 40;
	// 验证码字符个数  
	private int codeCount = 5;
	// 验证码干扰线数  
	private int lineCount = 150;
	// 验证码  
	private String code = null;
	// 验证码图片Buffer  
	private BufferedImage buffImg = null;

	// 验证码范围,去掉0(数字)和O(拼音)容易混淆的(小写的1和L也可以去掉,大写不用了)  
	private char[] codeSequence = { '0',
			//			'B',
			//			'C',
			//			'D',
			//			'E',
			//			'F',
			//			'G',
			//			'H',
			//			'I',
			//			'J',
			//			'K',
			//			'L',
			//			'M',
			//			'N',
			//			'P',
			//			'Q',
			//			'R',
			//			'S',
			//			'T',
			//			'U',
			//			'V',
			//			'W',
			//			'X',
			//			'Y',
			//			'Z',
			'1',
			'2',
			'3',
			'4',
			'5',
			'6',
			'7',
			'8',
			'9' };

	/** 
	* @param width  图片宽 
	* @param height 图片高 
	*/
	public ValidateCode(int width, int height) {
		this.width = width;
		this.height = height;
		this.createCode();
	}

	/** 
	 * @param width     图片宽 
	 * @param height    图片高 
	 * @param codeCount 字符个数 
	 * @param lineCount 干扰线条数 
	 */
	public ValidateCode(int width, int height, int codeCount, int lineCount) {
		this.width = width;
		this.height = height;
		this.codeCount = codeCount;
		this.lineCount = lineCount;
		this.createCode();
	}

	public void createCode() {
		int x = 0, fontHeight = 0, codeY = 0;
		int red = 0, green = 0, blue = 0;

		x = width / ( codeCount + 2 );//每个字符的宽度(左右各空出一个字符)  
		fontHeight = height - 2;//字体的高度  
		codeY = height - 4;

		// 图像buffer  
		buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		// 生成随机数  
		Random random = new Random();
		// 将图像填充为白色  
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		// 创建字体,可以修改为其它的  
		Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);
		//	        Font font = new Font("Times New Roman", Font.ROMAN_BASELINE, fontHeight);  
		g.setFont(font);

		for (int i = 0; i < lineCount; i++) {
			// 设置随机开始和结束坐标  
			int xs = random.nextInt(width);//x坐标开始  
			int ys = random.nextInt(height);//y坐标开始  
			int xe = xs + random.nextInt(width / 8);//x坐标结束  
			int ye = ys + random.nextInt(height / 8);//y坐标结束  

			// 产生随机的颜色值，让输出的每个干扰线的颜色值都将不同。  
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			g.setColor(new Color(red, green, blue));
			g.drawLine(xs, ys, xe, ye);
		}

		// randomCode记录随机产生的验证码  
		StringBuffer randomCode = new StringBuffer();
		// 随机产生codeCount个字符的验证码。  
		for (int i = 0; i < codeCount; i++) {
			String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
			// 产生随机的颜色值，让输出的每个字符的颜色值都将不同。  
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			g.setColor(new Color(red, green, blue));
			g.drawString(strRand, ( i + 1 ) * x, codeY);
			// 将产生的四个随机数组合在一起。  
			randomCode.append(strRand);
		}
		// 将四位数字的验证码保存到Session中。  
		code = randomCode.toString();
	}

	public void write(String path) throws IOException {
		OutputStream sos = new FileOutputStream(path);
		this.write(sos);
	}

	public void write(OutputStream sos) throws IOException {
		ImageIO.write(buffImg, "png", sos);
		sos.close();
	}

	public BufferedImage getBuffImg() {
		return buffImg;
	}

	public String getCode() {
		return code;
	}

	/** 
	 * 测试函数,默认生成到d盘 
	 * @param args 
	 */
	public static void main(String[] args) {
		ValidateCode vCode = new ValidateCode(160, 40, 4, 150);
		try {
			String path = "D:/" + new Date().getTime() + ".png";
			System.out.println(vCode.getCode() + " >" + path);
			vCode.write(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 验证码类型为仅数字 0~9
	 */
	public static final int TYPE_NUM_ONLY = 0;

	/**
	 * 验证码类型为仅字母，即大写、小写字母混合
	 */
	public static final int TYPE_LETTER_ONLY = 1;

	/**
	 * 验证码类型为数字、大写字母、小写字母混合
	 */
	public static final int TYPE_ALL_MIXED = 2;

	/**
	 * 验证码类型为数字、大写字母混合
	 */
	public static final int TYPE_NUM_UPPER = 3;

	/**
	 * 验证码类型为数字、小写字母混合
	 */
	public static final int TYPE_NUM_LOWER = 4;

	/**
	 * 验证码类型为仅大写字母
	 */
	public static final int TYPE_UPPER_ONLY = 5;

	/**
	 * 验证码类型为仅小写字母
	 */
	public static final int TYPE_LOWER_ONLY = 6;

	/**
	 * 生成验证码字符串
	 * 
	 * @param type
	 *            验证码类型，参见本类的静态属性
	 * @param length
	 *            验证码长度，大于0的整数
	 * @param exChars
	 *            需排除的特殊字符（仅对数字、字母混合型验证码有效，无需排除则为null）
	 * @return 验证码字符串
	 */
	public static String generateTextCode(int type, int length, String exChars) {

		if (length <= 0) {
			return "";
		}
		StringBuffer code = new StringBuffer();
		int i = 0;
		Random r = new Random();

		switch (type) {

		// 仅数字
		case TYPE_NUM_ONLY:
			while (i < length) {
				int t = r.nextInt(10);
				// 排除特殊字符
				if (exChars == null || exChars.indexOf(t + "") < 0) {
					code.append(t);
					i++;
				}
			}
			break;

		// 仅字母（即大写字母、小写字母混合）
		case TYPE_LETTER_ONLY:
			while (i < length) {
				int t = r.nextInt(123);
				if ( ( t >= 97 || ( t >= 65 && t <= 90 ) ) && ( exChars == null || exChars.indexOf((char) t) < 0 )) {
					code.append((char) t);
					i++;
				}
			}
			break;

		// 数字、大写字母、小写字母混合
		case TYPE_ALL_MIXED:
			while (i < length) {
				int t = r.nextInt(123);
				if ( ( t >= 97 || ( t >= 65 && t <= 90 ) || ( t >= 48 && t <= 57 ) ) && ( exChars == null || exChars.indexOf((char) t) < 0 )) {
					code.append((char) t);
					i++;
				}
			}
			break;

		// 数字、大写字母混合
		case TYPE_NUM_UPPER:
			while (i < length) {
				int t = r.nextInt(91);
				if ( ( t >= 65 || ( t >= 48 && t <= 57 ) ) && ( exChars == null || exChars.indexOf((char) t) < 0 )) {
					code.append((char) t);
					i++;
				}
			}
			break;

		// 数字、小写字母混合
		case TYPE_NUM_LOWER:
			while (i < length) {
				int t = r.nextInt(123);
				if ( ( t >= 97 || ( t >= 48 && t <= 57 ) ) && ( exChars == null || exChars.indexOf((char) t) < 0 )) {
					code.append((char) t);
					i++;
				}
			}
			break;

		// 仅大写字母
		case TYPE_UPPER_ONLY:
			while (i < length) {
				int t = r.nextInt(91);
				if ( ( t >= 65 ) && ( exChars == null || exChars.indexOf((char) t) < 0 )) {
					code.append((char) t);
					i++;
				}
			}
			break;

		// 仅小写字母
		case TYPE_LOWER_ONLY:
			while (i < length) {
				int t = r.nextInt(123);
				if ( ( t >= 97 ) && ( exChars == null || exChars.indexOf((char) t) < 0 )) {
					code.append((char) t);
					i++;
				}
			}
			break;
		default:
			break;
		}

		return code.toString();
	}

	/**
	 * 已有验证码，生成验证码图片
	 * 
	 * @param textCode
	 *            文本验证码
	 * @param width
	 *            图片宽度
	 * @param height
	 *            图片高度
	 * @param interLine
	 *            图片中干扰线的条数
	 * @param randomLocation
	 *            每个字符的高低位置是否随机
	 * @param backColor
	 *            图片颜色，若为null，则采用随机颜色
	 * @param foreColor
	 *            字体颜色，若为null，则采用随机颜色
	 * @param lineColor
	 *            干扰线颜色，若为null，则采用随机颜色
	 * @return 图片缓存对象
	 */
	public static BufferedImage generateImageCode(String textCode, int width, int height, int interLine, boolean randomLocation, Color backColor,
			Color foreColor, Color lineColor) {

		BufferedImage bim = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = bim.getGraphics();

		// 画背景图
		g.setColor(backColor == null ? getRandomColor() : backColor);
		g.fillRect(0, 0, width, height);

		// 画干扰线
		Random r = new Random();
		if (interLine > 0) {

			int x = 0, y = 0, x1 = width, y1 = 0;
			for (int i = 0; i < interLine; i++) {
				g.setColor(lineColor == null ? getRandomColor() : lineColor);
				y = r.nextInt(height);
				y1 = r.nextInt(height);

				g.drawLine(x, y, x1, y1);
			}
		}

		// 写验证码

		// g.setColor(getRandomColor());
		// g.setColor(isSimpleColor?Color.BLACK:Color.WHITE);

		// 字体大小为图片高度的80%
		int fsize = (int) ( height * 0.8 );
		int fx = height - fsize;
		int fy = fsize;

		g.setFont(new Font("Default", Font.PLAIN, fsize));

		// 写验证码字符
		for (int i = 0; i < textCode.length(); i++) {
			// 每个字符高低是否随机
			fy = randomLocation ? (int) ( ( Math.random() * 0.3 + 0.6 ) * height ) : fy;
			g.setColor(foreColor == null ? getRandomColor() : foreColor);
			g.drawString(textCode.charAt(i) + "", fx, fy);
			fx += fsize * 0.9;
		}

		g.dispose();

		return bim;
	}

	/**
	 * 生成图片验证码
	 * 
	 * @param type
	 *            验证码类型，参见本类的静态属性
	 * @param length
	 *            验证码字符长度，大于0的整数
	 * @param exChars
	 *            需排除的特殊字符
	 * @param width
	 *            图片宽度
	 * @param height
	 *            图片高度
	 * @param interLine
	 *            图片中干扰线的条数
	 * @param randomLocation
	 *            每个字符的高低位置是否随机
	 * @param backColor
	 *            图片颜色，若为null，则采用随机颜色
	 * @param foreColor
	 *            字体颜色，若为null，则采用随机颜色
	 * @param lineColor
	 *            干扰线颜色，若为null，则采用随机颜色
	 * @return 图片缓存对象
	 */
	public static BufferedImage generateImageCode(int type, int length, String exChars, int width, int height, int interLine, boolean randomLocation,
			Color backColor, Color foreColor, Color lineColor) {
		String textCode = generateTextCode(type, length, exChars);
		BufferedImage bim = generateImageCode(textCode, width, height, interLine, randomLocation, backColor, foreColor, lineColor);

		return bim;
	}

	/**
	 * 产生随机颜色
	 * 
	 * @return
	 */
	private static Color getRandomColor() {
		Random r = new Random();
		Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		return c;
	}

}