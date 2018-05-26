package cn.ucaner.alpaca.framework.utils.tools.core.convert.impl;

import cn.ucaner.alpaca.framework.utils.tools.core.convert.AbstractConverter;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.convert.impl   
* @ClassName：GenericEnumConverter   
* @Description：   <p> 泛型枚举转换器 </p>
* @Author： -    
* @CreatTime：2018年5月26日 下午2:08:33   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class GenericEnumConverter<E extends Enum<E>> extends AbstractConverter<E> {

	private Class<E> enumClass;
	
	/**
	 * 构造
	 * 
	 * @param enumClass 转换成的目标Enum类
	 */
	public GenericEnumConverter(Class<E> enumClass) {
		this.enumClass = enumClass;
	}

	@Override
	protected E convertInternal(Object value) {
		return Enum.valueOf(enumClass, convertToStr(value));
	}

	@Override
	public Class<E> getTargetType() {
		return this.enumClass;
	}
}
