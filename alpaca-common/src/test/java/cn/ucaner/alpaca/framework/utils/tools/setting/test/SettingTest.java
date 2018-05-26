package cn.ucaner.alpaca.framework.utils.tools.setting.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cn.ucaner.alpaca.framework.utils.tools.log.LogFactory;
import cn.ucaner.alpaca.framework.utils.tools.log.dialect.console.ConsoleLogFactory;
import cn.ucaner.alpaca.framework.utils.tools.setting.Setting;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.setting.test   
* @ClassName：SettingTest   
* @Description：   <p>  Setting单元测试 </p>
* @Author： -    
* @CreatTime：2018年5月26日 下午2:33:22   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class SettingTest {
	
	@Before
	public void init(){
		LogFactory.setCurrentLogFactory(ConsoleLogFactory.class);
	}
	
	@Test
	public void settingTest(){
		Setting setting = new Setting("test.setting", true);
		
		String driver = setting.getByGroup("driver", "demo");
		Assert.assertEquals("com.mysql.jdbc.Driver", driver);
		
		//本分组变量替换
		String user = setting.getByGroup("user", "demo");
		Assert.assertEquals("rootcom.mysql.jdbc.Driver", user);
		
		//跨分组变量替换
		String user2 = setting.getByGroup("user2", "demo");
		Assert.assertEquals("rootcom.mysql.jdbc.Driver", user2);
	}
	
	@Test
	@Ignore
	public void settingTestForAbsPath(){
		Setting setting = new Setting("d:/test.setting", true);
		
		String driver = setting.getByGroup("driver", "demo");
		Assert.assertEquals(driver, "com.mysql.jdbc.Driver");
		
		String user = setting.getByGroup("user", "demo");
		Assert.assertEquals(user, "rootcom.mysql.jdbc.Driver");
	}
	
	@Test
	public void settingTestForCustom() {
		Setting setting = new Setting();
		
		setting.put("group1", "user", "root");
		setting.put("group2", "user", "root2");
		setting.put("group3", "user", "root3");
		setting.set("user", "root4");
		
		Assert.assertEquals("root", setting.getByGroup("user", "group1"));
		Assert.assertEquals("root2", setting.getByGroup("user", "group2"));
		Assert.assertEquals("root3", setting.getByGroup("user", "group3"));
		Assert.assertEquals("root4", setting.get("user"));
	}
}
