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

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.handler   
* @ClassName：NumberHandler   
* @Description：   <p> 处理为数字结果，当查询结果为单个数字时使用此处理器（例如select count(1)） </p>
* @Author： - wubin   
* @CreatTime：2018年5月25日 下午2:37:27   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class NumberHandler implements RsHandler<Number>{
	
	/**
	 * 创建一个 NumberHandler对象
	 * @return NumberHandler对象
	 */
	public static NumberHandler create() {
		return new NumberHandler();
	}

	@Override
	public Number handle(ResultSet rs) throws SQLException {
		return rs.next() ? rs.getBigDecimal(1) : null;
	}
}
