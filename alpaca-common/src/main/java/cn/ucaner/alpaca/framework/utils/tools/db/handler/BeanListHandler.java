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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.handler   
* @ClassName：BeanListHandler   
* @Description：   <p> 结果集处理类 ，处理出的结果为Bean列表 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:36:48   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class BeanListHandler<E> implements RsHandler<List<E>> {

	private Class<E> elementBeanType;

	/**
	 * 创建一个 BeanListHandler对象
	 * 
	 * @param <E> 处理对象类型
	 * @param beanType Bean类型
	 * @return BeanListHandler对象
	 */
	public static <E> BeanListHandler<E> create(Class<E> beanType) {
		return new BeanListHandler<E>(beanType);
	}

	/**
	 * 构造
	 * @param beanType Bean类型
	 */
	public BeanListHandler(Class<E> beanType) {
		this.elementBeanType = beanType;
	}

	@Override
	public List<E> handle(ResultSet rs) throws SQLException {
		return HandleHelper.handleRsToBeanList(rs, new ArrayList<E>(), elementBeanType);
	}
}
