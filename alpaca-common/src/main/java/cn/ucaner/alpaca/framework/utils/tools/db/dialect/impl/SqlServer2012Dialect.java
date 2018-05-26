package cn.ucaner.alpaca.framework.utils.tools.db.dialect.impl;

import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;
import cn.ucaner.alpaca.framework.utils.tools.db.Page;
import cn.ucaner.alpaca.framework.utils.tools.db.dialect.DialectName;
import cn.ucaner.alpaca.framework.utils.tools.db.sql.SqlBuilder;
import cn.ucaner.alpaca.framework.utils.tools.db.sql.Wrapper;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.dialect.impl   
* @ClassName：SqlServer2012Dialect   
* @Description：   <p>  SQLServer2012 方言 </p>
* @Author： -    
* @CreatTime：2018年5月26日 下午4:26:33   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class SqlServer2012Dialect extends AnsiSqlDialect {

	public SqlServer2012Dialect() {
		//双引号和中括号适用，双引号更广泛
		 wrapper = new Wrapper('"');
	}

	@Override
	protected SqlBuilder wrapPageSql(SqlBuilder find, Page page) {
		if (false == StrUtil.containsIgnoreCase(find.toString(), "order by")) {
			//offset 分页必须要跟在order by后面，没有情况下补充默认排序
			find.append(" order by current_timestamp");
		}
		return find.append(" offset ")
				.append(page.getStartPosition())//
				.append(" row fetch next ")//row和rows同义词
				.append(page.getPageSize())//
				.append(" row only");//
	}

	@Override
	public DialectName dialectName() {
		return DialectName.SQLSERVER2012;
	}
}
