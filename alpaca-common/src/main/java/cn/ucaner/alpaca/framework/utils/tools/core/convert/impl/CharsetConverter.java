package cn.ucaner.alpaca.framework.utils.tools.core.convert.impl;

import java.nio.charset.Charset;

import cn.ucaner.alpaca.framework.utils.tools.core.convert.AbstractConverter;
import cn.ucaner.alpaca.framework.utils.tools.core.util.CharsetUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.convert.impl   
* @ClassName：CharsetConverter   
* @Description：   <p> 编码对象转换器 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:05:10   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class CharsetConverter extends AbstractConverter<Charset>{

	@Override
	protected Charset convertInternal(Object value) {
		return CharsetUtil.charset(convertToStr(value));
	}

}
