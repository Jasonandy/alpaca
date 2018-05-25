package cn.ucaner.alpaca.framework.utils.tools.core.convert.impl;

import cn.ucaner.alpaca.framework.utils.tools.core.convert.AbstractConverter;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.convert.impl   
* @ClassName：StringConverter   
* @Description：   <p> 字符串转换器 </p>
* @Author： - wubin   
* @CreatTime：2018年5月25日 下午1:59:27   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class StringConverter extends AbstractConverter<String>{

	@Override
	protected String convertInternal(Object value) {
		return convertToStr(value);
	}

}
