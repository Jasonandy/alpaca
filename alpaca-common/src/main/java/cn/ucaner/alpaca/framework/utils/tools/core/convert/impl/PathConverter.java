package cn.ucaner.alpaca.framework.utils.tools.core.convert.impl;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import cn.ucaner.alpaca.framework.utils.tools.core.convert.AbstractConverter;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.convert.impl   
* @ClassName：PathConverter   
* @Description：   <p> 字符串转换器 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:00:42   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class PathConverter extends AbstractConverter<Path>{

	@Override
	protected Path convertInternal(Object value) {
		try {
			if(value instanceof URI){
				return Paths.get((URI)value);
			}
			
			if(value instanceof URL){
				return Paths.get(((URL)value).toURI());
			}
			
			if(value instanceof File){
				return ((File)value).toPath();
			}
			
			return Paths.get(convertToStr(value));
		} catch (Exception e) {
			// Ignore Exception
		}
		return null;
	}

}
