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
package cn.ucaner.alpaca.framework.utils.tools.core.date;

/**
* @Package：cn.ucaner.tools.core.date   
* @ClassName：DateUnit   
* @Description：   <p> 日期时间单位，每个单位都是以毫秒为基数 </p>
* @Author： -  
* @CreatTime：2017-11-3 上午9:48:47   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public enum DateUnit {
	/** 一毫秒 */
	MS(1), 
	/** 一秒的毫秒数 */
	SECOND(1000), 
	/**一分钟的毫秒数 */
	MINUTE(SECOND.getMillis() * 60),
	/**一小时的毫秒数 */
	HOUR(MINUTE.getMillis() * 60),
	/**一天的毫秒数 */
	DAY(HOUR.getMillis() * 24),
	/**一周的毫秒数 */
	WEEK(DAY.getMillis() * 7);
	
	private long millis;
	DateUnit(long millis){
		this.millis = millis;
	}
	
	/**
	 * @return 单位对应的毫秒数
	 */
	public long getMillis(){
		return this.millis;
	}
}
