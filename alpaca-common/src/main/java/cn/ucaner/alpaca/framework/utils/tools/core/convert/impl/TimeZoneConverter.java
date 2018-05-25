package cn.ucaner.alpaca.framework.utils.tools.core.convert.impl;

import java.util.TimeZone;

import cn.ucaner.alpaca.framework.utils.tools.core.convert.AbstractConverter;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.convert.impl   
* @ClassName：TimeZoneConverter   
* @Description：   <p> TimeZone转换器 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午1:58:43   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class TimeZoneConverter extends AbstractConverter<TimeZone>{

	@Override
	protected TimeZone convertInternal(Object value) {
		return TimeZone.getTimeZone(convertToStr(value));
	}

}
