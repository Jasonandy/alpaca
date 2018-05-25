package cn.ucaner.alpaca.framework.utils.tools.log.dialect.log4j2;

import cn.ucaner.alpaca.framework.utils.tools.log.Log;
import cn.ucaner.alpaca.framework.utils.tools.log.LogFactory;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.log.dialect.log4j2   
* @ClassName：Log4j2LogFactory   
* @Description：   <p> <a href="http://logging.apache.org/log4j/2.x/index.html">Apache Log4J 2</a> log.<br> </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:46:27   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class Log4j2LogFactory extends LogFactory{
	
	public Log4j2LogFactory() {
		super("Log4j2");
		checkLogExist(org.apache.logging.log4j.LogManager.class);
	}

	@Override
	public Log createLog(String name) {
		return new Log4j2Log(name);
	}

	@Override
	public Log createLog(Class<?> clazz) {
		return new Log4j2Log(clazz);
	}

}
