package cn.ucaner.alpaca.framework.utils.tools.core.lang.mutable;

import java.io.Serializable;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.lang.mutable   
* @ClassName：MutableObj   
* @Description：   <p> 可变<code>Object</code> </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午10:49:06   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class MutableObj<T> implements Mutable<T>, Serializable {
	private static final long serialVersionUID = -464493129773743673L;

	private T value;

	/**
	 * 构造，空值
	 */
	public MutableObj() {
		super();
	}

	/**
	 * 构造
	 * 
	 * @param value 值
	 */
	public MutableObj(final T value) {
		super();
		this.value = value;
	}

	// -----------------------------------------------------------------------
	@Override
	public T get() {
		return this.value;
	}

	@Override
	public void set(final T value) {
		this.value = value;
	}

	// -----------------------------------------------------------------------
	@Override
	public boolean equals(final Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (this.getClass() == obj.getClass()) {
			final MutableObj<?> that = (MutableObj<?>) obj;
			return this.value.equals(that.value);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return value == null ? 0 : value.hashCode();
	}

	// -----------------------------------------------------------------------
	@Override
	public String toString() {
		return value == null ? "null" : value.toString();
	}

}
