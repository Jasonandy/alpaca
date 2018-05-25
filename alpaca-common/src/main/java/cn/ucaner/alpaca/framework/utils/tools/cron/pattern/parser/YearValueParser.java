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
* @ClassName：YearValueParser   
* @Description：   <p> 年值处理 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午11:46:18   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class YearValueParser extends SimpleValueParser{
	
	public YearValueParser() {
		super(1970, 2099);
	}

}
