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
package cn.ucaner.alpaca.framework.utils.word;

import java.text.SimpleDateFormat;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

import cn.ucaner.alpaca.framework.utils.date.DateUtils;

/**
* @Package：cn.ucaner.alpaca.framework.utils   
* @ClassName：MedicalCardUtil   
* @Description：   <p> 脱敏工具 </p>
* @Author： - Jason 
* @CreatTime：2017年10月24日 上午10:53:02   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class DesensitizationUtil {
	/**
	 * 加密信息
	 * @param value
	 * @return
	 */
	public static String getEncodeValue(String value) {
		try {
			return new Base64().encodeAsString(value.getBytes());
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 脱敏姓名
	 * @param value
	 * @return
	 */
	public static String desName(String value) {
		if (StringUtils.isNotBlank(value)) {
			return "*" + value.substring(1);
		} else {
			return "";
		}
	}

	/**
	 * 脱敏手机号码
	 * @param value
	 * @return
	 */
	public static String desMobile(String value) {
		if (StringUtils.isNotBlank(value)) {
			return value.substring(0, 3) + "****" + value.substring(value.length() - 4, value.length());
		} else {
			return "";
		}
	}

	/**
	 * 脱敏身份证
	 * @param value
	 * @return
	 */
	public static String desIdNo(String value) {
		if (StringUtils.isNotBlank(value)) {
			return value.substring(0, 1) + "****************" + value.substring(value.length() - 1, value.length());
		} else {
			return "";
		}
	}
	
	/**
	 * 脱敏银行卡号
	 * @param value
	 * @return
	 */
	public static String desNo(String value) {
		if (StringUtils.isNotBlank(value)) {
			return value.substring(0, 6)+"*****"+value.substring(value.length()-4, value.length());
		} else {
			return "";
		}
	}

	/**
	 * 根据身份证获取年龄
	 * @param value
	 * @return
	 */
	public static int getAge(String value) {
		try {
			String birth = getBirth(value);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			//System.out.println(birth);
			//System.out.println(df.parse(birth).getTime());
			return Long.valueOf( ( ( System.currentTimeMillis() - df.parse(birth).getTime() ) / ( 1000 * 60 * 60 * 24 ) / 365 )).intValue();
		} catch (Exception e) {
			return 0;
		}
	}

	public static int getAgeByBirth(String birth) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			//System.out.println(birth);
			//System.out.println(df.parse(birth).getTime());
			return Long.valueOf( ( ( System.currentTimeMillis() - df.parse(birth).getTime() ) / ( 1000 * 60 * 60 * 24 ) / 365 )).intValue();
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 根据身份证获取性别
	 * @param value
	 * @return
	 */
	public static int getSex(String value) {
		if (StringUtils.isNotBlank(value) && value.length() == 18) {
			return Integer.valueOf(value.substring(16, 17)) % 2 == 0 ? 2 : 1;
		} else {
			return 0;
		}
	}

	/**
	 * 根据身份证获取出生日期
	 * @param value
	 * @return
	 */
	public static String getBirth(String value) {
		if (StringUtils.isNotBlank(value) && value.length() == 18) {
			return value.substring(6, 10) + "-" + value.substring(10, 12) + "-" + value.substring(12, 14);
		} else {
			return DateUtils.today();
		}
	}

	public static void main(String[] args) {
		String value = "440923199008192155";
		System.out.println(getAge(value));
		//		value = "";
		//		System.out.println(getEncodeValue(value));
	}
}
