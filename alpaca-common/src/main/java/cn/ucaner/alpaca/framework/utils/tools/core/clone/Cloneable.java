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
package cn.ucaner.alpaca.framework.utils.tools.core.clone;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.clone   
* @ClassName：Cloneable   
* @Description：   <p> 克隆支持接口 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午1:26:34   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface Cloneable<T> extends java.lang.Cloneable{
	
	/**
	 * 克隆当前对象，浅复制
	 * @return 克隆后的对象
	 */
	T clone();
}
