package cn.ucaner.alpaca.framework.utils.tools.core.convert.impl;

import cn.ucaner.alpaca.framework.utils.tools.core.convert.AbstractConverter;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.convert.impl   
* @ClassName：BooleanConverter   
* @Description：   <p> Booelan 转换器</p>
* @Author： - wubin   
* @CreatTime：2018年5月25日 下午2:08:12   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class BooleanConverter extends AbstractConverter<Boolean>{

	@Override
	protected Boolean convertInternal(Object value) {
		if(boolean.class == value.getClass()){
			return Boolean.valueOf((boolean)value);
		}
		String valueStr = convertToStr(value);
		return Boolean.valueOf(PrimitiveConverter.parseBoolean(valueStr));
	}

}
