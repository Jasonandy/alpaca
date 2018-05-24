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
package cn.ucaner.alpaca.framework.utils.junit;

import java.net.URL;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.ucaner.alpaca.framework.common.spring.ext.SpringContextHolder;
import cn.ucaner.alpaca.framework.config.SystemConfig;

/**
* @Package：cn.ucaner.framework.utils   
* @ClassName：Junit4SpringContextHolder   
* @Description：   <p>spring集成Junit测试框架上下文环境配置,单元测试时只需继承该助手类即可.</p>
* @Author： - Jason 
* @CreatTime：2017年8月30日 下午2:11:42   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-framework.xml" })
public class Junit4SpringContextHolder extends AbstractJUnit4SpringContextTests {

	/**
	 * 启动容器  for junit test  by Jason
	 */
	public Junit4SpringContextHolder() {
		super();
		try {
			URL u = ClassLoader.getSystemResource("");
			//LogbackConfigurer.initLogging(u.getPath() + "logback/logback.xml");
		} catch (Exception ex) {
			System.err.println("Cannot Initialize logback");
		}
	}

	@Before
	public void initApplicationContext() {
		SpringContextHolder.setApplicationContextTest(applicationContext);
		SystemConfig.loadSystemConfig();
	}

	public <T> T getBean(Class<T> type) {
		return applicationContext.getBean(type);
	}

	public Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}

	public ApplicationContext getContext() {
		return applicationContext;
	}

}
