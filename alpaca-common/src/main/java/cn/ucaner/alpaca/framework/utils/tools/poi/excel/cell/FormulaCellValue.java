package cn.ucaner.alpaca.framework.utils.tools.poi.excel.cell;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.poi.excel.cell   
* @ClassName：FormulaCellValue   
* @Description：   <p> 公式类型的值 </p>
* @Author： -    
* @CreatTime：2018年5月26日 下午2:37:41   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class FormulaCellValue implements CellValue<String> {

	/** 公式 */
	String formula;

	public FormulaCellValue(String formula) {
		this.formula = formula;
	}

	@Override
	public String getValue() {
		return this.formula;
	}

}
