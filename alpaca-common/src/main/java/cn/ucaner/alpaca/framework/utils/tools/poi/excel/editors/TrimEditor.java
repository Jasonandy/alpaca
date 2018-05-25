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
package cn.ucaner.alpaca.framework.utils.tools.poi.excel.editors;

import org.apache.poi.ss.usermodel.Cell;

import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;
import cn.ucaner.alpaca.framework.utils.tools.poi.excel.CellEditor;

/**
* @Package：cn.ucaner.tools.poi.excel.editors   
* @ClassName：TrimEditor   
* @Description：   <p> 去除String类型的单元格值两边的空格</p>
* @Author： -  
* @CreatTime：2017-11-3 上午11:55:48   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class TrimEditor implements CellEditor{

	@Override
	public Object edit(Cell cell, Object value) {
		if(value instanceof String) {
			return StrUtil.trim((String)value);
		}
		return value;
	}

}
