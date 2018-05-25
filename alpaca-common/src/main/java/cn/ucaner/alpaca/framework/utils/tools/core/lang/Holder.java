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

import cn.ucaner.alpaca.framework.utils.tools.core.mutable.MutableObj;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.lang   
* @ClassName：Holder   
* @Description：   <p> 为不可变的对象引用提供一个可变的包装，在java中支持引用传递 </p>
* <T>所持有值类型
* @Author： -    
* @CreatTime：2018年5月25日 上午11:16:00   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public final class Holder<T> extends MutableObj<T>{
	private static final long serialVersionUID = -3119568580130118011L;

	/**
	 * 新建Holder类，持有指定值，当值为空时抛出空指针异常
	 * 
	 * @param <T> 被持有的对象类型
	 * @param value 值，不能为空
	 * @return Holder
	 */
	public static <T> Holder<T> of(T value) throws NullPointerException{
		if(null == value){
			throw new NullPointerException("Holder can not hold a null value!");
		}
		return new Holder<>(value);
	}
	
	//--------------------------------------------------------------------------- Constructor start
	/**
	 * 构造
	 */
	public Holder() {
		super();
	}
	
	/**
	 * 构造
	 * @param value 被包装的对象
	 */
	public Holder(T value) {
		super(value);
	}
	//--------------------------------------------------------------------------- Constructor end
}
