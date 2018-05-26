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
package cn.ucaner.alpaca.framework.utils.tools.log.dialect.commons;

import cn.ucaner.alpaca.framework.utils.tools.log.Log;
import cn.ucaner.alpaca.framework.utils.tools.log.LogFactory;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.log.dialect.commons   
* @ClassName：ApacheCommonsLogFactory   
* @Description：   <p>  Apache Commons Logging </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:42:10   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class ApacheCommonsLogFactory extends LogFactory{
	
	public ApacheCommonsLogFactory() {
		super("Apache Common Logging");
		checkLogExist(org.apache.commons.logging.LogFactory.class);
	}

	@Override
	public Log createLog(String name) {
		try {
			return new ApacheCommonsLog4JLog(name);
		} catch (Exception e) {
			return new ApacheCommonsLog(name);
		}
	}

	@Override
	public Log createLog(Class<?> clazz) {
		try {
			return new ApacheCommonsLog4JLog(clazz);
		} catch (Exception e) {
			return new ApacheCommonsLog(clazz);
		}
	}

	@Override
	protected void checkLogExist(Object logClassName) {
		super.checkLogExist(logClassName);
		//Commons Logging在调用getLog时才检查是否有日志实现，在此提前检查，如果没有实现则跳过之
		getLog(ApacheCommonsLogFactory.class);
	}
}
