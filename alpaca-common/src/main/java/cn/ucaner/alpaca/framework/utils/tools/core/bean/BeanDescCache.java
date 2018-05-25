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

import cn.ucaner.alpaca.framework.utils.tools.core.lang.SimpleCache;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.bean   
* @ClassName：BeanDescCache   
* @Description：   <p>  Bean属性缓存 </p>
* 缓存用于防止多次反射造成的性能问题
* @Author： -    
* @CreatTime：2018年5月25日 下午12:51:02   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public enum BeanDescCache {
	
	INSTANCE;
	
	private SimpleCache<Class<?>, BeanDesc> bdCache = new SimpleCache<>();
	
	/**
	 * 获得属性名和{@link BeanDesc}Map映射
	 * @param beanClass Bean的类
	 * @return 属性名和{@link BeanDesc}映射
	 */
	public BeanDesc getBeanDesc(Class<?> beanClass){
		return bdCache.get(beanClass);
	}
	
	/**
	 * 加入缓存
	 * @param beanClass Bean的类
	 * @param BeanDesc 属性名和{@link BeanDesc}映射
	 */
	public void putBeanDesc(Class<?> beanClass, BeanDesc BeanDesc){
		bdCache.put(beanClass, BeanDesc);
	}
}
