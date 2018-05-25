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
package cn.ucaner.alpaca.framework.utils.tools.db.ds.hikari;

import java.util.Collection;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import cn.ucaner.alpaca.framework.utils.tools.core.io.IoUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.CollectionUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;
import cn.ucaner.alpaca.framework.utils.tools.db.DbRuntimeException;
import cn.ucaner.alpaca.framework.utils.tools.db.ds.DSFactory;
import cn.ucaner.alpaca.framework.utils.tools.setting.Setting;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.ds.hikari   
* @ClassName：HikariDSFactory   
* @Description：   <p> HikariCP数据源工厂类 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:38:47   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class HikariDSFactory extends DSFactory {
	
	public static final String DS_NAME = "HikariCP";
	
	/** 数据源池 */
	private Map<String, HikariDataSource> dsMap;
	
	public HikariDSFactory() {
		this(null);
	}
	
	public HikariDSFactory(Setting setting) {
		super(DS_NAME, HikariDataSource.class, setting);
		this.dsMap = new ConcurrentHashMap<>();
	}

	@Override
	synchronized public DataSource getDataSource(String group) {
		if (group == null) {
			group = StrUtil.EMPTY;
		}
		
		// 如果已经存在已有数据源（连接池）直接返回
		final HikariDataSource existedDataSource = dsMap.get(group);
		if (existedDataSource != null) {
			return existedDataSource;
		}

		final HikariDataSource ds = createDataSource(group);
		// 添加到数据源池中，以备下次使用
		dsMap.put(group, ds);
		return ds;
	}

	@Override
	public void close(String group) {
		if (group == null) {
			group = StrUtil.EMPTY;
		}

		HikariDataSource ds = dsMap.get(group);
		if (ds != null) {
			IoUtil.close(ds);
			dsMap.remove(group);
		}
	}

	@Override
	public void destroy() {
		if(CollectionUtil.isNotEmpty(dsMap)){
			Collection<HikariDataSource> values = dsMap.values();
			for (HikariDataSource ds : values) {
				IoUtil.close(ds);
			}
			dsMap.clear();
		}
	}

	/**
	 * 创建数据源
	 * @param group 分组
	 * @return Hikari数据源 {@link HikariDataSource}
	 */
	private HikariDataSource createDataSource(String group){
		if (group == null) {
			group = StrUtil.EMPTY;
		}
		
		final Properties config = setting.getProperties(group);
		if(CollectionUtil.isEmpty(config)){
			throw new DbRuntimeException("No HikariCP config for group: [{}]", group);
		}
		
		//规范化属性名
		if(false == config.containsKey("jdbcUrl") && config.containsKey("url")){
			config.put("jdbcUrl", config.remove("url"));
		}
		if(false == config.containsKey("username") && config.containsKey("user")){
			config.put("username", config.remove("user"));
		}
		if(false == config.containsKey("password") && config.containsKey("pass")){
			config.put("password", config.remove("pass"));
		}
		if(false == config.containsKey("driverClassName") && config.containsKey("driver")){
			config.put("driverClassName", config.remove("driver"));
		}
		
		final HikariDataSource ds = new HikariDataSource(new HikariConfig(config));
		return ds;
	}
}
