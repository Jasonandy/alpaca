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
package cn.ucaner.alpaca.framework.utils.tools.core.lang;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.lang   
* @ClassName：Func   
* @Description：   <p> 函数对象 </p>
* 接口灵感来自于<a href="http://actframework.org/">ActFramework</a><br>
* 一个函数接口代表一个一个函数，用于包装一个函数为对象<br>
*  在JDK8之前，Java的函数并不能作为参数传递，也不能作为返回值存在，此接口用于将一个函数包装成为一个对象，从而传递对象
* @Author： -    
* @CreatTime：2018年5月25日 上午11:17:04   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface Func<P, R> {
	/**
	 * 执行函数
	 * 
	 * @param parameters 参数列表
	 * @return 函数执行结果
	 */
	R call(@SuppressWarnings("unchecked") P... parameters);
}
