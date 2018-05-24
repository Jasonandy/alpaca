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
package cn.ucaner.alpaca.framework.utils.math;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
* @Package：cn.ucaner.framework.utils   
* @ClassName：NumberUtils   
* @Description：   <p> 格式化双精度数字, 格式化双精度数字,格式化单精度数字,双精度数字转字符串,双精度数字转金额.</p>
* @Author： - Jason 
* @CreatTime：2017年8月30日 下午2:10:20   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class NumberUtils {

	/**
	 * 格式化双精度数字
	 * @param num
	 * @return Double
	 */
	public static Double FormatDouble(Double num) {
		if (num == null) {
			return null;
		}
		int p_num = num.toString().indexOf(".");
		if ( ( ( num.toString().length() ) - p_num - 1 ) > 5) {
			if (Integer.parseInt(num.toString().substring(p_num + 6, p_num + 7)) >= 5) {
				num = num + 0.000001;
			}
		}
		DecimalFormat df = new DecimalFormat("####.00");
		return new Double(df.format(num));
	}

	/**
	 * 格式化双精度数字
	 * @param num
	 * @return String
	 */
	public static String FormatDoubleToString(Double num) {
		if (num == null) {
			return null;
		}
		int p_num = num.toString().indexOf(".");
		if ( ( ( num.toString().length() ) - p_num - 1 ) > 5) {
			if (Integer.parseInt(num.toString().substring(p_num + 6, p_num + 7)) >= 5) {
				num = num + 0.000001;
			}
		}
		DecimalFormat df = new DecimalFormat("###,##0.00");
		return df.format(num);
	}

	/**
	 * 格式化单精度数字
	 * @param num
	 * @return Float
	 */
	public static Float FormatFolat(Float num) {
		if (num == null) {
			return null;
		}

		int p_num = num.toString().indexOf(".");
		if ( ( ( num.toString().length() ) - p_num - 1 ) > 5) {
			if (Integer.parseInt(num.toString().substring(p_num + 6, p_num + 7)) >= 5) {
				num = num + new Float(0.000001);
			}
		}
		DecimalFormat df = new DecimalFormat("####.00000");
		return new Float(df.format(num));
	}

	/**
	 * 双精度数字转字符串
	 * @param num  双精度数字
	 * @param dec 保留小数位数
	 * @return String
	 */
	public static String getCommaNumber(double num, int dec) {
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.CHINA);
		nf.setMaximumFractionDigits(dec);
		return nf.format(num);
	}

	/**
	 * 双精度数字转金额
	 * @param num  双精度数字
	 * @param dec 保留小数位数
	 * @return String
	 */
	public static String getCurrencyNationNumber(double num, int dec) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
		nf.setMaximumFractionDigits(dec);
		return nf.format(num);
	}
}
