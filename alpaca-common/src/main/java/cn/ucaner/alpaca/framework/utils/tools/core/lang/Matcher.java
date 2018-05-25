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
* @ClassName：Matcher   
* @Description：   <p> 匹配接口   <T> 匹配的对象类型 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午11:59:49   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface Matcher<T>{
	/**
	 * 给定对象是否匹配
	 * @param t 对象
	 * @return 是否匹配
	 */
	public boolean match(T t);
}
