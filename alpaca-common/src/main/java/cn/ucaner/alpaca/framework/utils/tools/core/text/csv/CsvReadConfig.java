package cn.ucaner.alpaca.framework.utils.tools.core.text.csv;

import java.io.Serializable;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.text.csv   
* @ClassName：CsvReadConfig   
* @Description：   <p>  CSV读取配置项 </p>
* @Author： -    
* @CreatTime：2018年5月26日 上午12:08:34   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class CsvReadConfig extends CsvConfig implements Serializable {
	private static final long serialVersionUID = 5396453565371560052L;

	/** 是否首行做为标题行，默认false */
	protected boolean containsHeader;
	/** 是否跳过空白行，默认true */
	protected boolean skipEmptyRows = true;
	/** 每行字段个数不同时是否抛出异常，默认false */
	protected boolean errorOnDifferentFieldCount;

	/**
	 * 默认配置
	 * 
	 * @return 默认配置
	 */
	public static CsvReadConfig defaultConfig() {
		return new CsvReadConfig();
	}

	/**
	 * 设置是否首行做为标题行，默认false
	 * 
	 * @param containsHeader 是否首行做为标题行，默认false
	 */
	public void setContainsHeader(boolean containsHeader) {
		this.containsHeader = containsHeader;
	}

	/**
	 * 设置是否跳过空白行，默认true
	 * 
	 * @param skipEmptyRows 是否跳过空白行，默认true
	 */
	public void setSkipEmptyRows(boolean skipEmptyRows) {
		this.skipEmptyRows = skipEmptyRows;
	}

	/**
	 * 设置每行字段个数不同时是否抛出异常，默认false
	 * 
	 * @param errorOnDifferentFieldCount 每行字段个数不同时是否抛出异常，默认false
	 */
	public void setErrorOnDifferentFieldCount(boolean errorOnDifferentFieldCount) {
		this.errorOnDifferentFieldCount = errorOnDifferentFieldCount;
	}
}
