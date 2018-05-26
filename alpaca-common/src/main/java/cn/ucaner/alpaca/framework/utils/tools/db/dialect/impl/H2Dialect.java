package cn.ucaner.alpaca.framework.utils.tools.db.dialect.impl;

import cn.ucaner.alpaca.framework.utils.tools.db.Page;
import cn.ucaner.alpaca.framework.utils.tools.db.dialect.DialectName;
import cn.ucaner.alpaca.framework.utils.tools.db.sql.SqlBuilder;
import cn.ucaner.alpaca.framework.utils.tools.db.sql.Wrapper;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.dialect.impl   
* @ClassName：H2Dialect   
* @Description：   <p> H2Dialect 方言</p>
* @Author： -    
* @CreatTime：2018年5月26日 下午4:25:55   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class H2Dialect extends AnsiSqlDialect{
	public H2Dialect() {
		wrapper = new Wrapper('"', '"');
	}
	
	@Override
	public DialectName dialectName() {
		return DialectName.H2;
	}
	
	@Override
	protected SqlBuilder wrapPageSql(SqlBuilder find, Page page) {
		//limit  A , B 表示：A就是查询的起点位置，B就是你需要多少行。
		return find.append(" limit ").append(page.getStartPosition()).append(" , ").append(page.getPageSize());
	}
}
