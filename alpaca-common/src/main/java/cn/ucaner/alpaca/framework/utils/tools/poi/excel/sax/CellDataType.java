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
package cn.ucaner.alpaca.framework.utils.tools.poi.excel.sax;

/**
* @Package：cn.ucaner.tools.poi.excel.sax   
* @ClassName：CellDataType   
* @Description：   <p> 单元格数据类型枚举</p>
* @Author： -  
* @CreatTime：2017-11-3 上午11:55:21   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public enum CellDataType {
	/** Boolean类型 */
	BOOL("b"),
	/** 类型错误 */
	ERROR("e"),
	/** 计算结果类型 */
	FORMULA("str"),
	/** 富文本类型 */
	INLINESTR("inlineStr"),
	/** 字符串类型 */
	SSTINDEX("s"),
	/** 数字类型 */
	NUMBER(""),
	/** 日期类型 */
	DATE("m/d/yy"),
	/** 空类型 */
	NULL("");

	/** 属性值 */
	private String name;

	/**
	 * 构造
	 * 
	 * @param name 类型属性值
	 */
	private CellDataType(String name) {
		this.name = name;
	}

	/**
	 * 获取对应类型的属性值
	 * 
	 * @return 属性值
	 */
	public String getName() {
		return name;
	}

	/**
	 * 类型字符串转为枚举
	 * @param name 类型字符串
	 * @return 类型枚举
	 */
	public static CellDataType of(String name) {
		if(null == name) {
			//默认数字
			return NUMBER;
		}
		
		if(BOOL.name.equals(name)) {
			return BOOL;
		}else if(ERROR.name.equals(name)) {
			return ERROR;
		}else if(INLINESTR.name.equals(name)) {
			return INLINESTR;
		}else if(SSTINDEX.name.equals(name)) {
			return SSTINDEX;
		}else if(FORMULA.name.equals(name)) {
			return FORMULA;
		}else {
			return NULL;
		}
	}
}
