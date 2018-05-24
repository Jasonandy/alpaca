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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
* @Package：cn.ucaner.common.utils   
* @ClassName：DateUtils   
* @Description：   <p> 日期转换工具类 </p>
* @Author： - Jason 
* @CreatTime：2017年10月24日 上午10:51:22   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class DateUtils {

	/**
	 * 将日期格式化转成字符串
	 * @param date
	 * @return String
	 * @throws ParseException
	 */
	public static String dateToString(Date date) {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateformat.format(date);
		String strDate = dateformat.format(date);
		return strDate;

	}

	/**
	 * 将字符串转成日期
	 * @param dateStr
	 * @return Date
	 */
	public static Date StringToDate(String dateStr) {
		SimpleDateFormat sdf = null;
		Date date = null;
		if (dateStr.length() > 10) {
			if (dateStr.indexOf("T") > -1) {
				dateStr = dateStr.replace("T", " ");
			}
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} else {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		}
		try {
			date = sdf.parse(dateStr);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
			return null;
		}
		return date;
	}

	/**
	 * 将字符串转成日期
	 * @param dateStr
	 * @return Date
	 */
	public static Date StringToDateYMD(String dateStr) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(dateStr);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
			return null;
		}
		return date;
	}

	/**
	 * 用日期加五位随机数作为文件名
	 * @param fileName
	 *            文件名
	 * @return String
	 */
	public static String generateFileName(String fileName) {
		DateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		String formatDate = format.format(new Date());

		int random = new Random().nextInt(10000);

		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);

		return formatDate + random + extension;
	}

	/**
	 * 取昨天日期
	 * @return
	 */
	public static Date yesterdayDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -1);
		return StringToDate(sdf.format(c.getTime()));
	}

	/**
	 * 取今天日期
	 * 
	 * @return String
	 */
	public static String today() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		return sdf.format(c.getTime());
	}
	
	/**
	 * 取今天日期
	 * 
	 * @return String
	 */
	public static Date currentDate() {
		Calendar c = Calendar.getInstance();
		Date d = java.sql.Date.valueOf(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DATE));
		return d;
	}

	/**
	 * 取今天日期
	 * 
	 * @return String
	 */
	public static String toChday() {
		Date d = new Date();
		SimpleDateFormat sdfy = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdfm = new SimpleDateFormat("MM");
		SimpleDateFormat sdfd = new SimpleDateFormat("dd");
		return sdfy.format(d) + "年" + sdfm.format(d) + "月" + sdfd.format(d) + "日";
	}

	/**
	 * 取明天日期
	 * 
	 * @return String
	 */
	public static String tomorrowDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, +1);
		return sdf.format(c.getTime());
	}

	/**
	 * 取第n天日期
	 * @param day
	 * @return
	 */
	public static String getDayDate(Integer day) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, day);
		return sdf.format(c.getTime());
	}

	/**
	 * 以当前日期为基准（不包含时间），获取偏移后的日期
	 * 
	 * @param offset 偏移量
	 */
	public static Date getOffsetDate(int offset) {
		Date nowWithoutTime = currentDate();
		Calendar c = Calendar.getInstance();
		c.setTime(nowWithoutTime);
		c.add(Calendar.DATE, offset);
		
		return c.getTime();
	}
	/**
	 * 求两个日期相差天数
	 * 
	 * @param d1
	 * @param d2
	 * @return long
	 */
	public static int getDaysBetween(Calendar d1, Calendar d2) {
		if (d1.after(d2)) {
			java.util.Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}
		int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
		int y2 = d2.get(Calendar.YEAR);
		if (d1.get(Calendar.YEAR) != y2) {
			d1 = (Calendar) d1.clone();
			do {
				// 得到当年的实际天数
				days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
				d1.add(Calendar.YEAR, 1);
			} while (d1.get(Calendar.YEAR) != y2);
		}
		return days;
	}

	/**
	 * 日期转换成日历格式
	 * 
	 * @param date
	 * @return Calendar
	 */
	public static Calendar date2Calendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	/**
	 * 一年的第几周
	 * 
	 * @return int
	 */
	public static int YearOfWeekDay() {
		@SuppressWarnings("unused")
		Date d = new Date();
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 一月的第几周
	 * 
	 * @return int
	 */
	public static int MonthOfWeekDay() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.WEEK_OF_MONTH);
	}

	/**
	 * 两个日期相隔天数
	 * 
	 * @param startday
	 * @param endday
	 * @return int
	 */
	public int getIntervalDays(Date startday, Date endday) {
		if (startday.after(endday)) {
			Date cal = startday;
			startday = endday;
			endday = cal;
		}
		long sl = startday.getTime();
		long el = endday.getTime();
		long ei = el - sl;
		return (int) ( ei / ( 1000 * 60 * 60 * 24 ) );
	}

	/**
	 * 返回两个日期相差的天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return long 
	 * @throws ParseException
	 */
	public static long DateDiff(Date startDate, Date endDate) {
		long totalDate = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		long timestart = calendar.getTimeInMillis();
		calendar.setTime(endDate);
		long timeend = calendar.getTimeInMillis();
		totalDate = ( timeend - timestart ) / ( 1000 * 60 * 60 * 24 );
		return totalDate;
	}
	
	/**
	 * 返回两个日期相差的毫秒数
	 * 后面的时间 - 当前的时间
	 * @param startDate
	 * @param endDate
	 * @return long 
	 * @throws ParseException
	 */
	public static long DateDiffInMillis(Date startDate, Date endDate) {
		long diff = 0;
		long timestart = startDate.getTime();
		long timeend = endDate.getTime();
		diff = timeend - timestart;
		return diff;
	}


	/**
	 * 格式化日期
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		// 保存改后的时间
		String ymd = " ";
		if (date == null || "".equals(date) || "1900-01-01 00:00:00.0".equals(date)) {
			return ymd;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		ymd = dateFormat.format(date);
		return ymd;
	}

	public static Date getNextMonth(Date nowdate, int delay) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar temp = Calendar.getInstance();
		temp.setTime(nowdate);
		int oldMonth = temp.get(Calendar.MONTH);
		int newMonth = oldMonth + delay;
		int oldYear = temp.get(Calendar.YEAR);
		int i, j;
		if (newMonth > 12) {
			i = newMonth % 12;
			j = newMonth / 12;
			temp.set(Calendar.MONTH, i);
			temp.set(Calendar.YEAR, j + oldYear);
		} else {
			temp.set(Calendar.MONTH, newMonth);
		}

		temp.set(Calendar.DATE, temp.get(Calendar.DATE));
		String dateString = formatter.format(temp.getTime());
		Date strtodate = null;
		try {
			strtodate = formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strtodate;
	}

	public static String formatDate(String str, String sourceFormat, String desFormat) {
		SimpleDateFormat formatter = new SimpleDateFormat(sourceFormat);
		try {
			Date date = formatter.parse(str);
			formatter = new SimpleDateFormat(desFormat);
			return formatter.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 获取日期
	 * @param date
	 * @return
	 */
	public static String getDateStr(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}

	/**
	 * 获取日期
	 * @param date  毫秒数
	 * @return
	 */
	public static String getDateLong(Long date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date);
		return formatter.format(calendar.getTime());
	}

	/**
	 * 获取当天开始时间 即零点
	 * @return
	 */
	public static Date getDateBegin(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return dateFormat.parse(getDateStr(date) + " 00:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取当天开始时间 即零点
	 * @return
	 */
	public static Date getDateEnd(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return dateFormat.parse(getDateStr(date) + " 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 取第n天日期
	 * @param day
	 * @return
	 */
	public static String getDayForDate(Date date, Integer day) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, day);
		return sdf.format(c.getTime());
	}

	/**
	 * 获取当前时间戳
	 * @return
	 */
	public static String getCurrentTime() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
	
	public static Date getBaseTime(String timepartStr) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2000-01-01 " + timepartStr);
		} catch (ParseException e) {
			throw new IllegalArgumentException("", e);
		}
	}
	
	public static Date getBaseCurrentTime() {
		//"2000-01-01 "
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2000);
		c.set(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);
		
		return c.getTime();
	}
	/**
	 * eg. 8:30-10:00
	 * @param timeStr
	 * @return [Date,Date]
	 */
	public static Date[] parseDates(String timeStr) {
		String baseDate = "2000-01-01 ";
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String[] timePoints = timeStr.split("-");
		try {
			Date[] dates = new Date[2];
			dates[0] = timeFormat.parse(baseDate + timePoints[0]);
			dates[1] = timeFormat.parse(baseDate + timePoints[1]);
			return dates;
		} catch (ParseException e) {
			throw new IllegalArgumentException("", e);
		}
	}
	
	/**
	 * date:2000-01-01, time:now() - offsetMinutes
	 * @param offsetMinutes 
	 * @return 
	 */
	public static Date getPromptDate(int offsetMinutes) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2000);
		c.set(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);
		
		c.add(Calendar.MINUTE, offsetMinutes);
		
		return c.getTime();
	}

	/**
	 * 
	 * @param appointmentDate 2017-08-05
	 * @param appointmentTime eg. 8:30-9:00
	 */
	public static Date getAppointmentEndTime(String appointmentDate, String appointmentTime) {
		String[] times = appointmentTime.split("-");
		
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			//获取结束时间   可以判断 15天最多   最迟晚30分钟  by daodou
			return timeFormat.parse(appointmentDate + " " + times[1]);
		} catch (ParseException e) {
			throw new IllegalArgumentException("日期格式不正确", e);
		}
	}
	
	public static String getDateStrByformate(String formate , Date date){
		SimpleDateFormat format = new SimpleDateFormat(formate);
		return format.format(date);
	}
	
	/**
	 * 获得小时和分钟
	 * @param date
	 * @return
	 */
	public static String getHourMinute(Date date){
		return getDateStrByformate("HH:mm",date);
	}
	
	/**
	 * 今天返回如   09:35
	 * 昨天返回如   昨天 09:35
	 * 前天返回如   2017-07-20 09:35
	 * @return
	 */
	public static String dateShow(Date date){
	 	String dateStr = formatDate(date);
	 	String todayStr = today();
	 	if(todayStr.equals(dateStr)){
	 		return getHourMinute(date);
	 	}
	 	String yesterdayStr = formatDate(yesterdayDate());
	 	if(yesterdayStr.equals(dateStr)){
	 		return "昨天 "+getHourMinute(date);
	 	}
	 	return getDateStrByformate("yyyy-MM-dd HH:mm",date);
	}
	
	/**
	 * 判断日期是否是今天
	 * 
	 * @param date
	 */
	public static boolean isToday(Date date) {
		return today().equals(new SimpleDateFormat("yyyy-MM-dd").format(date));
	}
}
