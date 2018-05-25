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
package cn.ucaner.alpaca.framework.utils.tools.cron.pattern.parser;

import cn.ucaner.alpaca.framework.utils.tools.cron.CronException;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.cron.pattern.parser   
* @ClassName：SimpleValueParser   
* @Description：   <p> 简易值转换器。将给定String值转为int </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午11:47:04   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class SimpleValueParser implements ValueParser {
	
	/** 最小值（包括） */
	protected int min;
	/** 最大值（包括） */
	protected int max;
	
	public SimpleValueParser(int min, int max) {
		if(min > max){
			this.min = max;
			this.max = min;
		}else{
			this.min = min;
			this.max = max;
		}
	}

	@Override
	public int parse(String value) throws CronException {
		int i;
		try {
			i = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new CronException(e, "Invalid integer value: [{}]", value);
		}
		if (i < min || i > max) {
			throw new CronException("Value [{}] out of range: [{} , {}]", i, min, max);
		}
		return i;
	}

	@Override
	public int getMin() {
		return this.min;
	}

	@Override
	public int getMax() {
		return this.max;
	}
}
