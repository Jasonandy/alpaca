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

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
* @Package：com.sunshine.common.utils   
* @ClassName：WeekDayUtils   
* @Description：   <p> 星期相关工具 </p>
* @Author： - Jason 
* @CreatTime：2017年09月18日 下午2:40:29   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class WeekDayUtils {
	
	/**
	 * @param dateStr yyyy-MM-dd
	 * @return
	 */
	public static WeekDay getWeekDay(String dateStr) {
		Date date = DateUtils.StringToDateYMD(dateStr);
		return getWeekDay(date);
	}
	
	public static WeekDay getWeekDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(date.getTime());
		
		WeekDay ret = null;
		
		switch(c.get(Calendar.DAY_OF_WEEK)) {
			case Calendar.SUNDAY:
				ret = WeekDay.Sunday;
				break;
			case Calendar.MONDAY:
				ret = WeekDay.Monday;
				break;
			case Calendar.TUESDAY:
				ret = WeekDay.Tuesday;
				break;
			case Calendar.WEDNESDAY:
				ret = WeekDay.Wednesday;
				break;
			case Calendar.THURSDAY:
				ret = WeekDay.Thursday;
				break;
			case Calendar.FRIDAY:
				ret = WeekDay.Friday;
				break;
			case Calendar.SATURDAY:
				ret = WeekDay.Saturday;
				break;
			default:
					throw new IllegalArgumentException("未知日期");
		}
		return ret;
	}
	
	public static WeekDay getWeekDayOf(String weekDayCode) {
		if (WeekDay.Sunday.getCode().equals(weekDayCode)) {
			return WeekDay.Sunday;
		} else if (WeekDay.Monday.getCode().equals(weekDayCode)) {
			return WeekDay.Monday;
		} else if (WeekDay.Tuesday.getCode().equals(weekDayCode)) {
			return WeekDay.Tuesday;
		} else if (WeekDay.Wednesday.getCode().equals(weekDayCode)) {
			return WeekDay.Wednesday;
		} else if (WeekDay.Thursday.getCode().equals(weekDayCode)) {
			return WeekDay.Thursday;
		} else if (WeekDay.Friday.getCode().equals(weekDayCode)) {
			return WeekDay.Friday;
		} else if (WeekDay.Saturday.getCode().equals(weekDayCode)) {
			return WeekDay.Saturday;
		} else {
			throw new IllegalArgumentException("未知日期, code[" + weekDayCode + "]");
		}
	}
	
	/**
	 * 获取从当前日期（不包含）起指定范围内，匹配指定星期名称的日期
	 * eg ： 15 天  范围内 同星期数的 日期      20170101 - 0108 - 0115 
	 * @param weekDay    星期枚举
	 * @param scopeCount 范围天数
	 * @return
	 */
	public static List<Date> getDatesOfWeekDay(WeekDay weekDay, int scopeCount) {
		List<Date> list = new LinkedList<Date>();
		Calendar c = Calendar.getInstance();
		//过滤掉生效于当前日期 
		c.add(Calendar.DATE, 1);
		for (int i = 0; i <= scopeCount; i++) {
			if (weekDay == getWeekDay(c.getTime())) {
				list.add(c.getTime());
			}
			c.add(Calendar.DATE, 1);
		}
		return list;
	}
	
	/**
	 *    获取(包含当前星期数 )当前星期的所有的日期数据
	 * @param weekDay 
	 * @param scopeCount
	 * @return 
	 */
	public static List<Date> getDatesOfNowWeekDay(WeekDay weekDay, int scopeCount) {
		List<Date> list = new LinkedList<Date>();
		Calendar c = Calendar.getInstance();
		for (int i = 0; i < scopeCount; i++) {
			if (weekDay == getWeekDay(c.getTime())) {
				list.add(c.getTime());
			}
			c.add(Calendar.DATE, 1);
		}
		return list;
	}
}
