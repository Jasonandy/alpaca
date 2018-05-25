package cn.ucaner.alpaca.framework.utils.tools.core.convert.impl;

import java.util.Currency;

import cn.ucaner.alpaca.framework.utils.tools.core.convert.AbstractConverter;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.convert.impl   
* @ClassName：CurrencyConverter   
* @Description：   <p> 货币{@link Currency} 转换器 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:04:05   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class CurrencyConverter extends AbstractConverter<Currency> {

	@Override
	protected Currency convertInternal(Object value) {
		return Currency.getInstance(value.toString());
	}

}
