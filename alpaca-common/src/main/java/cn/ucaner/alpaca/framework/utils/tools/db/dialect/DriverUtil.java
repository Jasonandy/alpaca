package cn.ucaner.alpaca.framework.utils.tools.db.dialect;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;
import cn.ucaner.alpaca.framework.utils.tools.db.DbRuntimeException;
import cn.ucaner.alpaca.framework.utils.tools.db.DbUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.dialect   
* @ClassName：DriverUtil   
* @Description：   <p> 驱动相关工具类，包括自动获取驱动类名 </p>
* @Author： -    
* @CreatTime：2018年5月26日 下午4:27:21   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class DriverUtil {
	/**
	 * 通过JDBC URL等信息识别JDBC驱动名
	 * 
	 * @param nameContainsProductInfo 包含数据库标识的字符串
	 * @return 驱动
	 * @see DialectFactory#identifyDriver(String)
	 */
	public static String identifyDriver(String nameContainsProductInfo) {
		return DialectFactory.identifyDriver(nameContainsProductInfo);
	}

	/**
	 * 识别JDBC驱动名
	 * 
	 * @param ds 数据源
	 * @return 驱动
	 */
	public static String identifyDriver(DataSource ds) {
		Connection conn = null;
		String driver = null;
		try {
			try {
				conn = ds.getConnection();
			} catch (SQLException e) {
				throw new DbRuntimeException("Get Connection error !", e);
			} catch (NullPointerException e) {
				throw new DbRuntimeException("Unexpected NullPointException, maybe [jdbcUrl] or [url] is empty!", e);
			}
			driver = identifyDriver(conn);
		} finally {
			DbUtil.close(conn);
		}

		return driver;
	}

	/**
	 * 识别JDBC驱动名
	 * 
	 * @param conn 数据库连接对象
	 * @return 驱动
	 * @throws DbRuntimeException SQL异常包装，获取元数据信息失败
	 */
	public static String identifyDriver(Connection conn) throws DbRuntimeException {
		String driver = null;
		try {
			DatabaseMetaData meta = conn.getMetaData();
			driver = identifyDriver(meta.getDatabaseProductName());
			if (StrUtil.isBlank(driver)) {
				driver = identifyDriver(meta.getDriverName());
			}
		} catch (SQLException e) {
			throw new DbRuntimeException("Identify driver error!", e);
		}

		return driver;
	}
}
