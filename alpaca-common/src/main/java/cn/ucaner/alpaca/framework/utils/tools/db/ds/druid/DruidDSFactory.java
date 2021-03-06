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
package cn.ucaner.alpaca.framework.utils.tools.db.ds.druid;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;

import cn.ucaner.alpaca.framework.utils.tools.core.collection.CollectionUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.convert.Convert;
import cn.ucaner.alpaca.framework.utils.tools.core.io.IoUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;
import cn.ucaner.alpaca.framework.utils.tools.db.DbRuntimeException;
import cn.ucaner.alpaca.framework.utils.tools.db.DbUtil;
import cn.ucaner.alpaca.framework.utils.tools.db.ds.DSFactory;
import cn.ucaner.alpaca.framework.utils.tools.setting.Setting;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.ds.druid   
* @ClassName：DruidDSFactory   
* @Description：   <p>  Druid数据源工厂类 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:40:41   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class DruidDSFactory extends DSFactory {
	
	public static final String DS_NAME = "Druid";
	
	/** 数据源池 */
	private Map<String, DruidDataSource> dsMap;
	
	public DruidDSFactory() {
		this(null);
	}
	
	public DruidDSFactory(Setting setting) {
		super(DS_NAME, DruidDataSource.class, setting);
		this.dsMap = new ConcurrentHashMap<>();
	}

	@Override
	synchronized public DataSource getDataSource(String group) {
		if (group == null) {
			group = StrUtil.EMPTY;
		}
		
		// 如果已经存在已有数据源（连接池）直接返回
		final DruidDataSource existedDataSource = dsMap.get(group);
		if (existedDataSource != null) {
			return existedDataSource;
		}

		DruidDataSource ds = createDataSource(group);
		// 添加到数据源池中，以备下次使用
		dsMap.put(group, ds);
		return ds;
	}

	@Override
	public void close(String group) {
		if (group == null) {
			group = StrUtil.EMPTY;
		}

		DruidDataSource dds = dsMap.get(group);
		if (dds != null) {
			IoUtil.close(dds);
			dsMap.remove(group);
		}
	}

	@Override
	public void destroy() {
		if(CollectionUtil.isNotEmpty(dsMap)){
			Collection<DruidDataSource> values = dsMap.values();
			for (DruidDataSource dds : values) {
				IoUtil.close(dds);
			}
			dsMap.clear();
		}
	}

	/**
	 * 创建数据源
	 * @param group 分组
	 * @return Druid数据源 {@link DruidDataSource}
	 */
	private DruidDataSource createDataSource(String group){
		final Setting config = setting.getSetting(group);
		if(CollectionUtil.isEmpty(config)){
			throw new DbRuntimeException("No Druid config for group: [{}]", group);
		}

		// 初始化SQL显示
		final boolean isShowSql = Convert.toBool(config.remove("showSql"), false);
		final boolean isFormatSql = Convert.toBool(config.remove("formatSql"), false);
		final boolean isShowParams = Convert.toBool(config.remove("showParams"), false);
		DbUtil.setShowSqlGlobal(isShowSql, isFormatSql, isShowParams);

		final DruidDataSource ds = new DruidDataSource();
		
		//基本信息
		final String url = config.getAndRemoveStr(KEY_ALIAS_URL);
		if(StrUtil.isBlank(url)) {
			throw new DbRuntimeException("No JDBC URL for group: [{}]", group);
		}
		ds.setUrl(url);
		ds.setUsername(config.getAndRemoveStr(KEY_ALIAS_USER));
		ds.setPassword(config.getAndRemoveStr(KEY_ALIAS_PASSWORD));
		final String driver = config.getAndRemoveStr(KEY_ALIAS_DRIVER);
		//在未提供JDBC驱动的情况下，Druid会自动识别驱动
		if(StrUtil.isNotBlank(driver)){
			ds.setDriverClassName(driver);
		}
		
		//规范化属性名
		Properties config2 = new Properties();
		String keyStr;
		for (Entry<String, String> entry : config.entrySet()) {
			keyStr = StrUtil.addPrefixIfNot(entry.getKey(), "druid.");
			config2.put(keyStr, entry.getValue());
		}
		
		//连接池信息
		ds.configFromPropety(config2);
		
		//检查关联配置，在用户未设置某项配置时，
		if(null == ds.getValidationQuery()){
			//在validationQuery未设置的情况下，以下三项设置都将无效
			ds.setTestOnBorrow(false);
			ds.setTestOnReturn(false);
			ds.setTestWhileIdle(false);
		}
		
		return ds;
	}
}
