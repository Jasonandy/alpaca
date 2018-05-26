package cn.ucaner.alpaca.framework.utils.tools.core.convert.impl;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

import cn.ucaner.alpaca.framework.utils.tools.core.convert.AbstractConverter;
import cn.ucaner.alpaca.framework.utils.tools.core.convert.ConverterRegistry;
import cn.ucaner.alpaca.framework.utils.tools.core.util.TypeUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.convert.impl   
* @ClassName：AtomicReferenceConverter   
* @Description：   <p> {@link AtomicReference}转换器 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:08:38   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
@SuppressWarnings("rawtypes")
public class AtomicReferenceConverter extends AbstractConverter<AtomicReference> {
	
	@Override
	protected AtomicReference<?> convertInternal(Object value) {
		
		//尝试将值转换为Reference泛型的类型
		Object targetValue = null;
		final Type paramType = TypeUtil.getTypeArgument(AtomicReference.class);
		if(null != paramType){
			targetValue = ConverterRegistry.getInstance().convert(paramType, value);
		}
		if(null == targetValue){
			targetValue = value;
		}
		
		return new AtomicReference<>(targetValue);
	}

}
