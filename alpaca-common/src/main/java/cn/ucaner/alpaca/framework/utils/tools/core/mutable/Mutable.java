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
package cn.ucaner.alpaca.framework.utils.tools.core.mutable;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.mutable   
* @ClassName：Mutable   
* @Description：   <p> 提供可变值类型接口 <T> 值类型</p>
* @Author： -    
* @CreatTime：2018年5月25日 下午1:04:13   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface Mutable<T> {

	/**
	 * 获得原始值
	 * @return 原始值
	 */
	T get();

	/**
	 * 设置值
	 * @param value 值
	 */
	void set(T value);

}