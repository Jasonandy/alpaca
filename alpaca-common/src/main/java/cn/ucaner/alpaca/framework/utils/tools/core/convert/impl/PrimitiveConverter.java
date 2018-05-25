package cn.ucaner.alpaca.framework.utils.tools.core.convert.impl;

import cn.ucaner.alpaca.framework.utils.tools.core.convert.AbstractConverter;
import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.convert.impl   
* @ClassName：PrimitiveConverter   
* @Description：   <p> 原始类型转换器 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:00:16   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class PrimitiveConverter extends AbstractConverter<Object> {
	
	private Class<?> targetType;

	/**
	 * 构造<br>
	 * @param clazz 需要转换的原始
	 * @throws IllegalArgumentException 传入的转换类型非原始类型时抛出
	 */
	public PrimitiveConverter(Class<?> clazz) {
		if(null == clazz){
			throw new NullPointerException("PrimitiveConverter not allow null target type!");
		}else if(false == clazz.isPrimitive()){
			throw new IllegalArgumentException("[" + clazz + "] is not a primitive class!");
		}
		this.targetType = clazz;
	}

	@Override
	protected Object convertInternal(Object value) {
		try {
			if (byte.class == this.targetType) {
				if (value instanceof Number) {
					return ((Number) value).byteValue();
				}
				final String valueStr = convertToStr(value);
				if (StrUtil.isBlank(valueStr)) {
					return 0;
				}
				return Byte.parseByte(valueStr);
				
			} else if (short.class == this.targetType) {
				if (value instanceof Number) {
					return ((Number) value).shortValue();
				}
				final String valueStr = convertToStr(value);
				if (StrUtil.isBlank(valueStr)) {
					return 0;
				}
				return Short.parseShort(valueStr);
				
			} else if (int.class == this.targetType) {
				if (value instanceof Number) {
					return ((Number) value).intValue();
				}
				final String valueStr = convertToStr(value);
				if (StrUtil.isBlank(valueStr)) {
					return 0;
				}
				return Integer.parseInt(valueStr);
				
			} else if (long.class == this.targetType) {
				if (value instanceof Number) {
					return ((Number) value).longValue();
				}
				final String valueStr = convertToStr(value);
				if (StrUtil.isBlank(valueStr)) {
					return 0;
				}
				return Long.parseLong(valueStr);
				
			} else if (float.class == this.targetType) {
				if (value instanceof Number) {
					return ((Number) value).floatValue();
				}
				final String valueStr = convertToStr(value);
				if (StrUtil.isBlank(valueStr)) {
					return 0;
				}
				return Float.parseFloat(valueStr);
				
			} else if (double.class == this.targetType) {
				if (value instanceof Number) {
					return ((Number) value).doubleValue();
				}
				final String valueStr = convertToStr(value);
				if (StrUtil.isBlank(valueStr)) {
					return 0;
				}
				return Double.parseDouble(valueStr);
				
			} else if (char.class == this.targetType) {
				if(value instanceof Character){
					return ((Character)value).charValue();
				}
				final String valueStr = convertToStr(value);
				if (StrUtil.isBlank(valueStr)) {
					return 0;
				}
				return valueStr.charAt(0);
			} else if (boolean.class == this.targetType) {
				if(value instanceof Boolean){
					return ((Boolean)value).booleanValue();
				}
				String valueStr = convertToStr(value);
				return parseBoolean(valueStr);
			}
		} catch (Exception e) {
			// Ignore Exception
		}
		return 0;
	}
	
	/**
	 * 转换字符串为boolean值
	 * @param valueStr 字符串
	 * @return boolean值
	 */
	static boolean parseBoolean(String valueStr){
		if (StrUtil.isNotBlank(valueStr)) {
			valueStr = valueStr.trim().toLowerCase();
			switch (valueStr) {
				case "true":
					return true;
				case "false":
					return false;
				case "yes":
					return true;
				case "y":
					return true;
				case "ok":
					return true;
				case "no":
					return false;
				case "n":
					return false;
				case "1":
					return true;
				case "0":
					return false;
			}
		}
		return false;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Class<Object> getTargetType() {
		return (Class<Object>) this.targetType;
	}
}
