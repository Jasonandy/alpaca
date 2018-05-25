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

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.handler   
* @ClassName：BeanHandler   
* @Description：   <p> Bean对象处理器，只处理第一条数据 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:37:03   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class BeanHandler<E> implements RsHandler<E>{
	
	private Class<E> elementBeanType;
	
	/**
	 * 创建一个 BeanHandler对象
	 * 
	 * @param <E> 处理对象类型
	 * @param beanType Bean类型
	 * @return BeanHandler对象
	 */
	public static <E> BeanHandler<E> create(Class<E> beanType) {
		return new BeanHandler<E>(beanType);
	}

	public BeanHandler(Class<E> beanType) {
		this.elementBeanType = beanType;
	}

	@Override
	public E handle(ResultSet rs) throws SQLException {
		final ResultSetMetaData  meta = rs.getMetaData();
		final int columnCount = meta.getColumnCount();
		
		return rs.next() ? HandleHelper.handleRow(columnCount, meta, rs).toBean(elementBeanType) : null;
	}
}
