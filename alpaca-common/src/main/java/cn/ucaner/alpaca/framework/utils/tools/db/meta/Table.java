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
package cn.ucaner.alpaca.framework.utils.tools.db.meta;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.meta   
* @ClassName：Table   
* @Description：   <p> 数据库表信息 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:33:47   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class Table extends HashMap<String, Column>{
	private static final long serialVersionUID = -810699625961392983L;

	/** 表名 */
	private String tableName;
	/** 主键字段名列表 */
	private Set<String> pkNames = new LinkedHashSet<String>();
	
	public static Table create(String tableName) {
		return new Table(tableName);
	}

	// ----------------------------------------------------- Constructor start
	/**
	 * 构造
	 * 
	 * @param tableName 表名
	 */
	public Table(String tableName) {
		this.setTableName(tableName);
	}
	//----------------------------------------------------- Constructor end

	// ----------------------------------------------------- Getters and Setters start
	/**
	 * 获取表名
	 * 
	 * @return 表名
	 */
	public String getTableName() {
		return tableName;
	}
	/**
	 * 设置表名
	 * 
	 * @param tableName 表名
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * 获取主键列表
	 * @return 主键列表
	 */
	public Set<String> getPkNames() {
		return pkNames;
	}

	/**
	 * 设置主键列表
	 * @param pkNames 主键列表
	 */
	public void setPkNames(Set<String> pkNames) {
		this.pkNames = pkNames;
	}
	// ----------------------------------------------------- Getters and Setters end

	/**
	 * 设置列对象
	 * @param column 列对象
	 * @return 自己
	 */
	public Table setColumn(Column column) {
		put(column.getName(), column);
		return this;
	}
	
	/**
	 * 添加主键
	 * @param pkColumnName 主键的列名
	 * @return 自己
	 */
	public Table addPk(String pkColumnName) {
		this.pkNames.add(pkColumnName);
		return this;
	}
}
