/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JasonInternational Ucanx</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 19941115</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.alpaca.framework.constant;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import cn.ucaner.alpaca.framework.config.SystemConfig;

/**
* @Package：cn.ucaner.common   
* @ClassName：GlobalConstant   
* @Description：   <p> 全局变量</p>
* @Author： - Jason 
* @CreatTime：2017年11月19日 下午7:32:23   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class GlobalConstant {
	
	/************************ 文件存放的常量 start **************************/
	/** 文件上传根目录 **/
	public static String filePath = SystemConfig.getStringValue("file_path");
	/** 当前域名 **/
	public static String domainName = SystemConfig.getStringValue("domain_name");
	/************************ 文件存放的常量 end **************************/

	/************************ 日期转换常量定义 start **************************/
	/**
	 * 中文日期 yyyy-MM-dd E
	 */
	public static DateFormat YYYYMMDDE = new SimpleDateFormat("yyyy-MM-dd E", Locale.CHINESE);

	/**
	 * yyyy-MM-dd
	 */
	public static DateFormat YYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static DateFormat YYYYMMDDHHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * yyyy-MM-dd HH:mm
	 */
	public static DateFormat YYYYMMDDHHMM = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	/**
	 * HH:mm
	 */
	public static DateFormat HHMM = new SimpleDateFormat("HH:mm");
	/**
	 * HHmm
	 */
	public static DateFormat hhmm = new SimpleDateFormat("HHmm");
	public static Integer STATUS_VALID;

	/************************ 日期转换常量定义 end **************************/

	/************************ 前后台传递参数常量定义 start **************************/
	/**
	 * 保存在session中的后台管理 用户登录信息键值常量
	 */
	public final static String SESSION_PLATFORM_USER_KEY = "platformUser";

	/**
	 * 保存在session中的医生端管理 用户登录信息键值常量
	 */
	public final static String SESSION_DOCTOR_USER_KEY = "doctorUser";
	/**
	 * 保存在session中的患者端管理 用户登录信息键值常量
	 */
	public final static String SESSION_PATIENT_USER_KEY = "patientUser";

	/**
	 * 保存在cookies中的登录信息键值常量
	 */
	public final static String COOKIES_USER_KEY = "cookiesUser";

	/**
	 * 保存在cookies中的登录账号信息键值常量
	 */
	public final static String COOKIES_LOGINACCOUNT_KEY = "cookiesLoginAccount";

	/**
	 * 保存在cookies中的登录密码信息键值常量
	 */
	public final static String COOKIES_LOGINPASSWORD_KEY = "cookiesLoginPassword";

	/************************ 前后台传递参数常量定义 end **************************/

	/************************ 字符常量定义 start ****************************/
	/**
	 * 全局分隔符
	 */
	public final static String GLOBAL_SEPARATOR = "_";
	/**
	 * 脱敏信息脱敏后的显示字符
	 */
	public static final String VIEW_SENSITIVE_CHAR = "*";

	/**
	 * session中key需要组合时的连接字符
	 */
	public static final String SESSION_KEY_CONCAT_CHAR = "-";
	/************************ 字符常量定义 end ****************************/

	/**
	 * 二维码上传路径
	 */
	public static final String QRCODE_PATH = SystemConfig.getStringValue("qrcode_path");

	/**
	 * DES加解密key
	 */
	public static final String DES_KEY_PATH = SystemConfig.getStringValue("des_key");

	/**
	 * 男
	 */
	public static final int SEX_MAN = 1;
	/**
	 * 女
	 */
	public static final int SEX_WOMEN = 0;

	
	public static final int NO = 0;
	public static final int YES = 1;
	/**
	 * 部分
	 */
	public static final int PART_YES = 2;

	/**
	 * 系统 file css  js 文件配置
	 */
	public static final String FILE_VIRTUAL_PATH = "file_virtual_path";
	public static final String CSS_VERSION = "css_version";
	public static final String JS_VERSION = "js_version";

	/**
	 * 验签基本常量
	 */
	public static final String STRING_SPLIT_CHAR = null;
	public static final String SESSION_PLATFORM_USER_ACCOUNT_KEY = null;
	public static final String STRING_AND_CHAR = null;
	public static final String STRING_ASSIGN_CHAR = null;
	
	/**
	 * 订单相关常量
	 */
	public static final String EH_COMMON_ORDER_SERIAL_NUMBER = null;
	public static final String EH_MEDICARE_ORDER_SERIAL_NUMBER = null;
	

}
