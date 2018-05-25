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

import java.util.Map;

import cn.ucaner.alpaca.framework.utils.tools.core.util.MapUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.collection   
* @ClassName：MapBuilder   
* @Description：   <p> Map创建类  <K> Key类型  <V> Value类型</p>
* @Author： - wubin   
* @CreatTime：2018年5月25日 下午1:29:20   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class MapBuilder<K, V> {
	private Map<K, V> map;

	/**
	 * 链式Map创建类
	 * 
	 * @param map 要使用的Map实现类
	 */
	public MapBuilder(Map<K, V> map) {
		this.map = map;
	}

	/**
	 * 链式Map创建
	 * 
	 * @param k Key类型
	 * @param v Value类型
	 * @return 当前类
	 */
	public MapBuilder<K, V> put(K k, V v) {
		map.put(k, v);
		return this;
	}

	/**
	 * 链式Map创建
	 * 
	 * @param map 合并map
	 * @return 当前类
	 */
	public MapBuilder<K, V> putAll(Map<K, V> map) {
		this.map.putAll(map);
		return this;
	}

	/**
	 * 创建后的map
	 * 
	 * @return 创建后的map
	 */
	public Map<K, V> map() {
		return map;
	}

	/**
	 * 将map转成字符串
	 * 
	 * @param separator entry之间的连接符
	 * @param keyValueSeparator kv之间的连接符
	 * @return 连接字符串
	 */
	public String join(String separator, final String keyValueSeparator) {
		return MapUtil.join(this.map, separator, keyValueSeparator);
	}

	/**
	 * 将map转成字符串
	 * 
	 * @param separator entry之间的连接符
	 * @param keyValueSeparator kv之间的连接符
	 * @return 连接后的字符串
	 */
	public String joinIgnoreNull(String separator, final String keyValueSeparator) {
		return MapUtil.joinIgnoreNull(this.map, separator, keyValueSeparator);
	}

	/**
	 * 将map转成字符串
	 * 
	 * @param separator entry之间的连接符
	 * @param keyValueSeparator kv之间的连接符
	 * @param isIgnoreNull 是否忽略null的键和值
	 * @return 连接后的字符串
	 */
	public String join(String separator, final String keyValueSeparator, boolean isIgnoreNull) {
		return MapUtil.join(this.map, separator, keyValueSeparator, isIgnoreNull);
	}

}