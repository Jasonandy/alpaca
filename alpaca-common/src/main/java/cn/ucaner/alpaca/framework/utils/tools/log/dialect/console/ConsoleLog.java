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
package cn.ucaner.alpaca.framework.utils.tools.log.dialect.console;

import cn.ucaner.alpaca.framework.utils.tools.core.date.DateUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.lang.Console;
import cn.ucaner.alpaca.framework.utils.tools.core.lang.Dict;
import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;
import cn.ucaner.alpaca.framework.utils.tools.log.AbstractLog;
import cn.ucaner.alpaca.framework.utils.tools.log.level.Level;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.log.dialect.console   
* @ClassName：ConsoleLog   
* @Description：   <p> 利用System.out.println()打印日志 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:42:28   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class ConsoleLog extends AbstractLog {
	
	private static final long serialVersionUID = -6843151523380063975L;

	private static String logFormat = "[{date}] [{level}] {name}: {msg}";
	private static Level level = Level.DEBUG;
	
	private String name;
	
	//------------------------------------------------------------------------- Constructor
	/**
	 * 构造
	 * 
	 * @param clazz 类
	 */
	public ConsoleLog(Class<?> clazz) {
		this.name = clazz.getName();
	}
	
	/**
	 * 构造
	 * 
	 * @param name 类名
	 */
	public ConsoleLog(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	//------------------------------------------------------------------------- Trace
	@Override
	public boolean isTraceEnabled() {
		return level.compareTo(Level.TRACE) <= 0;
	}

	@Override
	public void trace(String format, Object... arguments) {
		log(Level.TRACE, format, arguments);
	}

	@Override
	public void trace(Throwable t, String format, Object... arguments) {
		log(Level.TRACE, t, format, arguments);
	}

	//------------------------------------------------------------------------- Debug
	@Override
	public boolean isDebugEnabled() {
		return level.compareTo(Level.DEBUG) <= 0;
	}

	@Override
	public void debug(String format, Object... arguments) {
		log(Level.DEBUG, format, arguments);
	}

	@Override
	public void debug(Throwable t, String format, Object... arguments) {
		log(Level.DEBUG, t, format, arguments);
	}

	//------------------------------------------------------------------------- Info
	@Override
	public boolean isInfoEnabled() {
		return level.compareTo(Level.INFO) <= 0;
	}

	@Override
	public void info(String format, Object... arguments) {
		log(Level.INFO, format, arguments);
	}

	@Override
	public void info(Throwable t, String format, Object... arguments) {
		log(Level.INFO, t, format, arguments);
	}

	//------------------------------------------------------------------------- Warn
	@Override
	public boolean isWarnEnabled() {
		return level.compareTo(Level.WARN) <= 0;
	}

	@Override
	public void warn(String format, Object... arguments) {
		log(Level.WARN, format, arguments);
	}

	@Override
	public void warn(Throwable t, String format, Object... arguments) {
		log(Level.WARN, t, format, arguments);
	}

	//------------------------------------------------------------------------- Error
	@Override
	public boolean isErrorEnabled() {
		return level.compareTo(Level.ERROR) <= 0;
	}

	@Override
	public void error(String format, Object... arguments) {
		log(Level.ERROR, format, arguments);
	}

	@Override
	public void error(Throwable t, String format, Object... arguments) {
		log(Level.ERROR, t, format, arguments);
	}
	
	//------------------------------------------------------------------------- Log
	@Override
	public void log(Level level, String format, Object... arguments) {
		this.log(level, null, format, arguments);
	}

	@Override
	public void log(Level level, Throwable t, String format, Object... arguments) {
		if(false == isEnabled(level)){
			return;
		}
		
		final Dict dict = Dict.create()
				.set("date", DateUtil.now())
				.set("level", level.toString())
				.set("name", this.name)
				.set("msg", StrUtil.format(format, arguments));
		
		String logMsg = StrUtil.format(logFormat, dict);
		
		//WARN以上级别打印至System.err
		if(level.ordinal() >= Level.WARN.ordinal()){
			Console.error(t, logMsg);
		}else{
			Console.log(t, logMsg);
		}
		
	}
}