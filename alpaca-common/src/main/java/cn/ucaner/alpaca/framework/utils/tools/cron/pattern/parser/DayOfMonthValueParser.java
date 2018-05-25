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
* @ClassName：DayOfMonthValueParser   
* @Description：   <p> 每月的几号值处理 </p>
*  每月最多31天，32和“L”都表示最后一天
* @Author： -    
* @CreatTime：2018年5月25日 上午11:45:50   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class DayOfMonthValueParser extends SimpleValueParser{
	
	public DayOfMonthValueParser() {
		super(1, 31);
	}

	@Override
	public int parse(String value) throws CronException{
		if (value.equalsIgnoreCase("L") || value.equals("32")) {//每月最后一天
			return 32;
		} else {
			return super.parse(value);
		}
	}
}
