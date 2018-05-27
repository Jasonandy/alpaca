package cn.ucaner.alpaca.framework.utils.tools.core.convert.impl;

import cn.ucaner.alpaca.framework.utils.tools.core.convert.AbstractConverter;
import cn.ucaner.alpaca.framework.utils.tools.core.convert.ConvertException;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.convert.impl   
* @ClassName：CastConverter   
* @Description：   <p> 强转转换器 </p>
* @Author： -    
* @CreatTime：2018年5月26日 上午10:31:40   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class CastConverter<T> extends AbstractConverter<T> {

	private Class<T> targetType;

	@Override
	protected T convertInternal(Object value) {
		// 由于在AbstractConverter中已经有类型判断并强制转换，因此当在上一步强制转换失败时直接抛出异常
		throw new ConvertException("Can not cast value to [{}]", this.targetType);
	}

	@Override
	public Class<T> getTargetType() {
		return this.targetType;
	}
}
