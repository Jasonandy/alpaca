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
package cn.ucaner.alpaca.framework.utils.tools.poi.excel.sax;

import java.util.List;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.poi.excel.sax   
* @ClassName：RowHandler   
* @Description：   <p> Sax方式读取Excel行处理器 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:14:22   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface RowHandler {
	
	/**
	 * 处理一行数据
	 * @param sheetIndex 当前Sheet序号
	 * @param rowIndex 当前行号
	 * @param rowlist 行数据列表
	 */
	void handle(int sheetIndex, int rowIndex, List<String> rowlist);
}
