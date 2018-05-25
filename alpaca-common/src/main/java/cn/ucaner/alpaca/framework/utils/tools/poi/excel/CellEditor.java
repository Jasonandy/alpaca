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
package cn.ucaner.alpaca.framework.utils.tools.poi.excel;

import org.apache.poi.ss.usermodel.Cell;

/**
* @Package：cn.ucaner.tools.poi.excel   
* @ClassName：CellEditor   
* @Description：   <p> 单元格编辑器接口</p>
* @Author： -  
* @CreatTime：2017-11-3 上午11:55:06   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public interface CellEditor {
	/**
	 * 编辑
	 * @param cell 单元格对象，可以获取单元格行、列样式等信息
	 * @param value 单元格值
	 * @return 编辑后的对象
	 */
	public Object edit(Cell cell, Object value);
}
