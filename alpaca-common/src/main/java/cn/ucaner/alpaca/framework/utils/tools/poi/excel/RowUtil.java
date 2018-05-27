package cn.ucaner.alpaca.framework.utils.tools.poi.excel;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.poi.excel   
* @ClassName：RowUtil   
* @Description：   <p> Excel中的行{@link Row}封装工具类 </p>
* @Author： -    
* @CreatTime：2018年5月26日 下午2:40:53   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class RowUtil {
	/**
	 * 获取已有行或创建新行
	 * 
	 * @param sheet Excel表
	 * @param rowIndex 行号
	 * @return {@link Row}
	 * @since 4.0.2
	 */
	public static Row getOrCreateRow(Sheet sheet, int rowIndex) {
		Row row = sheet.getRow(rowIndex);
		if (null == row) {
			row = sheet.createRow(rowIndex);
		}
		return row;
	}

	/**
	 * 读取一行
	 * 
	 * @param row 行
	 * @param cellEditor 单元格编辑器
	 * @return 单元格值列表
	 */
	public static List<Object> readRow(Row row, CellEditor cellEditor) {
		if (null == row) {
			return new ArrayList<>(0);
		}
		final short length = row.getLastCellNum();
		if (length < 0) {
			return new ArrayList<>(0);
		}
		final List<Object> cellValues = new ArrayList<>((int) length);
		Object cellValue;
		boolean isAllNull = true;
		for (short i = 0; i < length; i++) {
			cellValue = CellUtil.getCellValue(row.getCell(i), cellEditor);
			isAllNull &= StrUtil.isEmptyIfStr(cellValue);
			cellValues.add(cellValue);
		}

		if (isAllNull) {
			// 如果每个元素都为空，则定义为空行
			return new ArrayList<>(0);
		}
		return cellValues;
	}

	/**
	 * 写一行数据
	 * 
	 * @param row 行
	 * @param rowData 一行的数据
	 * @param styleSet 单元格样式集，包括日期等样式
	 */
	public static void writeRow(Row row, Iterable<?> rowData, StyleSet styleSet) {
		int i = 0;
		Cell cell;
		for (Object value : rowData) {
			cell = row.createCell(i);
			CellUtil.setCellValue(cell, value, styleSet);
			i++;
		}
	}
}
