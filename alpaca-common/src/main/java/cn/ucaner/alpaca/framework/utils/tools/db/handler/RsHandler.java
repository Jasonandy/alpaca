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
* @ClassName：RsHandler   
* @Description：   <p> 结果集处理接口</p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:34:40   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface RsHandler<T> {
	
	/**
	 * 处理结果集<br>
	 * 结果集处理后不需要关闭
	 * @param rs 结果集
	 * @return 处理后生成的对象
	 * @throws SQLException SQL异常
	 */
	public T handle(ResultSet rs) throws SQLException;
}
