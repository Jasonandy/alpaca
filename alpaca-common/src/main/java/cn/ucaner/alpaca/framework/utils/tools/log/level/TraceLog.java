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
package cn.ucaner.alpaca.framework.utils.tools.log.level;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.log.level   
* @ClassName：TraceLog   
* @Description：   <p> TRACE级别日志接口 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:35:29   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface TraceLog {
	/**
	 * @return TRACE 等级是否开启
	 */
	boolean isTraceEnabled();

	/**
	 * 打印 TRACE 等级的日志
	 * 
	 * @param t 错误对象
	 */
	void trace(Throwable t);

	/**
	 * 打印 TRACE 等级的日志
	 * 
	 * @param format 消息模板
	 * @param arguments 参数
	 */
	void trace(String format, Object... arguments);

	/**
	 * 打印 TRACE 等级的日志
	 * 
	 * @param t 错误对象
	 * @param format 消息模板
	 * @param arguments 参数
	 */
	void trace(Throwable t, String format, Object... arguments);
}
