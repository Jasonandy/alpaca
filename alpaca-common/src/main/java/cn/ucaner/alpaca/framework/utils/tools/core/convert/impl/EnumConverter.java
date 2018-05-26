package cn.ucaner.alpaca.framework.utils.tools.core.convert.impl;

import cn.ucaner.alpaca.framework.utils.tools.core.convert.AbstractConverter;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.convert.impl   
* @ClassName：EnumConverter   
* @Description：   <p> 无泛型检查的枚举转换器 </p>
* @Author： -    
* @CreatTime：2018年5月26日 下午2:08:16   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class EnumConverter extends AbstractConverter<Object> {

	private Class enumClass;
	
	/**
	 * 构造
	 * 
	 * @param enumClass 转换成的目标Enum类
	 */
	public EnumConverter(Class enumClass) {
		this.enumClass = enumClass;
	}

	@Override
	protected Object convertInternal(Object value) {
		return Enum.valueOf(enumClass, convertToStr(value));
	}

	@Override
	public Class getTargetType() {
		return this.enumClass;
	}
}
