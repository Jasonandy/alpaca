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

import cn.ucaner.alpaca.framework.utils.tools.db.Entity;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.handler   
* @ClassName：EntityHandler   
* @Description：   <p> Entity对象处理器，只处理第一条数据 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:36:25   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class EntityHandler implements RsHandler<Entity>{
	
	/**
	 * 创建一个 SingleEntityHandler对象
	 * @return SingleEntityHandler对象
	 */
	public static EntityHandler create() {
		return new EntityHandler();
	}

	@Override
	public Entity handle(ResultSet rs) throws SQLException {
		final ResultSetMetaData  meta = rs.getMetaData();
		final int columnCount = meta.getColumnCount();
		
		return rs.next() ? HandleHelper.handleRow(columnCount, meta, rs) : null;
	}
}
