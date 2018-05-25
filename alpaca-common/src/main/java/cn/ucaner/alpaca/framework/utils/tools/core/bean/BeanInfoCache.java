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
package cn.ucaner.alpaca.framework.utils.tools.core.bean;

import java.beans.PropertyDescriptor;
import java.util.Map;

import cn.ucaner.alpaca.framework.utils.tools.core.lang.SimpleCache;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.bean   
* @ClassName：BeanInfoCache   
* @Description：   <p> Bean属性缓存<br> </p>
*  缓存用于防止多次反射造成的性能问题
* @Author： -    
* @CreatTime：2018年5月25日 下午12:51:57   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public enum BeanInfoCache {
	INSTANCE;
	
	private SimpleCache<Class<?>, Map<String, PropertyDescriptor>> pdCache = new SimpleCache<>();
	private SimpleCache<Class<?>, Map<String, PropertyDescriptor>> ignoreCasePdCache = new SimpleCache<>();
	
	/**
	 * 获得属性名和{@link PropertyDescriptor}Map映射
	 * @param beanClass Bean的类
	 * @param ignoreCase 是否忽略大小写
	 * @return 属性名和{@link PropertyDescriptor}Map映射
	 */
	public Map<String, PropertyDescriptor> getPropertyDescriptorMap(Class<?> beanClass, boolean ignoreCase){
		return (ignoreCase ? ignoreCasePdCache : pdCache).get(beanClass);
	}
	
	/**
	 * 加入缓存
	 * @param beanClass Bean的类
	 * @param fieldNamePropertyDescriptorMap 属性名和{@link PropertyDescriptor}Map映射
	 * @param ignoreCase 是否忽略大小写
	 */
	public void putPropertyDescriptorMap(Class<?> beanClass, Map<String, PropertyDescriptor> fieldNamePropertyDescriptorMap, boolean ignoreCase){
		(ignoreCase ? ignoreCasePdCache : pdCache).put(beanClass, fieldNamePropertyDescriptorMap);
	}
}
