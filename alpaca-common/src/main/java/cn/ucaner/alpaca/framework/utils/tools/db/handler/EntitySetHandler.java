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
import java.util.LinkedHashSet;

import cn.ucaner.alpaca.framework.utils.tools.db.Entity;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.handler   
* @ClassName：EntitySetHandler   
* @Description：   <p> 结果集处理类 ，处理出的结果为Entity列表，结果不能重复（按照Entity对象去重） </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:35:51   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class EntitySetHandler implements RsHandler<LinkedHashSet<Entity>>{
	
	/**
	 * 创建一个 EntityHandler对象
	 * @return EntityHandler对象
	 */
	public static EntitySetHandler create() {
		return new EntitySetHandler();
	}

	@Override
	public LinkedHashSet<Entity> handle(ResultSet rs) throws SQLException {
		return HandleHelper.handleRs(rs, new LinkedHashSet<Entity>());
	}
}
