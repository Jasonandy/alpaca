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
package cn.ucaner.alpaca.framework.utils.tools.core.comparator;

import java.io.Serializable;
import java.util.Comparator;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.comparator   
* @ClassName：ComparableComparator   
* @Description：   <p> 针对 {@link Comparable}对象的默认比较器 <E> 比较对象类型 </p>
* @Author： -    
* @CreatTime：2018年6月5日 上午12:09:53   
* @Modify By：   
* @ModifyTime：  2018年6月5日
* @Modify marker：   
* @version    V1.0
 */
public class ComparableComparator<E extends Comparable<? super E>> implements Comparator<E>, Serializable {
	private static final long serialVersionUID = 3020871676147289162L;

	/** 单例 */
	@SuppressWarnings("rawtypes")
	public static final ComparableComparator INSTANCE = new ComparableComparator<>();

	/**
	 * 构造
	 */
	public ComparableComparator() {
		super();
	}

	/**
	 * 比较两个{@link Comparable}对象
	 * 
	 * <pre>
	 * obj1.compareTo(obj2)
	 * </pre>
	 *
	 * @param obj1 被比较的第一个对象
	 * @param obj2 the second object to compare
	 * @return obj1小返回负数，大返回正数，否则返回0
	 * @throws NullPointerException obj1为{@code null}或者比较中抛出空指针异常
	 */
	@Override
	public int compare(final E obj1, final E obj2) {
		return obj1.compareTo(obj2);
	}

	@Override
	public int hashCode() {
		return "ComparableComparator".hashCode();
	}

	@Override
	public boolean equals(final Object object) {
		return this == object || null != object && object.getClass().equals(this.getClass());
	}

}