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

import cn.ucaner.alpaca.framework.utils.tools.log.Log;
import cn.ucaner.alpaca.framework.utils.tools.log.LogFactory;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.log.dialect.console   
* @ClassName：ConsoleLogFactory   
* @Description：   <p> 利用System.out.println()打印日志 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:42:52   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class ConsoleLogFactory extends LogFactory {
	
	public ConsoleLogFactory() {
		super("Alpaca-Common-Log Console Logging");
	}

	@Override
	public Log createLog(String name) {
		return new ConsoleLog(name);
	}

	@Override
	public Log createLog(Class<?> clazz) {
		return new ConsoleLog(clazz);
	}

}
