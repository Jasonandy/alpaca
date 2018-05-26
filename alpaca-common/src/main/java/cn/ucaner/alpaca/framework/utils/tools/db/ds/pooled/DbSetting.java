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
package cn.ucaner.alpaca.framework.utils.tools.db.ds.pooled;

import cn.ucaner.alpaca.framework.utils.tools.core.collection.CollectionUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.convert.Convert;
import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;
import cn.ucaner.alpaca.framework.utils.tools.db.DbRuntimeException;
import cn.ucaner.alpaca.framework.utils.tools.db.DbUtil;
import cn.ucaner.alpaca.framework.utils.tools.db.dialect.DriverUtil;
import cn.ucaner.alpaca.framework.utils.tools.db.ds.DSFactory;
import cn.ucaner.alpaca.framework.utils.tools.setting.Setting;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.ds.pooled   
* @ClassName：DbSetting   
* @Description：   <p> 数据库配置文件类，此类对应一个数据库配置文件 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:46:30   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class DbSetting {
	/** 默认的数据库连接配置文件路径 */
	public final static String DEFAULT_DB_CONFIG_PATH = "config/db.setting";

	private Setting setting;

	/**
	 * 构造
	 */
	public DbSetting() {
		this(null);
	}

	/**
	 * 构造
	 * 
	 * @param setting 数据库配置
	 */
	public DbSetting(Setting setting) {
		if (null == setting) {
			this.setting = new Setting(DEFAULT_DB_CONFIG_PATH);
		} else {
			this.setting = setting;
		}
	}

	/**
	 * 获得数据库连接信息
	 * 
	 * @param group 分组
	 * @return 分组
	 */
	public DbConfig getDbConfig(String group) {
		final Setting config = setting.getSetting(group);
		if (CollectionUtil.isEmpty(config)) {
			throw new DbRuntimeException("No Hutool pool config for group: [{}]", group);
		}

		// 初始化SQL显示
		final boolean isShowSql = Convert.toBool(config.remove("showSql"), false);
		final boolean isFormatSql = Convert.toBool(config.remove("formatSql"), false);
		final boolean isShowParams = Convert.toBool(config.remove("showParams"), false);
		DbUtil.setShowSqlGlobal(isShowSql, isFormatSql, isShowParams);

		final DbConfig dbConfig = new DbConfig();

		// 基本信息
		final String url = config.getAndRemoveStr(DSFactory.KEY_ALIAS_URL);
		if (StrUtil.isBlank(url)) {
			throw new DbRuntimeException("No JDBC URL for group: [{}]", group);
		}
		dbConfig.setUrl(url);
		dbConfig.setUser(config.getAndRemoveStr(DSFactory.KEY_ALIAS_USER));
		dbConfig.setPass(config.getAndRemoveStr(DSFactory.KEY_ALIAS_PASSWORD));
		final String driver = config.getAndRemoveStr(DSFactory.KEY_ALIAS_DRIVER);
		if (StrUtil.isNotBlank(driver)) {
			dbConfig.setDriver(driver);
		} else {
			dbConfig.setDriver(DriverUtil.identifyDriver(url));
		}

		// 连接池相关信息
		dbConfig.setInitialSize(setting.getInt("initialSize", group, 0));
		dbConfig.setMinIdle(setting.getInt("minIdle", group, 0));
		dbConfig.setMaxActive(setting.getInt("maxActive", group, 8));
		dbConfig.setMaxWait(setting.getLong("maxWait", group, 6000L));

		return dbConfig;
	}
}
