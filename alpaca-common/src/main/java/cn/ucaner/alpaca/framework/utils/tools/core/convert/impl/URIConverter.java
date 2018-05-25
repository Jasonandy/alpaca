package cn.ucaner.alpaca.framework.utils.tools.core.convert.impl;

import java.io.File;
import java.net.URI;
import java.net.URL;

import cn.ucaner.alpaca.framework.utils.tools.core.convert.AbstractConverter;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.convert.impl   
* @ClassName：URIConverter   
* @Description：   <p> URI转换器 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午1:59:02   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class URIConverter extends AbstractConverter<URI>{

	@Override
	protected URI convertInternal(Object value) {
		try {
			if(value instanceof File){
				return ((File)value).toURI();
			}
			
			if(value instanceof URL){
				return ((URL)value).toURI();
			}
			return new URI(convertToStr(value));
		} catch (Exception e) {
			// Ignore Exception
		}
		return null;
	}

}
