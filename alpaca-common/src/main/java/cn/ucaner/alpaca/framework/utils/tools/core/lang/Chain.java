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
* @ClassName：Chain   
* @Description：   <p> 责任链接口 </p>
* @param <E> 元素类型
* @param <T> 目标类类型，用于返回this对象
* @Author： -    
* @CreatTime：2018年5月25日 上午11:21:36   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface Chain<E, T> extends Iterable<E>{
	/**
	 * 加入责任链
	 * @param element 责任链新的环节元素
	 * @return this
	 */
	T addChain(E element);
}
