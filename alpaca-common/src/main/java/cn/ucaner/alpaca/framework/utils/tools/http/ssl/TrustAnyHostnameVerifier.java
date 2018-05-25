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
package cn.ucaner.alpaca.framework.utils.tools.http.ssl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.http.ssl   
* @ClassName：TrustAnyHostnameVerifier   
* @Description：   <p>  https 域名校验 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午11:07:14   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class TrustAnyHostnameVerifier implements HostnameVerifier {
	
	@Override
	public boolean verify(String hostname, SSLSession session) {
		return true;// 直接返回true
	}
}
