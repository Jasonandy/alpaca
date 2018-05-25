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
package cn.ucaner.alpaca.framework.utils.tools.http;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cn.ucaner.alpaca.framework.utils.tools.core.util.CharsetUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.CollectionUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.http   
* @ClassName：HttpBase   
* @Description：   <p> http基类</p>
* <T> 子类类型，方便链式编程
* @Author： -    
* @CreatTime：2018年5月25日 上午11:04:59   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
@SuppressWarnings("unchecked")
public abstract class HttpBase<T> {

	/**HTTP/1.0*/
	public static final String HTTP_1_0 = "HTTP/1.0";
	/**HTTP/1.1*/
	public static final String HTTP_1_1 = "HTTP/1.1";
	
	/**存储头信息*/
	protected Map<String, List<String>> headers = new HashMap<String, List<String>>();
	/**编码*/
	protected Charset charset = CharsetUtil.CHARSET_UTF_8;
	/**http版本*/
	protected String httpVersion = HTTP_1_1;
	/**存储主体*/
	protected String body;
	
	// ---------------------------------------------------------------- Headers start
	/**
	 * 根据name获取头信息
	 * @param name Header名
	 * @return Header值
	 */
	public String header(String name) {
		final List<String> values = headerList(name);
		if(CollectionUtil.isEmpty(values)) {
			return null;
		}
		return values.get(0);
	}
	
	/**
	 * 根据name获取头信息列表
	 * @param name Header名
	 * @return Header值
	 * @since 3.1.1
	 */
	public List<String> headerList(String name) {
		if(StrUtil.isBlank(name)) {
			return null;
		}
		
		return headers.get(name.trim());
	}
	
	/**
	 * 根据name获取头信息
	 * @param name Header名
	 * @return Header值
	 */
	public String header(Header name) {
		if(null == name) {
			return null;
		}
		return header(name.toString());
	}
	
	/**
	 * 设置一个header<br>
	 * 如果覆盖模式，则替换之前的值，否则加入到值列表中
	 * @param name Header名
	 * @param value Header值
	 * @param isOverride 是否覆盖已有值
	 * @return T 本身
	 */
	public T header(String name, String value, boolean isOverride) {
		if(null != name && null != value){
			final List<String> values = headers.get(name.trim());
			if(isOverride || CollectionUtil.isEmpty(values)) {
				final ArrayList<String> valueList = new ArrayList<String>();
				valueList.add(value);
				headers.put(name.trim(), valueList);
			}else {
				values.add(value.trim());
			}
		}
		return (T) this;
	}
	
	/**
	 * 设置一个header<br>
	 * 如果覆盖模式，则替换之前的值，否则加入到值列表中
	 * @param name Header名
	 * @param value Header值
	 * @param isOverride 是否覆盖已有值
	 * @return T 本身
	 */
	public T header(Header name, String value, boolean isOverride) {
		return header(name.toString(), value, isOverride);
	}
	
	/**
	 * 设置一个header<br>
	 * 覆盖模式，则替换之前的值
	 * @param name Header名
	 * @param value Header值
	 * @return T 本身
	 */
	public T header(Header name, String value) {
		return header(name.toString(), value, true);
	}
	
	/**
	 * 设置一个header<br>
	 * 覆盖模式，则替换之前的值
	 * @param name Header名
	 * @param value Header值
	 * @return T 本身
	 */
	public T header(String name, String value) {
		return header(name, value, true);
	}
	
	/**
	 * 设置请求头<br>
	 * 不覆盖原有请求头
	 * 
	 * @param headers 请求头
	 * @return this
	 */
	public T header(Map<String, List<String>> headers) {
		if(CollectionUtil.isEmpty(headers)) {
			return (T)this;
		}
		
		String name;
		for (Entry<String, List<String>> entry : headers.entrySet()) {
			name = entry.getKey();
			for (String value : entry.getValue()) {
				this.header(name, StrUtil.nullToEmpty(value), false);
			}
		}
		return (T)this;
	}
	
	/**
	 * 移除一个头信息
	 * @param name Header名
	 * @return this
	 */
	public T removeHeader(String name) {
		if(name != null) {
			headers.remove(name.trim());
		}
		return (T)this;
	}
	
	/**
	 * 移除一个头信息
	 * @param name Header名
	 * @return this
	 */
	public T removeHeader(Header name) {
		return removeHeader(name.toString());
	}

	/**
	 * 获取headers
	 * @return Headers Map
	 */
	public Map<String, List<String>> headers() {
		return Collections.unmodifiableMap(headers);
	}
	// ---------------------------------------------------------------- Headers end
	
	/**
	 * 返回http版本
	 * @return String
	 */
	public String httpVersion() {
		return httpVersion;
	}
	/**
	 * 设置http版本
	 * 
	 * @param httpVersion Http版本，{@link HttpBase#HTTP_1_0}，{@link HttpBase#HTTP_1_1}
	 * @return this
	 */
	public T httpVersion(String httpVersion) {
		this.httpVersion = httpVersion;
		return (T) this;
	}

	/**
	 * 返回字符集
	 * @return 字符集
	 */
	public String charset() {
		return charset.name();
	}
	
	/**
	 * 设置字符集
	 * @param charset 字符集
	 * @return T 自己
	 * @see CharsetUtil
	 */
	public T charset(String charset) {
		if(StrUtil.isNotBlank(charset)){
			this.charset = Charset.forName(charset);
		}
		return (T) this;
	}
	
	/**
	 * 设置字符集
	 * @param charset 字符集
	 * @return T 自己
	 * @see CharsetUtil
	 */
	public T charset(Charset charset) {
		if(null != charset){
			this.charset = charset;
		}
		return (T) this;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = StrUtil.builder();
		sb.append("Request Headers: ").append(StrUtil.CRLF);
		for (Entry<String, List<String>> entry : this.headers.entrySet()) {
			sb.append("    ").append(entry).append(StrUtil.CRLF);
		}
		
		sb.append("Request Body: ").append(StrUtil.CRLF);
		sb.append("    ").append(this.body).append(StrUtil.CRLF);
		
		return sb.toString();
	}
}
