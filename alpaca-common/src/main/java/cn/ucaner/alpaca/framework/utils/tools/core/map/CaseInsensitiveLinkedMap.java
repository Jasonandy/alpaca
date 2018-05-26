package cn.ucaner.alpaca.framework.utils.tools.core.map;

import java.util.Map;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.map   
* @ClassName：CaseInsensitiveLinkedMap   
* @Description：   <p> 忽略大小写的LinkedHashMap </p>
*  对KEY忽略大小写，get("Value")和get("value")获得的值相同，put进入的值也会被覆盖
* @Author： -    
* @CreatTime：2018年5月25日 下午11:59:33   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class CaseInsensitiveLinkedMap<K, V> extends CustomKeyLinkedMap<K, V> {
	private static final long serialVersionUID = 4043263744224569870L;

	/**
	 * 构造
	 */
	public CaseInsensitiveLinkedMap() {
		super();
	}

	/**
	 * 构造
	 * 
	 * @param initialCapacity 初始大小
	 * @param loadFactor 加载因子
	 */
	public CaseInsensitiveLinkedMap(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	/**
	 * 构造
	 * 
	 * @param initialCapacity 初始大小
	 */
	public CaseInsensitiveLinkedMap(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * 构造
	 * 
	 * @param m Map
	 */
	public CaseInsensitiveLinkedMap(Map<? extends K, ? extends V> m) {
		super(m);
	}

	/**
	 * 构造
	 * 
	 * @param loadFactor 加载因子
	 * @param m Map
	 * @since 3.1.2
	 */
	public CaseInsensitiveLinkedMap(float loadFactor, Map<? extends K, ? extends V> m) {
		super(loadFactor, m);
	}

	/**
	 * 将Key转为小写
	 * 
	 * @param key KEY
	 * @return 小写KEy
	 */
	@Override
	protected Object customKey(Object key) {
		if (null != key && key instanceof CharSequence) {
			key = key.toString().toLowerCase();
		}
		return key;
	}
}
