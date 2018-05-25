package cn.ucaner.alpaca.framework.utils.tools.core.convert.impl;

import java.io.File;
import java.net.URI;
import java.net.URL;

import cn.ucaner.alpaca.framework.utils.tools.core.convert.AbstractConverter;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.convert.impl   
* @ClassName：URLConverter   
* @Description：   <p> 字符串转换器 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午1:26:11   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class URLConverter extends AbstractConverter<URL>{

	@Override
	protected URL convertInternal(Object value) {
		try {
			if(value instanceof File){
				return ((File)value).toURI().toURL();
			}
			
			if(value instanceof URI){
				return ((URI)value).toURL();
			}
			return new URL(convertToStr(value));
		} catch (Exception e) {
			// Ignore Exception
		}
		return null;
	}

}
