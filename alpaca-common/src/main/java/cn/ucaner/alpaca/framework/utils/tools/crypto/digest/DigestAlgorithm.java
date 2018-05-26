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
* @ClassName：DigestAlgorithm   
* @Description：   <p> 摘要算法类型 </p>
* @see: https://docs.oracle.com/javase/7/docs/technotes/guides/security/StandardNames.html#MessageDigest
* @Author： -    
* @CreatTime：2018年5月25日 上午11:33:29   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public enum DigestAlgorithm {
	MD2("MD2"), 
	MD5("MD5"), 
	SHA1("SHA-1"), 
	SHA256("SHA-256"), 
	SHA384("SHA-384"), 
	SHA512("SHA-512");

	private String value;

	/**
	 * 构造
	 * 
	 * @param value 算法字符串表示
	 */
	private DigestAlgorithm(String value) {
		this.value = value;
	}

	/**
	 * 获取算法字符串表示
	 * @return 算法字符串表示
	 */
	public String getValue() {
		return this.value;
	}
}