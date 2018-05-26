package cn.ucaner.alpaca.framework.utils.tools.core.convert.impl;

import java.util.UUID;

import cn.ucaner.alpaca.framework.utils.tools.core.convert.AbstractConverter;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.convert.impl   
* @ClassName：UUIDConverter   
* @Description：   <p> UUID对象转换器转换器 </p>
* @Author： -    
* @CreatTime：2018年5月26日 上午10:32:57   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class UUIDConverter extends AbstractConverter<UUID> {

	@Override
	protected UUID convertInternal(Object value) {
		return UUID.fromString(convertToStr(value));
	}

}
