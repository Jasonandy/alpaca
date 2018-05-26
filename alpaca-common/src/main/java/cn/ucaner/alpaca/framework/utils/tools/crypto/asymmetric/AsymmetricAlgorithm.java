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
	RSA("RSA"), DSA("DSA"), EC("EC");

	private String value;

	/**
	 * 构造
	 * @param value 算法字符表示，区分大小写
	 */
	private AsymmetricAlgorithm(String value) {
		this.value = value;
	}

	/**
	 * 获取算法字符串表示，区分大小写
	 * @return 算法字符串表示
	 */
	public String getValue() {
		return this.value;
	}
}
