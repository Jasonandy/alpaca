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

import cn.ucaner.alpaca.framework.utils.tools.poi.excel.CellEditor;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.poi.excel.editors   
* @ClassName：NumericToIntEditor   
* @Description：   <p> POI中NUMRIC类型的值默认返回的是Double类型，此编辑器用于转换其为int型 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:17:33   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class NumericToIntEditor implements CellEditor{

	@Override
	public Object edit(Cell cell, Object value) {
		if(value instanceof Number) {
			return ((Number)value).intValue();
		}
		return value;
	}

}
