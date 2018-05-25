package cn.ucaner.alpaca.framework.utils.tools.core.date.format;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.date.format   
* @ClassName：DateParser   
* @Description：   <p> 日期解析接口，用于解析日期字符串为 {@link Date} 对象 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午1:22:29   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface DateParser extends DateBasic{

	/**
	 * 将日期字符串解析并转换为  {@link Date} 对象<br>
	 * 等价于 {@link java.text.DateFormat#parse(String)}
	 * 
	 * @param source 日期字符串
	 * @return {@link Date}
	 * @throws ParseException 转换异常，被转换的字符串格式错误。
	 */
	Date parse(String source) throws ParseException;

	/**
	 * 将日期字符串解析并转换为  {@link Date} 对象<br>
	 * 等价于 {@link java.text.DateFormat#parse(String, ParsePosition)}
	 * 
	 * @param source 日期字符串
	 * @param pos {@link ParsePosition}
	 * @return {@link Date}
	 */
	Date parse(String source, ParsePosition pos);

	/**
	 * 根据给定格式转换日期字符串
	 * Updates the Calendar with parsed fields. Upon success, the ParsePosition index is updated to indicate how much of the source text was consumed. 
	 * Not all source text needs to be consumed. 
	 * Upon parse failure, ParsePosition error index is updated to the offset of the source text which does not match the supplied format.
	 *
	 * @param source 被转换的日期字符串
	 * @param pos 定义开始转换的位置，转换结束后更新转换到的位置
	 * @param calendar The calendar into which to set parsed fields.
	 * @return true, if source has been parsed (pos parsePosition is updated); otherwise false (and pos errorIndex is updated)
	 * @throws IllegalArgumentException when Calendar has been set to be not lenient, and a parsed field is out of range.
	 */
	boolean parse(String source, ParsePosition pos, Calendar calendar);

	/**
	 * 将日期字符串解析并转换为  {@link Date} 对象<br>
	 * 
	 * @param source A <code>String</code> whose beginning should be parsed.
	 * @return a <code>java.util.Date</code> object
	 * @throws ParseException if the beginning of the specified string cannot be parsed.
	 * @see java.text.DateFormat#parseObject(String)
	 */
	Object parseObject(String source) throws ParseException;

	/**
	 * 根据 {@link ParsePosition} 给定将日期字符串解析并转换为  {@link Date} 对象<br>
	 * 
	 * @param source A <code>String</code> whose beginning should be parsed.
	 * @param pos the parse position
	 * @return a <code>java.util.Date</code> object
	 * @see java.text.DateFormat#parseObject(String, ParsePosition)
	 */
	Object parseObject(String source, ParsePosition pos);
}
