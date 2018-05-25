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
package cn.ucaner.alpaca.framework.utils.tools.crypto.symmetric;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.crypto.symmetric   
* @ClassName：SymmetricAlgorithm   
* @Description：   <p> 对称算法类型 </p>
* see: https://docs.oracle.com/javase/7/docs/technotes/guides/security/StandardNames.html#KeyGenerator
* @Author： -    
* @CreatTime：2018年5月25日 上午11:30:01   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public enum SymmetricAlgorithm {
	/** 默认的AES加密方式：AES/CBC/PKCS5Padding */
	AES("AES"), 
	ARCFOUR("ARCFOUR"), 
	Blowfish("Blowfish"), 
	/** 默认的DES加密方式：DES/ECB/PKCS5Padding */
	DES("DES"), 
	/** 3DES算法 */
	DESede("DESede"), 
	RC2("RC2"),

	PBEWithMD5AndDES("PBEWithMD5AndDES"), 
	PBEWithSHA1AndDESede("PBEWithSHA1AndDESede"), 
	PBEWithSHA1AndRC2_40("PBEWithSHA1AndRC2_40");

	private String value;

	private SymmetricAlgorithm(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}