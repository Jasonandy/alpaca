package cn.ucaner.alpaca.framework.utils.tools.log;

import cn.ucaner.alpaca.framework.utils.tools.log.dialect.commons.ApacheCommonsLogFactory;
import cn.ucaner.alpaca.framework.utils.tools.log.dialect.console.ConsoleLogFactory;
import cn.ucaner.alpaca.framework.utils.tools.log.dialect.jdk.JdkLogFactory;
import cn.ucaner.alpaca.framework.utils.tools.log.dialect.log4j.Log4jLogFactory;
import cn.ucaner.alpaca.framework.utils.tools.log.dialect.log4j2.Log4j2LogFactory;
import cn.ucaner.alpaca.framework.utils.tools.log.dialect.slf4j.Slf4jLogFactory;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.log   
* @ClassName：GlobalLogFactory   
* @Description：   <p> 全局日志工厂类 </p>
* @Author： -    
* @CreatTime：2018年5月26日 下午3:57:47   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class GlobalLogFactory {
	
	private static volatile LogFactory currentLogFactory;
	
	private static final Object lock = new Object();

	/**
	 * 获取单例日志工厂类，如果不存在创建之
	 * 
	 * @return 当前使用的日志工厂
	 */
	public static LogFactory get() {
		if (null == currentLogFactory) {
			synchronized (lock) {
				if (null == currentLogFactory) {
					currentLogFactory = LogFactory.create();
					currentLogFactory.getLog(GlobalLogFactory.class).debug("Use [{}] Logger As Default.", currentLogFactory.logFramworkName);
				}
			}
		}
		return currentLogFactory;
	}

	/**
	 * 自定义日志实现
	 * 
	 * @see Slf4jLogFactory
	 * @see Log4jLogFactory
	 * @see Log4j2LogFactory
	 * @see ApacheCommonsLogFactory
	 * @see JdkLogFactory
	 * @see ConsoleLogFactory
	 * 
	 * @param logFactoryClass 日志工厂类
	 * @return 自定义的日志工厂类
	 */
	public static LogFactory set(Class<? extends LogFactory> logFactoryClass) {
		try {
			return set(logFactoryClass.newInstance());
		} catch (Exception e) {
			throw new IllegalArgumentException("Can not instance LogFactory class!", e);
		}
	}

	/**
	 * 自定义日志实现
	 * 
	 * @see Slf4jLogFactory
	 * @see Log4jLogFactory
	 * @see Log4j2LogFactory
	 * @see ApacheCommonsLogFactory
	 * @see JdkLogFactory
	 * @see ConsoleLogFactory
	 * 
	 * @param logFactory 日志工厂类对象
	 * @return 自定义的日志工厂类
	 */
	public static LogFactory set(LogFactory logFactory) {
		logFactory.getLog(GlobalLogFactory.class).debug("Custom Use [{}] Logger.", logFactory.logFramworkName);
		currentLogFactory = logFactory;
		return currentLogFactory;
	}
}
