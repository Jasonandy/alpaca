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

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ucaner.alpaca.framework.common.spring.ext.SpringContextHolder;
import cn.ucaner.alpaca.framework.common.spring.ext.config.ExtPropertyPlaceholderConfigurer;

/**
* @Package：cn.ucaner.framework.config   
* @ClassName：SystemConfig   
* @Description：   <p> 系统配置 </p>
* @Author： - Jason 
* @CreatTime：2017年8月30日 下午1:49:57   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class SystemConfig {
	
	private static Logger logger = LoggerFactory.getLogger(SystemConfig.class);
	
	/**
	 * 系统的配置参数
	 */
	private static Map<String, String> systemConfigMap = new HashMap<String, String>();
	
	/**
	 * 系统标记码 by Jason
	 */
	private static final String SIGN_CODE = "Alapaca";

	/**
	 * 业务规则集合
	 */
	private SystemConfig() {
		
	}

	public static String getSignCode() {
		return SIGN_CODE;
	}
	
	/**
	 * 加载系统配置文件
	 */
	public static void loadSystemConfig() {
		ExtPropertyPlaceholderConfigurer propsConfig = SpringContextHolder.getBean(ExtPropertyPlaceholderConfigurer.class);
		try {
			Properties props = propsConfig.mergeProperties();
			//使用spring的文件解析类库 将加载到的配置文件的数据转存到 系统配置map中   by Jason
			systemConfigMap.putAll(propsConfig.convertPropsToMap(props));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("system params:{}", systemConfigMap);
		}
	}

	/**
	 * 添加参数
	 * @param key
	 * @param value
	 */
	public static void put(String key, String value) {
		systemConfigMap.put(key, value);
	}

	/**
	 * 根据key值返回value
	 * @param key
	 * @return
	 */
	private static String getValue(String key) {
		return systemConfigMap.get(key);
	}

	/**
	 * 根据key值返回String类型的value.
	 */
	public static String getStringValue(String key) {
		return getValue(key);
	}

	/**
	 * 根据key值返回Integer类型的value.如果都为Null返回Default值,如果内容错误则抛出异常
	 */
	public static String getStringValue(String key, String defaultValue) {
		String value = getValue(key);
		return value != null ? value : defaultValue;
	}

	/**
	 * 根据key值返回Integer类型的value.
	 * 如果都为Null或内容错误则抛出异常.
	 */
	public static Integer getIntegerValue(String key) {
		String value = getValue(key);
		if (value == null) {
			throw new NoSuchElementException();
		}
		return Integer.valueOf(value);
	}

	/**
	 * 根据key值返回Integer类型的value.
	 * 如果都为Null返回Default值,如果内容错误则抛出异常
	 */
	public static Integer getInteger(String key, Integer defaultValue) {
		String value = getValue(key);
		return value != null ? Integer.valueOf(value) : defaultValue;
	}

	/**
	 * 根据key值返回Double类型的value.
	 * 如果都为Null或内容错误则抛出异常.
	 */
	public static Double getDoubleValue(String key) {
		String value = getValue(key);
		if (value == null) {
			throw new NoSuchElementException();
		}
		return Double.valueOf(value);
	}

	/**
	 * 根据key值返回Double类型的value.
	 * 如果都為Null則返回Default值，如果内容错误则抛出异常
	 */
	public static Double getDoubleValue(String key, Integer defaultValue) {
		String value = getValue(key);
		return value != null ? Double.valueOf(value) : defaultValue;
	}

	/**
	 * 根据key值返回Boolean类型的value.
	 * 如果都為Null抛出异常,如果内容不是true/false则返回false.
	 */
	public static Boolean getBooleanValue(String key) {
		String value = getValue(key);
		if (value == null) {
			throw new NoSuchElementException();
		}
		return Boolean.valueOf(value);
	}

	/**
	 * 根据key值返回Boolean类型的value.
	 * 如果都为Null返回Default值,如果内容不为true/false则返回false.
	 */
	public static Boolean getBooleanValue(String key, boolean defaultValue) {
		String value = getValue(key);
		return value != null ? Boolean.valueOf(value) : defaultValue;
	}
}
