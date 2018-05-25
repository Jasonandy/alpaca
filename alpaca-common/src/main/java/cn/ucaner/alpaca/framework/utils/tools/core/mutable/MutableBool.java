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

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.mutable   
* @ClassName：MutableBool   
* @Description：   <p> 可变 <code>boolean</code> 类型 </p>
* @Author： - wubin   
* @CreatTime：2018年5月25日 下午1:04:32   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class MutableBool implements Comparable<MutableBool>, Mutable<Boolean> {
	
	private boolean value;

	/**
	 * 构造，默认值0
	 */
	public MutableBool() {
		super();
	}

	/**
	 * 构造
	 * @param value 值
	 */
	public MutableBool(final boolean value) {
		super();
		this.value = value;
	}

	/**
	 * 构造
	 * @param value String值
	 * @throws NumberFormatException 转为Boolean错误
	 */
	public MutableBool(final String value) throws NumberFormatException {
		super();
		this.value = Boolean.parseBoolean(value);
	}

	@Override
	public Boolean get() {
		return Boolean.valueOf(this.value);
	}

	/**
	 * 设置值
	 * @param value 值
	 */
	public void set(final boolean value) {
		this.value = value;
	}

	@Override
	public void set(final Boolean value) {
		this.value = value.booleanValue();
	}

	// -----------------------------------------------------------------------
	/**
	 * 相等需同时满足如下条件：
	 * <ol>
	 * 	<li>非空</li>
	 * 	<li>类型为 {@link MutableBool}</li>
	 * 	<li>值相等</li>
	 * </ol>
	 * 
	 * @param obj 比对的对象
	 * @return 相同返回<code>true</code>，否则 <code>false</code>
	 */
	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof MutableBool) {
			return value == ((MutableBool) obj).value;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return value ? Boolean.TRUE.hashCode() : Boolean.FALSE.hashCode();
	}

	// -----------------------------------------------------------------------
	/**
	 * 比较
	 * 
	 * @param other 其它 {@link MutableBool} 对象
	 * @return x==y返回0，x&lt;y返回-1，x&gt;y返回1
	 */
	@Override
	public int compareTo(final MutableBool other) {
		return Boolean.compare(this.value, other.value);
	}

	// -----------------------------------------------------------------------
	@Override
	public String toString() {
		return String.valueOf(value);
	}

}
