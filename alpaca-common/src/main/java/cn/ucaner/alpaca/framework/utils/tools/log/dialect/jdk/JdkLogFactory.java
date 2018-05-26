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
package cn.ucaner.alpaca.framework.utils.tools.log.dialect.jdk;

import java.io.InputStream;
import java.util.logging.LogManager;

import cn.ucaner.alpaca.framework.utils.tools.core.io.IoUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.io.resource.ResourceUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.lang.Console;
import cn.ucaner.alpaca.framework.utils.tools.log.Log;
import cn.ucaner.alpaca.framework.utils.tools.log.LogFactory;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.log.dialect.jdk   
* @ClassName：JdkLogFactory   
* @Description：   <p> JDK日志工厂类 </p>
* <br><a href="http://java.sun.com/javase/6/docs/technotes/guides/logging/index.html">java.util.logging</a> log.
* @Author： - wubin   
* @CreatTime：2018年5月25日 上午10:43:48   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class JdkLogFactory extends LogFactory{
	
	public JdkLogFactory() {
		super("JDK Logging");
		readConfig();
	}

	@Override
	public Log createLog(String name) {
		return new JdkLog(name);
	}

	@Override
	public Log createLog(Class<?> clazz) {
		return new JdkLog(clazz);
	}
	
	/**
	 * 读取ClassPath下的logging.properties配置文件
	 */
	private void readConfig() {
		//避免循环引用，Log初始化的时候不使用相关工具类
		InputStream in = ResourceUtil.getStreamSafe("logging.properties");
		if(null == in){
			System.err.println("[WARN] Can not find [logging.properties], use [%JRE_HOME%/lib/logging.properties] as default!");
			return;
		}
		
		try {
			LogManager.getLogManager().readConfiguration(in);
		} catch (Exception e) {
			Console.error(e, "Read [logging.properties] from classpath error!");
			try {
				LogManager.getLogManager().readConfiguration();
			} catch (Exception e1) {
				Console.error(e, "Read [logging.properties] from [%JRE_HOME%/lib/logging.properties] error!");
			}
		} finally {
			IoUtil.close(in);
		}
	}
}
