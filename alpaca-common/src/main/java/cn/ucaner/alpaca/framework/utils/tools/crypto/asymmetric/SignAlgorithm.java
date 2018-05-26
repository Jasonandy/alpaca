package cn.ucaner.alpaca.framework.utils.tools.crypto.asymmetric;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.crypto.asymmetric   
* @ClassName：SignAlgorithm   
* @Description：   <p> 签名算法类型<br> </p>
* https://docs.oracle.com/javase/7/docs/technotes/guides/security/StandardNames.html#Signature
* 
* @Author： -    
* @CreatTime：2018年5月26日 下午2:59:26   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public enum SignAlgorithm {
	// The RSA signature algorithm
	NONEwithRSA("NONEwithRSA"), //

	// The MD2/MD5 with RSA Encryption signature algorithm
	MD2withRSA("MD2withRSA"), //
	MD5withRSA("MD5withRSA"), //

	// The signature algorithm with SHA-* and the RSA
	SHA1withRSA("SHA1withRSA"), //
	SHA256withRSA("SHA256withRSA"), //
	SHA384withRSA("SHA384withRSA"), //
	SHA512withRSA("SHA512withRSA"), //

	// The Digital Signature Algorithm
	NONEwithDSA("NONEwithDSA"), //
	// The DSA with SHA-1 signature algorithm
	SHA1withDSA("SHA1withDSA"), //

	// The ECDSA signature algorithms
	NONEwithECDSA("NONEwithECDSA"), //
	SHA1withECDSA("SHA1withECDSA"), //
	SHA256withECDSA("SHA256withECDSA"), //
	SHA384withECDSA("SHA384withECDSA"), //
	SHA512withECDSA("SHA512withECDSA");//

	private String value;

	/**
	 * 构造
	 * 
	 * @param value 算法字符表示，区分大小写
	 */
	private SignAlgorithm(String value) {
		this.value = value;
	}

	/**
	 * 获取算法字符串表示，区分大小写
	 * 
	 * @return 算法字符串表示
	 */
	public String getValue() {
		return this.value;
	}
}
