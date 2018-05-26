package cn.ucaner.alpaca.framework.utils.tools.setting.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cn.ucaner.alpaca.framework.utils.tools.log.LogFactory;
import cn.ucaner.alpaca.framework.utils.tools.log.dialect.console.ConsoleLogFactory;
import cn.ucaner.alpaca.framework.utils.tools.setting.dialect.Props;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.setting.test   
* @ClassName：PropsTest   
* @Description：   <p> Setting单元测试 </p>
* @Author： -    
* @CreatTime：2018年5月26日 下午2:32:55   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class PropsTest {
	
	@Before
	public void init(){
		LogFactory.setCurrentLogFactory(ConsoleLogFactory.class);
	}
	
	@Test
	public void propTest(){
		Props props = new Props("test.properties");
		String user = props.getProperty("user");
		Assert.assertEquals(user, "root");
		
		String driver = props.getStr("driver");
		Assert.assertEquals(driver, "com.mysql.jdbc.Driver");
	}
	
	@Test
	@Ignore
	public void propTestForAbsPAth(){
		Props props = new Props("d:/test.properties");
		String user = props.getProperty("user");
		Assert.assertEquals(user, "root");
		
		String driver = props.getStr("driver");
		Assert.assertEquals(driver, "com.mysql.jdbc.Driver");
	}
}
