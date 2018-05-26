package cn.ucaner.alpaca.framework.utils.tools.db.handler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.handler   
* @ClassName：StringHandler   
* @Description：   <p> 处理为字符串结果，当查询结果为单个字符串时使用此处理器 </p>
* @Author： -    
* @CreatTime：2018年5月26日 下午4:30:28   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class StringHandler implements RsHandler<String>{
	
	/**
	 * 创建一个 NumberHandler对象
	 * @return NumberHandler对象
	 */
	public static StringHandler create() {
		return new StringHandler();
	}

	@Override
	public String handle(ResultSet rs) throws SQLException {
		return rs.next() ? rs.getString(1) : null;
	}
}
