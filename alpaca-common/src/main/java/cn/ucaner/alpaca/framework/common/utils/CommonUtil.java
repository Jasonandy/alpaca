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
package cn.ucaner.alpaca.framework.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import cn.ucaner.alpaca.framework.config.SystemConfig;

/**
* @Package：cn.ucaner.common.utils   
* @ClassName：CommonUtil   
* @Description：   <p> 通用工具类 </p>
* @Author： - Jason 
* @CreatTime：2017年10月24日 上午11:17:15   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class CommonUtil {
	
	/**
	 * 系统的请求路径 
	 */
	private static String SYSTEM_REQUEST_PATH = "";

	/**
	 * 获取系统request Scheme   by Jason
	 * @return
	 */
	public static String getRequestContextPath(HttpServletRequest request) {

		if (StringUtils.isBlank(SYSTEM_REQUEST_PATH)) {
			//获取系统的前缀 https  or http 
			String requestScheme = SystemConfig.getStringValue("system.request.scheme", "https://");
			//判断是否为80端口  非80端口 则拼接 https or http + "ServerName:xxx"
			SYSTEM_REQUEST_PATH = requestScheme + request.getServerName()+ (80 == request.getServerPort() ? "" : ":" + request.getServerPort());
		}
		//拼接上下文路径
		return SYSTEM_REQUEST_PATH.concat(request.getContextPath());
	}
}
