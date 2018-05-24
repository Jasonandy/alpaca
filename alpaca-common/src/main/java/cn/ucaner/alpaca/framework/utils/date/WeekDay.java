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
package cn.ucaner.alpaca.framework.utils.date;

/**
* @Package：cn.ucaner.common.utils   
* @ClassName：WeekDay   
* @Description：   <p> WeekDay 星期枚举类</p>
* @Author： - Jason 
* @CreatTime：2017年10月24日 上午10:56:02   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public enum WeekDay {
	
	Monday("monday"), Tuesday("tuesday"), Wednesday("wednesday"), Thursday("thursday"), Friday("friday"), Saturday("saturday"), Sunday("sunday");
	
	private String code;
	private WeekDay(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
}
