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
package cn.ucaner.alpaca.framework.utils.tools.core.io;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.io   
* @ClassName：LineHandler   
* @Description：   <p> 行处理器 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午1:07:02   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface LineHandler {
	/**
	 * 处理一行数据，可以编辑后存入指定地方
	 * @param line 行
	 */
	void handle(String line);
}
