package cn.ucaner.alpaca.framework.utils.tools.poi.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import cn.ucaner.alpaca.framework.utils.tools.core.collection.CollUtil;
import cn.ucaner.alpaca.framework.utils.tools.poi.excel.ExcelUtil;
import cn.ucaner.alpaca.framework.utils.tools.poi.excel.sax.Excel03SaxReader;
import cn.ucaner.alpaca.framework.utils.tools.poi.excel.sax.Excel07SaxReader;
import cn.ucaner.alpaca.framework.utils.tools.poi.excel.sax.handler.RowHandler;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.poi.test   
* @ClassName：ExcelSaxReadTest   
* @Description：   <p> Excel sax方式读取 </p>
* @Author： -    
* @CreatTime：2018年5月26日 下午2:44:23   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class ExcelSaxReadTest {
	
	@Test
	public void readBySaxTest() {
		ExcelUtil.readBySax("blankAndDateTest.xlsx", 0, createRowHandler());
	}
	
	@Test
	public void excel07Test() {
		Excel07SaxReader reader = new Excel07SaxReader(createRowHandler());
		reader.read("aaa.xlsx", 0);
		
		//工具化快速读取
		ExcelUtil.read07BySax("aaa.xlsx", 0, createRowHandler());
	}
	
	@Test
	public void excel03Test() {
		Excel03SaxReader reader = new Excel03SaxReader(createRowHandler());
		reader.read("aaa.xls", 1);
//		Console.log("Sheet index: [{}], Sheet name: [{}]", reader.getSheetIndex(), reader.getSheetName());
		ExcelUtil.read03BySax("aaa.xls", 1, createRowHandler());
	}
	
	private RowHandler createRowHandler() {
		return new RowHandler() {

			@Override
			public void handle(int sheetIndex, int rowIndex, List<Object> rowlist) {
//				Console.log("[{}] [{}] {}", sheetIndex, rowIndex, rowlist);
				if(5 != rowIndex && 6 != rowIndex) {
					//测试样例中除第五行、第六行都为非空行
					Assert.assertTrue(CollUtil.isNotEmpty(rowlist));
				}
			}
		};
	}
}
