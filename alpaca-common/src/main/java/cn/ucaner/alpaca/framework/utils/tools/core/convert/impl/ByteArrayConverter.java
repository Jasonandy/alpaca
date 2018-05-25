package cn.ucaner.alpaca.framework.utils.tools.core.convert.impl;

import cn.ucaner.alpaca.framework.utils.tools.core.convert.AbstractConverter;
import cn.ucaner.alpaca.framework.utils.tools.core.convert.ConverterRegistry;
import cn.ucaner.alpaca.framework.utils.tools.core.util.ArrayUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.convert.impl   
* @ClassName：ByteArrayConverter   
* @Description：   <p> byte 类型数组转换器 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:07:50   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class ByteArrayConverter extends AbstractConverter<byte[]>{
	
	@Override
	protected byte[] convertInternal(Object value) {
		final Byte[] result = ConverterRegistry.getInstance().convert(Byte[].class, value);
		return ArrayUtil.unWrap(result);
	}

}
