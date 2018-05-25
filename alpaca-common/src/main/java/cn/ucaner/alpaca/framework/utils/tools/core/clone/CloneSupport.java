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
* @ClassName：CloneSupport   
* @Description：   <p> 克隆支持类，提供默认的克隆方法<T> 继承类的类型 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午1:27:07   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class CloneSupport<T> implements Cloneable<T>{
	
	@SuppressWarnings("unchecked")
	@Override
	public T clone() {
		try {
			return (T) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new CloneRuntimeException(e);
		}
	}
	
}
