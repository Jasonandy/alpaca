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
* @ClassName：InfoLog   
* @Description：   <p> INFO级别日志接口 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:28:07   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface InfoLog {
	/**
	 * @return INFO 等级是否开启
	 */
	boolean isInfoEnabled();

	/**
	 * 打印 INFO 等级的日志
	 * 
	 * @param t 错误对象
	 */
	void info(Throwable t);

	/**
	 * 打印 INFO 等级的日志
	 * 
	 * @param format 消息模板
	 * @param arguments 参数
	 */
	void info(String format, Object... arguments);

	/**
	 * 打印 INFO 等级的日志
	 * 
	 * @param t 错误对象
	 * @param format 消息模板
	 * @param arguments 参数
	 */
	void info(Throwable t, String format, Object... arguments);
}
