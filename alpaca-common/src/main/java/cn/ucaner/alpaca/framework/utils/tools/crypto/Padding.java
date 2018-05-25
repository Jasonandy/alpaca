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
package cn.ucaner.alpaca.framework.utils.tools.crypto;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.crypto   
* @ClassName：Padding   
* @Description：   <p> 补码方式 </p>
* <a href="https://docs.oracle.com/javase/7/docs/technotes/guides/security/StandardNames.html#Cipher"> Cipher章节</a>
* @Author： -    
* @CreatTime：2018年5月25日 上午11:28:15   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public enum Padding {
	/** 无补码 */
	NoPadding, 
	ISO10126Padding,
	OAEPPadding,
	PKCS1Padding,
	PKCS5Padding, 
	SSL3Padding
}
