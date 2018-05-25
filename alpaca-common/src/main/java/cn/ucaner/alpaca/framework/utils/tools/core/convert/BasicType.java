package cn.ucaner.alpaca.framework.utils.tools.core.convert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.convert   
* @ClassName：BasicType   
* @Description：   <p> 基本变量类型的枚举 </p>
* 基本类型枚举包括原始类型和包装类型
* @Author： -    
* @CreatTime：2018年5月25日 下午1:25:27   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public enum BasicType {
	BYTE, SHORT, INT, INTEGER, LONG, DOUBLE, FLOAT, BOOLEAN, CHAR, CHARACTER, STRING;
	
	/** 包装类型为Key，原始类型为Value，例如： Integer.class =》 int.class. */
	public static final Map<Class<?>, Class<?>> wrapperPrimitiveMap = new ConcurrentHashMap<>(8);
	/** 原始类型为Key，包装类型为Value，例如： int.class =》 Integer.class. */
	public static final Map<Class<?>, Class<?>> primitiveWrapperMap = new ConcurrentHashMap<>(8);
	
	static {
		wrapperPrimitiveMap.put(Boolean.class, boolean.class);
		wrapperPrimitiveMap.put(Byte.class, byte.class);
		wrapperPrimitiveMap.put(Character.class, char.class);
		wrapperPrimitiveMap.put(Double.class, double.class);
		wrapperPrimitiveMap.put(Float.class, float.class);
		wrapperPrimitiveMap.put(Integer.class, int.class);
		wrapperPrimitiveMap.put(Long.class, long.class);
		wrapperPrimitiveMap.put(Short.class, short.class);

		for (Map.Entry<Class<?>, Class<?>> entry : wrapperPrimitiveMap.entrySet()) {
			primitiveWrapperMap.put(entry.getValue(), entry.getKey());
		}
	}
	
	/**
	 * 原始类转为包装类，非原始类返回原类
	 * @param clazz 原始类
	 * @return 包装类
	 */
	public static Class<?> wrap(Class<?> clazz){
		if(null == clazz || false == clazz.isPrimitive()){
			return clazz;
		}
		Class<?> result = primitiveWrapperMap.get(clazz);
		return (null == result) ? clazz : result;
	}
	
	/**
	 * 包装类转为原始类，非包装类返回原类
	 * @param clazz 包装类
	 * @return 原始类
	 */
	public static Class<?> unWrap(Class<?> clazz){
		if(null == clazz || clazz.isPrimitive()){
			return clazz;
		}
		Class<?> result = wrapperPrimitiveMap.get(clazz);
		return (null == result) ? clazz : result;
	}
}
