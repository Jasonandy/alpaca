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
package cn.ucaner.alpaca.framework.utils.encrypt;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
* @Package：cn.ucaner.framework.utils   
* @ClassName：CryptAES   
* @Description：   <p> CryptAES</p>
* @Author： - Jason 
* @CreatTime：2017年8月30日 下午2:14:47   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class CryptAES {

	private static final String AESTYPE = "AES/ECB/PKCS5Padding";

	public static String AES_Encrypt(String keyStr, String plainText) {
		byte[] encrypt = null;
		try {
			Key key = generateKey(keyStr);
			Cipher cipher = Cipher.getInstance(AESTYPE);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			encrypt = cipher.doFinal(plainText.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String(Base64.encodeBase64(encrypt));
	}

	public static String AES_Decrypt(String keyStr, String encryptData) {
		byte[] decrypt = null;
		try {
			Key key = generateKey(keyStr);
			Cipher cipher = Cipher.getInstance(AESTYPE);
			cipher.init(Cipher.DECRYPT_MODE, key);
			decrypt = cipher.doFinal(Base64.decodeBase64(encryptData));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String(decrypt).trim();
	}

	private static Key generateKey(String key) throws Exception {
		try {
			SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
			return keySpec;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
