package cn.ucaner.alpaca.framework.utils.tools.poi.excel.sax.handler;

import java.util.List;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.poi.excel.sax.handler   
* @ClassName：RowHandler   
* @Description：   <p> Sax方式读取Excel行处理器 </p>
* @Author： -    
* @CreatTime：2018年5月26日 下午2:38:16   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public interface RowHandler {
	
	/**
	 * 处理一行数据
	 * @param sheetIndex 当前Sheet序号
	 * @param rowIndex 当前行号
	 * @param rowList 行数据列表
	 */
	void handle(int sheetIndex, int rowIndex, List<Object> rowList);
}
