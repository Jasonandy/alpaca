package cn.ucaner.alpaca.framework.utils.tools.core.map;

import java.util.Map;

import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.map   
* @ClassName：CamelCaseLinkedMap   
* @Description：   <p> 驼峰Key风格的LinkedHashMap </p>
* 对KEY转换为驼峰，get("int_value")和get("intValue")获得的值相同，put进入的值也会被覆盖
* @Author： -    
* @CreatTime：2018年5月25日 下午11:58:42   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class CamelCaseLinkedMap<K, V> extends CustomKeyLinkedMap<K, V> {
	private static final long serialVersionUID = 4043263744224569870L;

	/**
	 * 构造
	 */
	public CamelCaseLinkedMap() {
		super();
	}

	/**
	 * 构造
	 * 
	 * @param initialCapacity 初始大小
	 * @param loadFactor 加载因子
	 */
	public CamelCaseLinkedMap(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	/**
	 * 构造
	 * 
	 * @param initialCapacity 初始大小
	 */
	public CamelCaseLinkedMap(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * 构造
	 * 
	 * @param m Map
	 */
	public CamelCaseLinkedMap(Map<? extends K, ? extends V> m) {
		super(m);
	}
	
	/**
	 * 将Key转为驼峰风格，如果key为字符串的话
	 * 
	 * @param key KEY
	 * @return 驼峰Key
	 */
	@Override
	protected Object customKey(Object key) {
		if (null != key && key instanceof CharSequence) {
			key = StrUtil.toCamelCase(key.toString());
		}
		return key;
	}
}
