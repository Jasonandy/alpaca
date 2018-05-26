package cn.ucaner.alpaca.framework.utils.tools.poi.excel.cell;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.poi.excel.cell   
* @ClassName：CellValue   
* @Description：   <p> 抽象的单元格值接口，用于判断不同类型的单元格值   <T> 值类型</p>
* @Author： -    
* @CreatTime：2018年5月26日 下午2:37:15   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public interface CellValue<T> {
	/**
	 * 获取单元格值
	 * 
	 * @return 值
	 */
	T getValue();
}
