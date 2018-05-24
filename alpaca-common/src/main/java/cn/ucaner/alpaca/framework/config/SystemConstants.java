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
package cn.ucaner.alpaca.framework.config;

/**
* @Package：cn.ucaner.framework.config   
* @ClassName：SystemConstants   
* @Description：   <p> 系统常量配置</p>
* @Author： - Jason 
* @CreatTime：2017年8月30日 下午1:49:46   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class SystemConstants {
	
	/**
	 * 文件分隔符
	 */
	public static final String FILE_SEPARATOR = System.getProperty("file.separator");
	
	/**
	 * 版本
	 */
	public static final String VERSION_TYPE_RC = "rc";
	public static final String VERSION_TYPE_DEV = "dev";
	public static final String VERSION_TYPE_DEF = "dev";

	public static final String FILE_CALSS_PATH = "classpath:/";

	public static final String FILE_SPLIT_CHAR = ",";

	public static final String YCT_FRAMEWORK_CONFIG_START_PREFIX = "framework_";
	public static final String YCT_FRAMEWORK_CONFIG_FILE_TYPE = ".properties";

	public static final String YCT_FRAMEWORK_CONFIG_DEF = "framework_dev.properties";
	
	/**
	 * 服务配置文件
	 */
	public static final String SERVICE_CONFIG = "service.properties";
	/**
	 * 接口配置文件
	 */
	public static final String INTERFACE_CONFIG = "provider_services/interface.properties";
}
