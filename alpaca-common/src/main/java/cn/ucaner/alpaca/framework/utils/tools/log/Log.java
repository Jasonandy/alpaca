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
package cn.ucaner.alpaca.framework.utils.tools.log;

import cn.ucaner.alpaca.framework.utils.tools.log.level.DebugLog;
import cn.ucaner.alpaca.framework.utils.tools.log.level.ErrorLog;
import cn.ucaner.alpaca.framework.utils.tools.log.level.InfoLog;
import cn.ucaner.alpaca.framework.utils.tools.log.level.Level;
import cn.ucaner.alpaca.framework.utils.tools.log.level.TraceLog;
import cn.ucaner.alpaca.framework.utils.tools.log.level.WarnLog;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.log   
* @ClassName：Log   
* @Description：   <p> 日志统一接口 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:27:09   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface Log extends TraceLog, DebugLog, InfoLog, WarnLog, ErrorLog {

	/**
	 * @return 日志对象的Name
	 */
	public String getName();

	/**
	 * 是否开启指定日志
	 * @param level 日志级别
	 * @return 是否开启指定级别
	 */
	boolean isEnabled(Level level);

	/**
	 * 打印指定级别的日志
	 * @param level 级别
	 * @param format 消息模板
	 * @param arguments 参数
	 */
	void log(Level level, String format, Object... arguments);

	/**
	 * 打印 指定级别的日志
	 * 
	 * @param level 级别
	 * @param t 错误对象
	 * @param format 消息模板
	 * @param arguments 参数
	 */
	void log(Level level, Throwable t, String format, Object... arguments);
}
