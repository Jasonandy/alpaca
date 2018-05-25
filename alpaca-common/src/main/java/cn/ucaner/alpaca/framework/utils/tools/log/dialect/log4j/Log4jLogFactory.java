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
package cn.ucaner.alpaca.framework.utils.tools.log.dialect.log4j;

import cn.ucaner.alpaca.framework.utils.tools.log.Log;
import cn.ucaner.alpaca.framework.utils.tools.log.LogFactory;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.log.dialect.log4j   
* @ClassName：Log4jLogFactory   
* @Description：   <p> <a href="http://logging.apache.org/log4j/1.2/index.html">Apache Log4J</a> log.</p>
* @Author： - wubin   
* @CreatTime：2018年5月25日 上午10:47:01   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class Log4jLogFactory extends LogFactory{
	
	public Log4jLogFactory() {
		super("Log4j");
		checkLogExist(org.apache.log4j.Logger.class);
	}
	
	@Override
	public Log createLog(String name) {
		return new Log4jLog(name);
	}

	@Override
	public Log createLog(Class<?> clazz) {
		return new Log4jLog(clazz);
	}

}
