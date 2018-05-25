/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 19941115</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.alpaca.framework.utils.tools.core.convert.impl;

import java.util.concurrent.atomic.AtomicBoolean;

import cn.ucaner.alpaca.framework.utils.tools.core.convert.AbstractConverter;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.convert.impl   
* @ClassName：AtomicBooleanConverter   
* @Description：   <p> {@link AtomicBoolean}转换器 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:08:58   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class AtomicBooleanConverter extends AbstractConverter<AtomicBoolean> {

	@Override
	protected AtomicBoolean convertInternal(Object value) {
		if (boolean.class == value.getClass()) {
			return new AtomicBoolean((boolean) value);
		}
		if (value instanceof Boolean) {
			return new AtomicBoolean((Boolean) value);
		}
		final String valueStr = convertToStr(value);
		return new AtomicBoolean(PrimitiveConverter.parseBoolean(valueStr));
	}

}
