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

import java.util.HashMap;
import java.util.Map;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.collection   
* @ClassName：CaseInsensitiveMap   
* @Description：   <p> 忽略大小写的Map </p>
* 对KEY忽略大小写，get("Value")和get("value")获得的值相同，put进入的值也会被覆盖
* @Author： -    
* @CreatTime：2018年5月25日 下午1:27:42   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class CaseInsensitiveMap<K, V> extends HashMap<K, V> {
	private static final long serialVersionUID = 4043263744224569870L;

	/**
	 * 构造
	 */
	public CaseInsensitiveMap() {
		super();
	}

	/**
	 * 构造
	 * 
	 * @param initialCapacity 初始大小
	 * @param loadFactor 加载因子
	 */
	public CaseInsensitiveMap(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	/**
	 * 构造
	 * 
	 * @param initialCapacity 初始大小
	 */
	public CaseInsensitiveMap(int initialCapacity) {
		this(initialCapacity, 0.75f);
	}

	/**
	 * 构造
	 * 
	 * @param m Map
	 */
	public CaseInsensitiveMap(Map<? extends K, ? extends V> m) {
		super((int) (m.size() / 0.75));
		putAll(m);
	}

	/**
	 * 构造
	 * 
	 * @param loadFactor 加载因子
	 * @param m Map
	 * @since 3.1.2
	 */
	public CaseInsensitiveMap(float loadFactor, Map<? extends K, ? extends V> m) {
		super(m.size(), loadFactor);
		putAll(m);
	}

	@Override
	public V get(Object key) {
		return super.get(lowerCaseKey(key));
	}

	@SuppressWarnings("unchecked")
	@Override
	public V put(K key, V value) {
		return super.put((K) lowerCaseKey(key), value);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
			this.put(entry.getKey(), entry.getValue());
		}
	}

	@Override
	public boolean containsKey(Object key) {
		return super.containsKey(lowerCaseKey(key));
	}

	/**
	 * 将Key转为小写
	 * 
	 * @param key KEY
	 * @return 小写KEy
	 */
	private static Object lowerCaseKey(Object key) {
		if (key instanceof CharSequence) {
			key = key.toString().toLowerCase();
		}
		return key;
	}
}
