package cn.ucaner.alpaca.framework.utils.tools.log.test;

import org.junit.Test;

import cn.ucaner.alpaca.framework.utils.tools.log.Log;
import cn.ucaner.alpaca.framework.utils.tools.log.LogFactory;
import cn.ucaner.alpaca.framework.utils.tools.log.level.Level;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.log.test   
* @ClassName：LogTest   
* @Description：   <p> 日志门面单元测试 </p>
* @Author： -    
* @CreatTime：2018年5月26日 下午4:57:00   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class LogTest {
	
	@Test
	public void logTest(){
		Log log = LogFactory.get();
		// 自动选择日志实现
		log.debug("This is {} log", Level.DEBUG);
		log.info("This is {} log", Level.INFO);
		log.warn("This is {} log", Level.WARN);
		
		//Exception e = new Exception("This is a  Exception");
		//log.error(e, "This is {} log", Level.ERROR);
	}
}
