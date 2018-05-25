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
package cn.ucaner.alpaca.framework.utils.tools.http;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.http   
* @ClassName：CookiePool   
* @Description：   <p> Cookie池。此池针对所有HTTP请求可用 </p>
* 此Cookie池用于模拟浏览器的Cookie，当访问后站点，记录Cookie，下次再访问这个站点时，一并提交Cookie到站点。
* @Author： -    
* @CreatTime：2018年5月25日 上午11:06:49   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class CookiePool {
	
	//key: host, value: cookies字符串
	private static Map<String, String> cookies = new ConcurrentHashMap<String, String>();
	
	/**
	 * 获得某个网站的Cookie信息
	 * @param host 网站Host
	 * @return Cookie字符串
	 */
	public static String get(String host) {
		return cookies.get(host);
	}
	
	/**
	 * 将某个网站的Cookie放入Cookie池
	 * @param host 网站Host
	 * @param cookie Cookie字符串
	 */
	public static void put(String host, String cookie) {
		cookies.put(host, cookie);
	}
	
	/**
	 * 清空Cookie
	 * @since 3.0.7
	 */
	public static void clear(){
		cookies.clear();
	}
}
