/**
 * <html>
 * <body>
 *  <P> Copyright 2014 JasonInternational Ucanx</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 20170828</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.alpaca.framework.common.spring.ext.config;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.util.CollectionUtils;

/**
* @Package：cn.ucaner.framework.common.spring.ext.config   
* @ClassName：ExtPropertyPlaceholderConfigurer   
* @Description：   <p> 扩展PropertyPlaceholderConfigurer 
*                     使应用中能使用spring的文件解析类库</p>
* @Author： - Jason 
* @CreatTime：2017年8月28日 下午4:57:18   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class ExtPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	
	public ExtPropertyPlaceholderConfigurer() {
		super();
	}

	/**
	* 描述:   by Jason
	* @return
	* @throws IOException  
	 */
	public Properties mergeProperties() throws IOException {
		Properties result = new Properties();
		// 加载本地的配置文件
		if (this.localOverride) {
			loadProperties(result);
		}
		// 加载本地的配置文件
		if (this.localProperties != null) {
			for (Properties localProp : this.localProperties) {
				CollectionUtils.mergePropertiesIntoMap(localProp, result);
			}
		}
		//从文件中加载属性,让这些属性覆盖   by Jason
		if (!this.localOverride) {
			loadProperties(result);
		}
		return result;
	}

	/**
	 * 将加载到的配置文件转换为 map 存储起来
	 * @param props
	 * @return
	 */
	public Map<String, String> convertPropsToMap(java.util.Properties props) {
		Map<String, String> propsMap = new HashMap<String, String>();
		Enumeration<?> propertyNames = props.propertyNames();
		do {
			if (!propertyNames.hasMoreElements()) {
				break;
			}
			java.lang.String propertyName = (java.lang.String) propertyNames.nextElement();
			java.lang.String propertyValue = props.getProperty(propertyName);
			propsMap.put(propertyName, propertyValue);
		} while (true);
		return propsMap;
	}
}
