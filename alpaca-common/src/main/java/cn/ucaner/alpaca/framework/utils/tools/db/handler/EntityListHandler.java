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

import cn.ucaner.alpaca.framework.utils.tools.db.Entity;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.handler   
* @ClassName：EntityListHandler   
* @Description：   <p> 结果集处理类 ，处理出的结果为Entity列表 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:36:11   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class EntityListHandler implements RsHandler<List<Entity>>{
	
	/**
	 * 创建一个 EntityListHandler对象
	 * @return EntityListHandler对象
	 */
	public static EntityListHandler create() {
		return new EntityListHandler();
	}

	@Override
	public List<Entity> handle(ResultSet rs) throws SQLException {
		return HandleHelper.handleRs(rs, new ArrayList<Entity>());
	}
}
