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

/**
* @Package：cn.ucaner.common.utils.encrypt   
* @ClassName：EncryptAndDecryptUtils   
* @Description：   <p> MD5加密、SHA加密, Base64加解密, DES加解密, AES加解密 </p>
* @Author： - Jason 
* @CreatTime：2017年10月25日 下午5:51:16   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class EncryptAndDecryptUtils {
	
	/**
	 * MD5 加密   by Jason
	 * @param value 待加密字符
	 * @return
	 */
	public static String md5Encrypt(String value){
		String result = null;
		if(value != null && !"".equals(value.trim())){
			result =  MD5Utils.encrypt(value,MD5Utils.MD5_KEY);
		}
		return result;
	}
	
	/**
	 * SHA加密
	 * @param value  待加密字符
	 * @return 密文
	 */
	public static String shaEncrypt(String value){
		String result = null;
		if(value != null && !"".equals(value.trim())){
			result =  MD5Utils.encrypt(value,MD5Utils.SHA_KEY);
		}
		return result;
	}
	
	/**
	 * BASE64 加密
	 * @param value 待加密字符串
	 * @return
	 */
	public static String base64Encrypt(String value){
		String result = null;
		if(value != null && !"".equals(value.trim())){
			result =  Base64Utils.encrypt(value.getBytes());
		}
		return result;
		
	}
	
	/**
	 * BASE64 解密
	 * @param value 待解密字符串
	 * @return
	 */
	public static String base64Decrypt(String value){
		String result = null;
		try {
			if(value != null && !"".equals(value.trim())){
				byte[] bytes = Base64Utils.decrypt(value);
				result = new String(bytes);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * DES加密<br>
	 * @param value 待加密字符
	 * @param key   若key为空，则使用默认key
	 * @return      加密成功返回密文，否则返回null
	 */
	public static String desEncrypt(String value,String key){
		key = key == null ? DesUtils.KEY : key;
		String result = null;
		
		try {
			if(value != null && !"".equals(value.trim())){
				result = DesUtils.encrypt(value, key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * DES解密
	 * @param value  待解密字符
	 * @param key    若key为空，则使用默认key
	 * @return
	 */
	public static String desDecrypt(String value,String key){
		key = key == null ? DesUtils.KEY : key;
		String result = null;
		
		try {
			if(value != null && !"".equals(value.trim())){
				result =  DesUtils.decrypt(value, key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * AES加密
	 * @param value 待加密内容
	 * @param key   秘钥
	 * @return
	 */
	public static String aesEncrypt(String value,String key ){
		key = key == null ? AESUtils.KEY : key;
		String result = null;
		try {
			if(value != null && !"".equals(value.trim())){		//value is not null
				result = AESUtils.encrypt(value,key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * AES解密
	 * @param value 待解密内容
	 * @param key   秘钥
	 * @return 
	 */
	public static String aesDecrypt(String value , String key){
		key = key == null ? AESUtils.KEY : key;
		String result = null;
		try {
			if(value != null && !"".equals(value.trim())){		//value is not null
				result = AESUtils.decrypt(value,key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	 /**
     *For Test By Jason 
     */
    public static void main(String[] args) {
		
	}
}
