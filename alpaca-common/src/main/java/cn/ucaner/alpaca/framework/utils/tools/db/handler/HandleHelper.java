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
package cn.ucaner.alpaca.framework.utils.tools.db.handler;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Collection;

import cn.ucaner.alpaca.framework.utils.tools.db.Entity;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.handler   
* @ClassName：HandleHelper   
* @Description：   <p> 数据结果集处理辅助类 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:35:33   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class HandleHelper {
	
	/**
	 * 处理单条数据
	 * @param columnCount 列数
	 * @param meta ResultSetMetaData
	 * @param rs 数据集
	 * @return 每一行的Entity
	 * @throws SQLException SQL执行异常
	 */
	public static Entity handleRow(int columnCount, ResultSetMetaData meta, ResultSet rs) throws SQLException {
		final Entity row = Entity.create(meta.getTableName(1));
		String columnLabel;
		for (int i = 1; i <= columnCount; i++) {
			columnLabel = meta.getColumnLabel(i);
			row.put(columnLabel, rs.getObject(columnLabel));
		}
		return row;
	}
	
	
	/**
	 * 处理单条数据
	 * @param rs 数据集
	 * @return 每一行的Entity
	 * @throws SQLException SQL执行异常
	 */
	public static Entity handleRow(ResultSet rs) throws SQLException {
		final ResultSetMetaData meta = rs.getMetaData();
		final int columnCount = meta.getColumnCount();
		return handleRow(columnCount, meta, rs);
	}
	
	/**
	 * 处理多条数据
	 * @param <T> 集合类型
	 * @param rs 数据集
	 * @param collection 数据集
	 * @return Entity列表
	 * @throws SQLException SQL执行异常
	 */
	public static <T extends Collection<Entity>> T handleRs(ResultSet rs, T collection) throws SQLException {
		final ResultSetMetaData  meta = rs.getMetaData();
		final int columnCount = meta.getColumnCount();
		
		while(rs.next()) {
			collection.add(HandleHelper.handleRow(columnCount, meta, rs));
		}
		
		return collection;
	}
	
	/**
	 * 处理多条数据并返回一个Bean列表
	 * 
	 * @param <E> 集合元素类型
	 * @param <T> 集合类型
	 * @param rs 数据集
	 * @param collection 数据集
	 * @param elementBeanType Bean类型
	 * @return Entity列表
	 * @throws SQLException SQL执行异常
	 * @since 3.1.0
	 */
	public static <E, T extends Collection<E>> T handleRsToBeanList(ResultSet rs, T collection, Class<E> elementBeanType) throws SQLException {
		final ResultSetMetaData  meta = rs.getMetaData();
		final int columnCount = meta.getColumnCount();
		
		while(rs.next()) {
			collection.add(HandleHelper.handleRow(columnCount, meta, rs).toBean(elementBeanType));
		}
		
		return collection;
	}
}
