package cn.ucaner.alpaca.framework.utils.tools.core.date.format;

import java.util.Locale;
import java.util.TimeZone;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.date.format   
* @ClassName：DateBasic   
* @Description：   <p> 日期基本信息获取接口 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午1:22:43   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface DateBasic {
	/**
	 * 获得日期格式化或者转换的格式
	 * 
	 * @return {@link java.text.SimpleDateFormat}兼容的格式
	 */
	String getPattern();

	/**
	 * 获得时区
	 * 
	 * @return {@link TimeZone}
	 */
	TimeZone getTimeZone();

	/**
	 * 获得 日期地理位置
	 * 
	 * @return {@link Locale}
	 */
	Locale getLocale();
}
