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
package cn.ucaner.alpaca.framework.utils.sign;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

import cn.ucaner.alpaca.framework.constant.GlobalConstant;
import cn.ucaner.alpaca.framework.exception.SystemException;

/**
* @Package：cn.ucaner.common.utils   
* @ClassName：SignatureUtils   
* @Description：   <p> 加签与验签工具类 </p>
* @Author： - Jason 
* @CreatTime：2017年10月24日 上午10:47:54   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class SignatureUtils {
	
	private static Logger logger = LoggerFactory.getLogger(SignatureUtils.class);
	/**
	 * 公/私钥生成算法:RSA,强制要求RSA密钥的长度至少为2048,因SHA256WithRSA签名算法强制要求密钥长度至少为2048
	 */
	public static final String SIGN_TYPE_RSA = "RSA";
	/**
	 * 密钥的长度
	 */
	public static final int KEY_LENGTH = 2048;
	/**
	 * 数据签名算法:SHA256WithRSA
	 */
	public static final String SIGN_SHA256RSA_ALGORITHMS = "SHA256WithRSA";
	/**
	 * RSA最大加密明文大小
	 */
	public static final int MAX_ENCRYPT_BLOCK = 117;
	/**
	 * RSA最大解密密文大小
	 */
	public static final int MAX_DECRYPT_BLOCK = 128;
	/**
	 * 获取公钥的key
	 */
	private static final String PUBLIC_KEY = "publicKey";

	/**
	 * 获取私钥的key
	 */
	private static final String PRIVATE_KEY = "privateKey";
	/**
	 * UTF-8字符集
	 */
	private static final String CHARSET_UTF8 = "UTF-8";

	/**
	 * 签名字符串标识字符
	 */
	public static final String PARAM_SIGN = "sign";
	
	
	/**
	 * 自定义私钥标识
	 */
	public static final String CUST_PRIVATE_KEY="alpacaPrivateKey";
	
	/**
	 * 自定义公钥标识
	 */
	public static final String CUST_PUBLIC_KEY="alpacaPublicKey";
	
	
	/**
	 * 消息加签
	 * @param paramsMap
	 * @return
	 */
	public static String rsa256Sign(Map<String, String> paramsMap) {
		//支付平台公钥字符串不参与加签,只作为进行消息加签的钥匙
		String custPrivateKey = paramsMap.get(CUST_PRIVATE_KEY);
		paramsMap.remove(CUST_PRIVATE_KEY);
		if (StringUtils.isBlank(custPrivateKey)) {
			return null;
		}
		//排序
		String sortContent = getSortContent(paramsMap);
		//加签
		String sign = SignatureUtils.rsa256Sign(sortContent, custPrivateKey);
		return sign;

	}

	/**
	 * 将集合内非空参数值的参数按照参数名ASCII码从小到大排序（字典序），使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串
	 * @param paramsMap
	 * @return
	 */
	public static String getSortContent(Map<String, String> paramsMap) {
		StringBuffer content = new StringBuffer();
		List<String> keys = new ArrayList<String>(paramsMap.keySet());
		Collections.sort(keys);
		int index = 0;
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = paramsMap.get(key);
			if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
				content.append( ( index == 0 ? "" : "&" ) + key + "=" + value);
				index++;
			}
		}
		return content.toString();
	}

	/**
	 * 生成密钥对(公钥和私钥)
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> genKeyPair() throws Exception {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(SIGN_TYPE_RSA);
		keyPairGen.initialize(KEY_LENGTH);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		Map<String, Object> map = new HashMap<String, Object>(2);
		map.put(PUBLIC_KEY, publicKey);
		map.put(PRIVATE_KEY, privateKey);
		return map;
	}

	/**
	 * 获取私钥
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public static String getPrivateKey(Map<String, Object> map) throws Exception {
		Key key = (Key) map.get(PRIVATE_KEY);
		return new String(Base64Utils.encode(key.getEncoded()));
	}

	/**
	 * 获取公钥
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public static String getPublicKey(Map<String, Object> map) throws Exception {
		Key key = (Key) map.get(PUBLIC_KEY);
		return new String(Base64Utils.encode(key.getEncoded()));
	}

	/**
	 * SHA256WithRSA 验签
	 * @param content
	 * @param sign
	 * @param publicKey
	 * @return
	 * @throws SystemException
	 */
	public static boolean rsa256CheckContent(String content, String sign, String publicKey) throws SystemException {
		try {
			logger.info("验签字符串:{}", content);
			//获取公钥对象
			byte[] keyBytes = Base64Utils.decodeFromString(publicKey);
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
			KeyFactory keyFactory = KeyFactory.getInstance(SIGN_TYPE_RSA);
			PublicKey pubKey = keyFactory.generatePublic(keySpec);
			//SHA256WithRSA 验签
			Signature signature = Signature.getInstance(SIGN_SHA256RSA_ALGORITHMS);
			signature.initVerify(pubKey);
			signature.update(content.getBytes(CHARSET_UTF8));
			return signature.verify(Base64.decodeBase64(sign.getBytes()));
		} catch (Exception e) {
			logger.error("rsa256CheckContent failure!RSAcontent:{},sign:{}", content, sign);
			e.printStackTrace();
			return false;

		}
	}

	/**
	 * SHA256WithRSA 加签
	 * @param content
	 * @param privateKey
	 * @return
	 * @throws SystemException
	 */
	public static String rsa256Sign(String content, String privateKey) {
		try {
			//获取私钥对象
			byte[] keyBytes = Base64Utils.decodeFromString(privateKey);
			PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
			KeyFactory keyFactory = KeyFactory.getInstance(SIGN_TYPE_RSA);
			PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);

			//SHA256WithRSA 加签
			Signature signature = Signature.getInstance(SIGN_SHA256RSA_ALGORITHMS);
			signature.initSign(priKey);
			signature.update(content.getBytes(CHARSET_UTF8));
			byte[] signed = signature.sign();
			return new String(Base64.encodeBase64(signed));
		} catch (Exception e) {
			logger.error("rsa256Sign failure!RSAcontent:{},sign:{}", content, e.getStackTrace());
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * @param jsonData
	 * @return
	 */
	public static String buildSortJson(Map<String, String> dataMap) {
		StringBuffer sortSb = new StringBuffer();
		dataMap = paraFilter(dataMap);
		List<String> jsonKeys = new ArrayList<>();
		for (String key : dataMap.keySet()) {
			if (!PARAM_SIGN.equals(key)) {//签名标识字段不参与签名
				jsonKeys.add(key);
			}
		}
		Collections.sort(jsonKeys);

		for (String jsonKey : jsonKeys) {
			if (sortSb.length() > 0) {
				sortSb.append(GlobalConstant.STRING_AND_CHAR);
			}
			sortSb.append(jsonKey).append(GlobalConstant.STRING_ASSIGN_CHAR).append(dataMap.get(jsonKey));
		}

		return sortSb.toString();
	}

	/**
	 * 除去数组中的空值和签名参数
	 * @param sArray
	 * @return
	 */
	public static Map<String, String> paraFilter(Map<String, String> sArray) {
		Map<String, String> result = new HashMap<String, String>();
		if (sArray == null || sArray.size() <= 0) {
			return result;
		}
		for (String key : sArray.keySet()) {
			String value = String.valueOf(sArray.get(key));
			if (value == null || value.equals("") || PARAM_SIGN.equalsIgnoreCase(key)) {
				continue;
			}
			result.put(key, value);
		}
		return result;
	}

	public static void main(String[] args) {
		try {
			Map<String, Object> map = genKeyPair();
			HashMap<String, String> signMap = new HashMap<String, String>();
			signMap.put(CUST_PRIVATE_KEY, getPrivateKey(map));
			signMap.put("content", "jasonandy@hotmail.com");
			String rsa256Sign = rsa256Sign(signMap);
			System.out.println(rsa256Sign);
			/*System.out.println("私钥:" + getPrivateKey(map));
			System.out.println("公钥:" + getPublicKey(map));
			String sign = rsa256Sign("jasonandy@hotmail.com", getPrivateKey(map));
			System.out.println(rsa256Sign("jasonandy@hotmail.com", getPrivateKey(map)));
			System.out.println(rsa256CheckContent("jasonandy", sign, getPublicKey(map)));*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
