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
package cn.ucaner.alpaca.framework.utils.tools.crypto.asymmetric;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.crypto.asymmetric   
* @ClassName：AsymmetricAlgorithm   
* @Description：   <p> 非对称算法类型</p>
* @Author： -    
* @CreatTime：2018年5月25日 上午11:35:16   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public enum AsymmetricAlgorithm {
	
	RSA("RSA"), DSA("DSA");

	private String value;

	private AsymmetricAlgorithm(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
