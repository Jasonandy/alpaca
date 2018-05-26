package cn.ucaner.alpaca.framework.utils.tools.log.test;

import org.junit.Test;

import cn.ucaner.alpaca.framework.utils.tools.log.StaticLog;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.log.test   
* @ClassName：StaticLogTest   
* @Description：   <p> StaticLogTest </p>
* @Author： -    
* @CreatTime：2018年5月26日 下午4:57:33   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class StaticLogTest {
	
	@Test
	public void test() {
		StaticLog.debug("This is static {} log", "debug");
		StaticLog.info("This is static {} log", "info");
	}
}
