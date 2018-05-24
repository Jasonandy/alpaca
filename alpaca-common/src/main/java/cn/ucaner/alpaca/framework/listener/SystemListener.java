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
package cn.ucaner.alpaca.framework.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ucaner.alpaca.framework.config.SystemConfig;

/**
* @Package：cn.ucaner.framework.listener   
* @ClassName：SystemListener   
* @Description：   <p> 系统初始化
* 
* - 监听容器的启动 - 
* </p>
* @Author： - Jason 
* @CreatTime：2017年8月30日 下午1:52:43   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class SystemListener implements ServletContextListener {
	
	private static Logger logger = LoggerFactory.getLogger(SystemListener.class);
	
	/**
	* 描述:监听器   web.xml  初始化容器   by Jason
	* web.xml  顺序  Listen  -- >  -- >fliter   --> servlet   ? (不太记得)
	* @param arg0
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		logger.info("System Configuration load start......");
		//加载系统先关配置文件  
		SystemConfig.loadSystemConfig();
		loadBusinessesXml();
		logger.info("System Configuration load end......");
	}

	/**
	 * 加载系统业务配置文件
	 */
	public void loadBusinessesXml() {
		// List<File> files = FileUtils.searchFiles(this.getClass().getClassLoader().getResource("/rules").getPath(),
		// new String[] { "xml" }, false);
		// for (File file : files) {
		// Businesses businesses = RuleConvertUtil.xml2Businesses(file);
		// SystemConfig.businessesMap.put(businesses.getCode(), businesses);
		// }
	}


	/** 
	* 描述:  销毁容器  
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		//关闭等处理
	}
}
