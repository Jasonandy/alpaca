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
package cn.ucaner.alpaca.framework.utils.tools.cron.pattern.matcher;

import java.util.List;


/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.cron.pattern.matcher   
* @ClassName：DayOfMonthValueMatcher   
* @Description：   <p> 每月第几天匹配 </p>
* 考虑每月的天数不同，切存在闰年情况，日匹配单独使用
* @Author： -    
* @CreatTime：2018年5月25日 上午11:45:26   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class DayOfMonthValueMatcher extends BoolArrayValueMatcher{
	
	private static final int[] LAST_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public DayOfMonthValueMatcher(List<Integer> intValueList) {
		super(intValueList);
	}
	
	/**
	 * 是否匹配
	 * @param value 被检查的值
	 * @param month 月份
	 * @param isLeapYear 是否闰年
	 * @return 是否匹配
	 */
	public boolean match(int value, int month, boolean isLeapYear) {
		return (super.match(value) || (value > 27 && match(32) && isLastDayOfMonth(value, month, isLeapYear)));
	}

	/**
	 * 是否为本月最后一天
	 * @param value 被检查的值
	 * @param month 月份
	 * @param isLeapYear 是否闰年
	 * @return 是否为本月最后一天
	 */
	private static boolean isLastDayOfMonth(int value, int month, boolean isLeapYear) {
		if (isLeapYear && month == 2) {
			return value == 29;
		} else {
			return value == LAST_DAYS[month - 1];
		}
	}
}
