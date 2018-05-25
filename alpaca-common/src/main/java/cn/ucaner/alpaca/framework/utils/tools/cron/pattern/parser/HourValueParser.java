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

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.cron.pattern.parser   
* @ClassName：HourValueParser   
* @Description：   <p> 小时值处理 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午11:48:21   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class HourValueParser extends SimpleValueParser{
	
	public HourValueParser() {
		super(0, 23);
	}

}
