package cn.ucaner.alpaca.framework.utils.tools.core.convert.impl;

import java.util.Map;
import java.util.Map.Entry;

import cn.ucaner.alpaca.framework.utils.tools.core.bean.BeanUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.convert.AbstractConverter;
import cn.ucaner.alpaca.framework.utils.tools.core.convert.ConverterRegistry;
import cn.ucaner.alpaca.framework.utils.tools.core.util.ClassUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.CollectionUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.convert.impl   
* @ClassName：MapConverter   
* @Description：   <p> {@link Map} 转换器 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:03:27   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class MapConverter extends AbstractConverter<Map<?, ?>> {
	
	/** Map类型 */
	private final Class<?> mapType;
	/** 键类型 */
	private final Class<?> keyType;
	/** 值类型 */
	private final Class<?> valueType;
	
	/**
	 * 构造
	 * @param mapType Map类型
	 */
	public MapConverter(Class<?> mapType) {
		this.mapType = mapType;
		this.keyType = ClassUtil.getTypeArgument(mapType, 0);
		this.valueType = ClassUtil.getTypeArgument(mapType, 1);
	}
	
	/**
	 * 构造
	 * @param mapType Map类型
	 * @param keyType 键类型
	 * @param valueType 值类型
	 */
	public MapConverter(Class<?> mapType, Class<?> keyType, Class<?> valueType) {
		this.mapType = mapType;
		this.keyType = keyType;
		this.valueType = valueType;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected Map<?, ?> convertInternal(Object value) {
		Map map = CollectionUtil.createMap(mapType);
		
		Class<?> valueType = value.getClass();
		if(value instanceof Map){
			convertMapToMap((Map)value, map);
		}else if(BeanUtil.isBean(valueType)){
			BeanUtil.beanToMap(map);
		}else{
			throw new UnsupportedOperationException(StrUtil.format("Unsupport toMap value type: {}", valueType.getName()));
		}
		return map;
	}

	/**
	 * Map转Map
	 * @param srcMap 源Map
	 * @param targetMap 目标Map
	 */
	private void convertMapToMap(Map<?, ?> srcMap, Map<Object, Object> targetMap){
		final ConverterRegistry convert = ConverterRegistry.getInstance();
		for (Entry<?, ?> entry : srcMap.entrySet()) {
			targetMap.put(convert.convert(this.keyType, entry.getKey()), convert.convert(this.valueType, entry.getValue()));
		}
	}
}
