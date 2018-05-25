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

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;
import cn.ucaner.alpaca.framework.utils.tools.db.DbRuntimeException;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.meta   
* @ClassName：Column   
* @Description：   <p> 数据库表的列信息 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:33:28   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class Column implements Cloneable{
	
	//----------------------------------------------------- Fields start
	private String tableName;		//表名
	
	private String name;				//列名
	private int type;						//类型，对应java.sql.Types中的类型
	private int size;						//大小
	private boolean isNullable;		//是否为可空
	//----------------------------------------------------- Fields end
	
	/**
	 * 创建列对象
	 * @param tableName 表名
	 * @param columnMetaRs 列元信息的ResultSet
	 * @return 列对象
	 */
	public static Column create(String tableName, ResultSet columnMetaRs) {
		return new Column(tableName, columnMetaRs);
	}
	
	//----------------------------------------------------- Constructor start
	public Column() {
	}
	
	public Column(String tableName, ResultSet columnMetaRs) {
		try {
			init(tableName, columnMetaRs);
		} catch (SQLException e) {
			throw new DbRuntimeException(StrUtil.format("Get table [{}] meta info error!", tableName));
		}
	}
	//----------------------------------------------------- Constructor end
	
	/**
	 * 初始化
	 * @param tableName 表名
	 * @param columnMetaRs 列的meta ResultSet
	 * @throws SQLException SQL执行异常
	 */
	public  void init(String tableName, ResultSet columnMetaRs) throws SQLException {
		this.tableName = tableName;
		
		this.name = columnMetaRs.getString("COLUMN_NAME");
		this.type = columnMetaRs.getInt("DATA_TYPE");
		this.size = columnMetaRs.getInt("COLUMN_SIZE");
		this.isNullable = columnMetaRs.getBoolean("NULLABLE");
	}
	
	//----------------------------------------------------- Getters and Setters start
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public boolean isNullable() {
		return isNullable;
	}
	public void setNullable(boolean isNullable) {
		this.isNullable = isNullable;
	}
	//----------------------------------------------------- Getters and Setters end

	@Override
	public String toString() {
		return "Column [tableName=" + tableName + ", name=" + name + ", type=" + type + ", size=" + size + ", isNullable=" + isNullable + "]";
	}
}
