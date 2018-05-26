package cn.ucaner.alpaca.framework.utils.tools.core.text.csv;

import java.io.Serializable;

import cn.ucaner.alpaca.framework.utils.tools.core.util.CharUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.text.csv   
* @ClassName：CsvWriteConfig   
* @Description：   <p> CSV写出配置项 </p>
* @Author： -    
* @CreatTime：2018年5月26日 上午12:06:41   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class CsvWriteConfig extends CsvConfig implements Serializable {
	private static final long serialVersionUID = 5396453565371560052L;

	/** 是否始终使用文本分隔符，文本包装符，默认false，按需添加 */
	protected boolean alwaysDelimitText;
	/** 换行符 */
	protected char[] lineDelimiter = {CharUtil.CR, CharUtil.LF};

	/**
	 * 默认配置
	 * 
	 * @return 默认配置
	 */
	public static CsvWriteConfig defaultConfig() {
		return new CsvWriteConfig();
	}

	/**
	 * 设置是否始终使用文本分隔符，文本包装符，默认false，按需添加
	 * 
	 * @param alwaysDelimitText 是否始终使用文本分隔符，文本包装符，默认false，按需添加
	 */
	public void setAlwaysDelimitText(boolean alwaysDelimitText) {
		this.alwaysDelimitText = alwaysDelimitText;
	}
	
	/**
	 * 设置换行符
	 * 
	 * @param lineDelimiter 换行符
	 */
	public void setLineDelimiter(char[] lineDelimiter) {
		this.lineDelimiter = lineDelimiter;
	}
}
