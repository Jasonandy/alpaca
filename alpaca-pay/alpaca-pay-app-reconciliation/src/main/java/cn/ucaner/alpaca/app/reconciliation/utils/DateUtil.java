package cn.ucaner.alpaca.app.reconciliation.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
* @Package：cn.ucaner.alpaca.app.reconciliation.utils   
* @ClassName：DateUtil   
* @Description：   <p> 时间工具类 </p>
* @Author： -    
* @CreatTime：2018年5月12日 下午2:53:00   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
public class DateUtil {

	private DateUtil() {
		super();
	}

	/***
	 * 查询当前小时
	 * 
	 * @return
	 */
	public static int getCurrentHour() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.get(Calendar.HOUR_OF_DAY); // 获取当前小时
	}

	/***
	 * 查询当前分钟
	 * 
	 * @return
	 */
	public static int getCurrentMinute() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.get(Calendar.MINUTE); // 获取当前分钟
	}

	/***
	 * 获取几天前的日期格式
	 * 
	 * @param dayNum
	 * @return
	 */
	public static String getDateByDayNum(int dayNum) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, -dayNum);
		String result = sdf.format(cal.getTime());
		return result;
	}

	/**
	 * 计算 day 天后的时间
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date addDay(Date date, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}

}
