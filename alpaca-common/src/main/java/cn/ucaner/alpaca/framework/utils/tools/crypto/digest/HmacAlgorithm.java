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
package cn.ucaner.alpaca.framework.utils.tools.crypto.digest;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.crypto.digest   
* @ClassName：HmacAlgorithm   
* @Description：   <p> HMAC算法类型 </p>
* @see: https://docs.oracle.com/javase/7/docs/technotes/guides/security/StandardNames.html#Mac
* @Author： -    
* @CreatTime：2018年5月25日 上午11:31:23   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public enum HmacAlgorithm {
	HmacMD5("HmacMD5"), 
	HmacSHA1("HmacSHA1"), 
	HmacSHA256("HmacSHA256"), 
	HmacSHA384("HmacSHA384"), 
	HmacSHA512("HmacSHA512");

	private String value;

	private HmacAlgorithm(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}