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
* @ClassName：DES   
* @Description：   <p> DES加密算法实现 </p>
*  DES全称为Data Encryption Standard，即数据加密标准，是一种使用密钥加密的块算法
* @Author： -    
* @CreatTime：2018年5月25日 上午11:30:31   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class DES extends SymmetricCrypto{
	
	/**
	 * 构造，默认DES/ECB/PKCS5Padding，使用随机密钥
	 */
	public DES() {
		super(SymmetricAlgorithm.DES);
	}
	
	/**
	 * 构造，使用默认的DES/ECB/PKCS5Padding
	 * @param key 密钥
	 */
	public DES(byte[] key) {
		super(SymmetricAlgorithm.DES, key);
	}
	
	/**
	 * 构造，使用随机密钥
	 * @param mode 模式{@link Mode}
	 * @param padding {@link Padding}补码方式
	 */
	public DES(Mode mode, Padding padding) {
		this(mode.name(), padding.name());
	}
	
	/**
	 * 构造
	 * @param mode 模式{@link Mode}
	 * @param padding {@link Padding}补码方式
	 * @param key 密钥，支持三种密钥长度：128、192、256位
	 */
	public DES(Mode mode, Padding padding, byte[] key) {
		this(mode.name(), padding.name(), key);
	}
	
	/**
	 * 构造
	 * @param mode 模式
	 * @param padding 补码方式
	 */
	public DES(String mode, String padding) {
		this(mode, padding, null);
	}

	/**
	 * 构造
	 * @param mode 模式
	 * @param padding 补码方式
	 * @param key 密钥，支持三种密钥长度：128、192、256位
	 */
	public DES(String mode, String padding, byte[] key) {
		super(StrUtil.format("DES/{}/{}", mode, padding), key);
	}
	
	/**
	 * 设置偏移向量
	 * @param iv {@link IvParameterSpec}偏移向量
	 * @return 自身
	 */
	public DES setIv(IvParameterSpec iv){
		super.setParams(iv);
		return this;
	}

}
