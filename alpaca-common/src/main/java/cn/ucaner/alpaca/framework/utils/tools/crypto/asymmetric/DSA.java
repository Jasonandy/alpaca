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

import java.security.PrivateKey;
import java.security.PublicKey;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.crypto.asymmetric   
* @ClassName：DSA   
* @Description：   <p> DSA加密算法 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午11:34:23   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class DSA extends AsymmetricCrypto {

	private static final AsymmetricAlgorithm ALGORITHM_DSA = AsymmetricAlgorithm.DSA;

	// ------------------------------------------------------------------ Constructor start
	/**
	 * 构造，创建新的私钥公钥对
	 */
	public DSA() {
		super(ALGORITHM_DSA);
	}
	
	/**
	 * 构造
	 * 私钥和公钥同时为空时生成一对新的私钥和公钥<br>
	 * 私钥和公钥可以单独传入一个，如此则只能使用此钥匙来做加密或者解密
	 * 
	 * @param privateKeyBase64 私钥Base64
	 * @param publicKeyBase64 公钥Base64
	 */
	public DSA(String privateKeyBase64, String publicKeyBase64) {
		super(ALGORITHM_DSA, privateKeyBase64, publicKeyBase64);
	}

	/**
	 * 构造 私钥和公钥同时为空时生成一对新的私钥和公钥<br>
	 * 私钥和公钥可以单独传入一个，如此则只能使用此钥匙来做加密或者解密
	 * 
	 * @param privateKey 私钥
	 * @param publicKey 公钥
	 */
	public DSA(byte[] privateKey, byte[] publicKey) {
		super(ALGORITHM_DSA, privateKey, publicKey);
	}
	
	/**
	 * 构造 <br>
	 * 私钥和公钥同时为空时生成一对新的私钥和公钥<br>
	 * 私钥和公钥可以单独传入一个，如此则只能使用此钥匙来做加密或者解密
	 * 
	 * @param privateKey 私钥
	 * @param publicKey 公钥
	 * @since 3.1.1
	 */
	public DSA(PrivateKey privateKey,PublicKey publicKey) {
		super(ALGORITHM_DSA, privateKey, publicKey);
	}
	// ------------------------------------------------------------------ Constructor end
}
