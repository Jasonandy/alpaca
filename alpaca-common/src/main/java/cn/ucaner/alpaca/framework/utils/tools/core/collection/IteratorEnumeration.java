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
package cn.ucaner.alpaca.framework.utils.tools.core.collection;

import java.util.Enumeration;
import java.util.Iterator;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.collection   
* @ClassName：IteratorEnumeration   
* @Description：   <p> {@link Iterator}对象转{@link Enumeration} </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午1:28:49   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class IteratorEnumeration<E> implements Enumeration<E>{
	
	private final Iterator<E> iterator;
	
	/**
	 * 构造
	 * @param iterator {@link Iterator}对象
	 */
	public IteratorEnumeration(Iterator<E> iterator) {
		this.iterator = iterator;
	}

	@Override
	public boolean hasMoreElements() {
		return iterator.hasNext();
	}

	@Override
	public E nextElement() {
		return iterator.next();
	}

}
