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
package cn.ucaner.alpaca.framework.utils.tools.core.mutable;

import cn.ucaner.alpaca.framework.utils.tools.core.util.NumberUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.mutable   
* @ClassName：MutableLong   
* @Description：   <p>  可变 <code>long</code> 类型 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午1:06:03   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class MutableLong extends Number implements Comparable<MutableLong>, Mutable<Number> {
	private static final long serialVersionUID = -7982037656814990915L;
	
	private long value;

	/**
	 * 构造，默认值0
	 */
	public MutableLong() {
		super();
	}

	/**
	 * 构造
	 * @param value 值
	 */
	public MutableLong(final long value) {
		super();
		this.value = value;
	}

	/**
	 * 构造
	 * @param value 值
	 */
	public MutableLong(final Number value) {
		this(value.longValue());
	}

	/**
	 * 构造
	 * @param value String值
	 * @throws NumberFormatException 数字转换错误
	 */
	public MutableLong(final String value) throws NumberFormatException {
		super();
		this.value = Long.parseLong(value);
	}

	@Override
	public Long get() {
		return Long.valueOf(this.value);
	}

	/**
	 * 设置值
	 * @param value 值
	 */
	public void set(final long value) {
		this.value = value;
	}

	@Override
	public void set(final Number value) {
		this.value = value.longValue();
	}

	// -----------------------------------------------------------------------
	/**
	 * 值+1
	 * @return this
	 */
	public MutableLong increment() {
		value++;
		return this;
	}

	/**
	 * 值减一
	 * @return this
	 */
	public MutableLong decrement() {
		value--;
		return this;
	}

	// -----------------------------------------------------------------------
	/**
	 * 增加值
	 * @param operand 被增加的值
	 * @return this
	 */
	public MutableLong add(final long operand) {
		this.value += operand;
		return this;
	}

	/**
	 * 增加值
	 * @param operand 被增加的值，非空
	 * @return this
	 * @throws NullPointerException if the object is null
	 */
	public MutableLong add(final Number operand) {
		this.value += operand.longValue();
		return this;
	}

	/**
	 * 减去值
	 * 
	 * @param operand 被减的值
	 * @return this
	 */
	public MutableLong subtract(final long operand) {
		this.value -= operand;
		return this;
	}

	/**
	 * 减去值
	 * 
	 * @param operand 被减的值，非空
	 * @return this
	 * @throws NullPointerException if the object is null
	 */
	public MutableLong subtract(final Number operand) {
		this.value -= operand.longValue();
		return this;
	}

	// -----------------------------------------------------------------------
	@Override
	public int intValue() {
		return (int) value;
	}

	@Override
	public long longValue() {
		return value;
	}

	@Override
	public float floatValue() {
		return value;
	}

	@Override
	public double doubleValue() {
		return value;
	}

	// -----------------------------------------------------------------------
	/**
	 * 相等需同时满足如下条件：
	 * <ol>
	 * 	<li>非空</li>
	 * 	<li>类型为 {@link MutableLong}</li>
	 * 	<li>值相等</li>
	 * </ol>
	 * 
	 * @param obj 比对的对象
	 * @return 相同返回<code>true</code>，否则 <code>false</code>
	 */
	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof MutableLong) {
			return value == ((MutableLong) obj).longValue();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (int) (value ^ (value >>> 32));
	}

	// -----------------------------------------------------------------------
	/**
	 * 比较
	 * 
	 * @param other 其它 {@link MutableLong} 对象
	 * @return x==y返回0，x&lt;y返回-1，x&gt;y返回1
	 */
	@Override
	public int compareTo(final MutableLong other) {
		return NumberUtil.compare(this.value, other.value);
	}

	// -----------------------------------------------------------------------
	@Override
	public String toString() {
		return String.valueOf(value);
	}

}
