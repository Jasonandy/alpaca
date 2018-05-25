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
* @ClassName：Mode   
* @Description：   <p> 模式 </p>
* @see <a href="https://docs.oracle.com/javase/7/docs/technotes/guides/security/StandardNames.html#Cipher"> Cipher章节</a>
* @Author： -    
* @CreatTime：2018年5月25日 上午11:28:43   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public enum Mode{
	/** 无模式 */
	NONE, 
	/** Cipher Block Chaining */
	CBC, 
	/** Cipher Feedback */
	CFB, 
	/** A simplification of OFB */
	CTR,
	/** Cipher Text Stealing */
	CTS,
	/** Electronic Codebook */
	ECB, 
	/** Output Feedback */
	OFB, 
	/** Propagating Cipher Block */
	PCBC;
}
