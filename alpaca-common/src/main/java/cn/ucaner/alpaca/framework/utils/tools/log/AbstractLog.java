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

import java.io.Serializable;

import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;
import cn.ucaner.alpaca.framework.utils.tools.log.level.Level;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.log   
* @ClassName：AbstractLog   
* @Description：   <p> 抽象日志类 </p>
* <br>实现了一些通用的接口
* @Author： -    
* @CreatTime：2018年5月25日 上午10:36:25   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public abstract class AbstractLog implements Log, Serializable{
	
	private static final long serialVersionUID = -3211115409504005616L;
	
	@Override
	public boolean isEnabled(Level level) {
		switch (level) {
			case TRACE:
				return isTraceEnabled();
			case DEBUG:
				return isDebugEnabled();
			case INFO:
				return isInfoEnabled();
			case WARN:
				return isWarnEnabled();
			case ERROR:
				return isErrorEnabled();
			default:
				throw new Error(StrUtil.format("Can not identify level: {}", level));
		}
	}

	@Override
	public void trace(Throwable t) {
		this.trace(t, t.getMessage());
	}
	
	@Override
	public void debug(Throwable t) {
		this.debug(t, t.getMessage());
	}
	
	@Override
	public void info(Throwable t) {
		this.info(t, t.getMessage());
	}
	
	@Override
	public void warn(Throwable t) {
		this.warn(t, t.getMessage());
	}
	
	@Override
	public void error(Throwable t) {
		this.error(t, t.getMessage());
	}
}
