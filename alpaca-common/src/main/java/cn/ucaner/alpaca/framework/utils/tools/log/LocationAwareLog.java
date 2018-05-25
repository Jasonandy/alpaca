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

import cn.ucaner.alpaca.framework.utils.tools.log.level.Level;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.log   
* @ClassName：LocationAwareLog   
* @Description：   <p> 位置感知日志接口，此接口用于通过传入当前全类名的方式来感知日志打印的行号 </p>
* <br>此方法主要用于在继续封装日志实现的时候行号错误的问题，继续封装时传入封装类的全类名即可解决这个问题
* @Author： -    
* @CreatTime：2018年5月25日 上午10:36:56   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface LocationAwareLog extends Log{
	
	/**
	 * 打印 指定级别的日志
	 * 
	 * @param fqcn 完全限定类名(Fully Qualified Class Name)，用于纠正定位错误行号
	 * @param level 级别
	 * @param t 错误对象
	 * @param format 消息模板
	 * @param arguments 参数
	 */
	void log(String fqcn, Level level, Throwable t, String format, Object... arguments);
}
