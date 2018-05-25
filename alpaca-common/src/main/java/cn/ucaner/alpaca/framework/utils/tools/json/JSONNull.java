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
package cn.ucaner.alpaca.framework.utils.tools.json;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.json   
* @ClassName：JSONNull   
* @Description：   <p>  用于定义<code>null</code>，与Javascript中null相对应<br> 
* Java中的<code>null</code>值在js中表示为undefined。
* </p>
* @Author： - wubin   
* @CreatTime：2018年5月25日 上午10:58:42   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class JSONNull {
	
	/**
	 * <code>NULL</code> 对象用于减少歧义来表示Java 中的<code>null</code> <br>
	 * <code>NULL.equals(null)</code> 返回 <code>true</code>. <br>
	 * <code>NULL.toString()</code> 返回 <code>"null"</code>.
	 */
	public static final JSONNull NULL = new JSONNull();

	/**
	 * There is only intended to be a single instance of the NULL object, so the clone method returns itself.
	 *克隆方法只返回本身，此对象是个单例对象
	 *
	 * @return NULL.
	 */
	@Override
	protected final Object clone() {
		return this;
	}

	/**
	 * A Null object is equal to the null value and to itself.
	 * 对象与其本身和<code>null</code>值相等
	 *
	 * @param object An object to test for nullness.
	 * @return true if the object parameter is the JSONObject.NULL object or null.
	 */
	@Override
	public boolean equals(Object object) {
		return object == null || object == this;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * Get the "null" string value.
	 *获得“null”字符串
	 *
	 * @return The string "null".
	 */
	@Override
	public String toString() {
		return "null";
	}
}