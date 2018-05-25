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
* @Package：cn.ucaner.tools.core.lang   
* @ClassName：Filter   
* @Description：   <p> 过滤器接口</p>
* @Author： -  
* @CreatTime：2017-11-3 上午9:42:40   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public interface Filter<T> {
	
	/**
	 * 是否接受对象
	 * @param t 检查的对象
	 * @return 是否接受对象
	 */
	boolean accept(T t);
	
}