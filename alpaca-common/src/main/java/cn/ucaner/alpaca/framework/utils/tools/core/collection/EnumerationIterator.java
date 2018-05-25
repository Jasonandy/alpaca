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
* @ClassName：EnumerationIterator   
* @Description：   <p> {@link Enumeration}对象转{@link Iterator}对象 </p>
* @Author： - wubin   
* @CreatTime：2018年5月25日 下午1:28:37   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class EnumerationIterator<E> implements Iterator<E>{
	
	private final Enumeration<E> e;
	
	/**
	 * 构造
	 * @param enumeration {@link Enumeration}对象
	 */
	public EnumerationIterator(Enumeration<E> enumeration) {
		this.e = enumeration;
	}

	@Override
	public boolean hasNext() {
		return e.hasMoreElements();
	}

	@Override
	public E next() {
		return e.nextElement();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
