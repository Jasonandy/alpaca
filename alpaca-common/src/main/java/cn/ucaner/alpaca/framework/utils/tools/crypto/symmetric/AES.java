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

import javax.crypto.spec.IvParameterSpec;

import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;
import cn.ucaner.alpaca.framework.utils.tools.crypto.Mode;
import cn.ucaner.alpaca.framework.utils.tools.crypto.Padding;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.crypto.symmetric   
* @ClassName：AES   
* @Description：   <p> AES加密算法实现 </p>
* 高级加密标准（英语：Advanced Encryption Standard，缩写：AES），在密码学中又称Rijndael加密法
* @Author： -    
* @CreatTime：2018年5月25日 上午11:30:56   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class AES extends SymmetricCrypto{
	
	/**
	 * 构造，默认AES/CBC/PKCS5Padding，使用随机密钥
	 */
	public AES() {
		super(SymmetricAlgorithm.AES);
	}
	
	/**
	 * 构造，使用默认的AES/CBC/PKCS5Padding
	 * @param key 密钥
	 */
	public AES(byte[] key) {
		super(SymmetricAlgorithm.AES, key);
	}
	
	/**
	 * 构造，使用随机密钥
	 * @param mode 模式{@link Mode}
	 * @param padding {@link Padding}补码方式
	 */
	public AES(Mode mode, Padding padding) {
		this(mode.name(), padding.name());
	}
	
	/**
	 * 构造
	 * @param mode 模式{@link Mode}
	 * @param padding {@link Padding}补码方式
	 * @param key 密钥，支持三种密钥长度：128、192、256位
	 */
	public AES(Mode mode, Padding padding, byte[] key) {
		this(mode.name(), padding.name(), key);
	}
	
	/**
	 * 构造
	 * @param mode 模式
	 * @param padding 补码方式
	 */
	public AES(String mode, String padding) {
		this(mode, padding, null);
	}

	/**
	 * 构造
	 * @param mode 模式
	 * @param padding 补码方式
	 * @param key 密钥，支持三种密钥长度：128、192、256位
	 */
	public AES(String mode, String padding, byte[] key) {
		super(StrUtil.format("AES/{}/{}", mode, padding), key);
	}
	
	/**
	 * 设置偏移向量
	 * @param iv {@link IvParameterSpec}偏移向量
	 * @return 自身
	 */
	public AES setIv(IvParameterSpec iv){
		super.setParams(iv);
		return this;
	}

}
