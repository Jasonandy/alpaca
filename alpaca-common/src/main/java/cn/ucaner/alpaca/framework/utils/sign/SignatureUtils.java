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
	 * 消息加签
	 * @param paramsMap
	 * @return
	 */
	public static String rsa256Sign(Map<String, String> paramsMap) {
		//支付平台公钥字符串不参与加签,只作为进行消息加签的钥匙
		String ygkzPrivateKey = paramsMap.get("ygkzPrivateKey");
		paramsMap.remove("ygkzPrivateKey");
		if (StringUtils.isBlank(ygkzPrivateKey)) {
			return null;
		}
		//排序
		String sortContent = getSortContent(paramsMap);
		//加签
		String sign = SignatureUtils.rsa256Sign(sortContent, ygkzPrivateKey);
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
		//String privateKey =
		//		"MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC4pTB7ZqKmxWUSW1xE8UVtqm5mWyiG6ocJ1iWIHQqRO8zxO6hiRD+PK3R1CADkTcb6MaeDxdp+hxUN2cPXIbEUSjBHu6xFkJiJYhD/qaD7QNcRAELowzV3zYBVyIbih3YMCUSeRqj7N0yGuy7Lmy5DSiRNHcWAQWWLAMoByTlxRuEiLPe1fuhBKOOLlnTn+7BgrVrC9XDkhTIeom9WMfHY+HmDpU5WwZvuHJuVahued1vKOKy1qcJsmkCTGjCIMDmAVs1IzyGd16VojLv2FBGoid58zlo5XsoGsodCBlM5r8GmEkmtMfKxYmNxV+hWUPrh4j7dXPiaboI8ZUBwZk3XAgMBAAECggEBAKxpevLPLHODAFR6wJaTn5u+N6YV2qrYFU3nC1akn3hrmXtrlFhll9/M2MpqtcJ4qaJ3eQ6/Ub0xz0QGoiqgiCQE/j4NDNhMI1KtImhH8UyLCAcU8mU72hJK7lmri9+8U0r74HnWSvWAdlGcOR7fgPxOH8VuVjvjVLjN/NJcHeoZhVzdd3eLPQ39hYJOJqi4ZlBttOsAiUK2hzdgvbAgiRuOTdNMiRPeoYEBxqAFkM68KR4S2Zkk7bkhVeqjUC1oeOmwdE9uBwT9AvJRSyrbQwlbSt9B+9B9ftduo9pE/8iQYIz1j+EGYHB6i0CTDt8t8uen2hJrZWmVzj8IjCIvQkECgYEA/USOqWKmjdN+pvrD0ZtKqpdBuoto1hJtq10UAAwCPKnKovRcFBhT0sGpEG0ZrNu+m7TScKtEjmcRJ1QCH1FEBqvBk6LviBEBeHHRd5sp5eQAbzcrm/E5tvaxhch4u96zj6qv5Vt8sCgWXRNGtuNQtTaeo8UFJXPmemWvulh0+CECgYEAuqMegNZmbgbCtQNuZYqVeaDs7oOFaIcEttPLxDqiy3w/RdFJBEswdNWsy1Oi2owqsVtzHLyUIwH4mOJ8fDAnzCDnAnhWFksYXWbCtQhyU6yddqya8fpHY5rVrotkOd84WN1ilK9BSHKvoJlAethW2J+RhqmYZ2M1vZ0+R+v2JvcCgYAunhLgTL85dcdnNtsaVsoskkDP9F8soCG9nBlVVOCIh/w7eF0Ged/b+DeFRX+nWJ9CC8t8X5nz2DbJFWZ6mzu5Op4b7a7HTdIGeHTE3jOdFBWcYvxM7N7htZDBfj/y3LASbqmHvwo5ZnePVD/84+R0JoSWwmoLFcVDnDn3Q9br4QKBgF7X9fBTA8p19Qw3qio/uqYMeVrbyzfLJUIjbzFQ+tmdUioQqKJd80nsK9tHrUKSaD+o0V6RFlaT8dj/f3M8pXy+W6aNsHGzx7XvOpL0r+SFm59rJ3JAVXbwgBYrD8u4+9Fs72PPi8VdQpLCTlofBkMfE7zzAlfHus+Y0MWLy5MRAoGBANEEWFh/7Li0w4PK6SNkRsUD1GbqpYfRalJcXu7T3fqy8iGc/HnvJZ5Mncl50T1l88O5tRXMVLT0AQO0kkjfoHakL4Ig/OqL8yqA36fidYoieDdFfJmKPH5hNft/AT8gdDvfDOtpAohM9IPN/j/pncyqlZRNP1LFBq6Gp6AaHJki";
		//String publicKey =
		//		"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuKUwe2aipsVlEltcRPFFbapuZlsohuqHCdYliB0KkTvM8TuoYkQ/jyt0dQgA5E3G+jGng8XafocVDdnD1yGxFEowR7usRZCYiWIQ/6mg+0DXEQBC6MM1d82AVciG4od2DAlEnkao+zdMhrsuy5suQ0okTR3FgEFliwDKAck5cUbhIiz3tX7oQSjji5Z05/uwYK1awvVw5IUyHqJvVjHx2Ph5g6VOVsGb7hyblWobnndbyjistanCbJpAkxowiDA5gFbNSM8hndelaIy79hQRqInefM5aOV7KBrKHQgZTOa/BphJJrTHysWJjcVfoVlD64eI+3Vz4mm6CPGVAcGZN1wIDAQAB";
		//String password =
		//		"appId=sun90f99466b08c4c7&merchantNo=9683091070339795&nonceStr=UcWyb5ohEEnb5itLefNGFMNJumGwJDi&outOrderNo=10101201709210000003&timeStamp=2017-09-21 22:08:54";
		//String encryptStr = rsa256Sign(password, privateKey);
		//System.out.println("encryptStr:" + encryptStr);
		/*String encryptStr =
				"GnvHK8SjsLoN7MfpY2gSfUfXwr3of7cL9/5BtFa8lCpYDYeHqSPmMjWJFWHM9vhjowznvv8NQFq9s2msUWb7Fn8v4YU91HG3Y7ldMU//4+iYWy721ezAHWvzmPX2PbZdVfvumrQ7AaROoS8ecerjVS+e1BomKTTwWHhjBeDqoPZgXbXXeUPbdobfgfdDYkXNd8VHksRZz7RSj8Xix/uRNpjoUkRRJ8E2+5BWQHP5ldWMpwiO5Cve5ksKIPsIY+Fu/tTvJ90UxNw2pxe4jJffhcYZrjqRSUVp5+B/HF7y0X7EPcuuBUilGa8igFp/tNMRrYBV23D2COWMO3CW7Bhe4w==";
		System.out.println(rsa256CheckContent(password, encryptStr, publicKey));*/
		//System.out.println(encryptStr.length());

		/*String publicKey =
				"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuDfinAVacwdfIv/P2zqXUL2DjFzhw9SEfAd+JQZNlWh6bMZx6JAxwcvLSy9w8UGHr7EOhcjmd1uGiZKuixCbsiBAuUpTFq76LUhOlY4een4phoIJ8JNIZm9n6Bff4SlN0+6pNhp96Wt4vZpB6cMcyJaL0yVVbEs37oe17bNyuhnnTTdjSBSu9GTcW8erBOTgwxl7nLgU1Mm2nBdJ495eBa78B1ZppoJ3O2iJ5jDlV5Go5/5XdKLB0+/+EIMcC8Yb/ZlMzzf4Dgjpo0LR8ILDoiEkRHVQguTojaiZjbS4g0qwb9NEYYStEQSoiJ1wsGa1tWYALwiGcRbCun1Zg1e+SQIDAQAB";

		String str =
				"{\"appId\":\"sun90f99466b08c4c7\",\"cashierId\":\"f41ad7bdc6934651ad2a71e8947168bc\",\"cashierUrl\":\"http://cashierdev.968309.cn/trade/choicePayment\",\"merchantNo\":\"9683091070339795\",\"nonceStr\":\"663ee4b4ecaf4510b26f330b88b12001\",\"sign\":\"ZfPt7UvbNNIBUsovBE2t+BMy1gUCrJcxXtdPl8q3tgf0G6sj7xks2F/ikYD1ptpzeEnCrkUpNKODQliaMme+Aiyy49yYMXkXtTRO2HZ2PBOPHa+3R+hprQssH/L1pIZ4KrJvZQVRflpp8hvEFWUYiXyFVNpqJXrnpmBIFerW7S8LBm2Rf066NiVqMhKAQfWve4/y8dFQCNH6PUSfpz1A/xU6bG/kKLVXn7c+crFP+Pe8qWuexUoMuyio7mNAvVPgBRhRUur/UxcYMG+beUFQgTOe3SXNbzL8Mn8fMx/MYCUQRuHryigSn2qCZgHnbUKQvlh6hd7RKaiFfao4I/EI3g==\",\"timeStamp\":\"2017-09-20 21:08:49\"}";
		Map<String, String> dataMap = (Map<String, String>) JSON.parse(str);
		String encryptStr = dataMap.remove("sign");
		String password = buildSortJson(dataMap);
		System.out.println(rsa256CheckContent(password, encryptStr, publicKey));*/
		try {
			Map<String, Object> map = genKeyPair();
			System.out.println("私钥:" + getPrivateKey(map));
			System.out.println("公钥:" + getPublicKey(map));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
