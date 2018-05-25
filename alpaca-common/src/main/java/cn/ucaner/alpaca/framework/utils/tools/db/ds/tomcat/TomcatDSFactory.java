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
package cn.ucaner.alpaca.framework.utils.tools.db.ds.tomcat;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import cn.ucaner.alpaca.framework.utils.tools.core.util.CollectionUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;
import cn.ucaner.alpaca.framework.utils.tools.db.DbRuntimeException;
import cn.ucaner.alpaca.framework.utils.tools.db.DbUtil;
import cn.ucaner.alpaca.framework.utils.tools.db.ds.DSFactory;
import cn.ucaner.alpaca.framework.utils.tools.db.ds.simple.SimpleDataSource;
import cn.ucaner.alpaca.framework.utils.tools.setting.Setting;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.ds.tomcat   
* @ClassName：TomcatDSFactory   
* @Description：   <p> Tomcat-Jdbc-Pool数据源工厂类 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:39:13   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class TomcatDSFactory extends DSFactory {
	
	public static final String DS_NAME = "Tomcat-Jdbc-Pool";
	
	/** 数据源池 */
	private Map<String, DataSource> dsMap;
	
	public TomcatDSFactory() {
		this(null);
	}
	
	public TomcatDSFactory(Setting setting) {
		super(DS_NAME, SimpleDataSource.class, setting);
		this.dsMap = new ConcurrentHashMap<>();
	}

	@Override
	synchronized public DataSource getDataSource(String group) {
		if (group == null) {
			group = StrUtil.EMPTY;
		}
		
		// 如果已经存在已有数据源（连接池）直接返回
		final DataSource existedDataSource = dsMap.get(group);
		if (existedDataSource != null) {
			return existedDataSource;
		}

		final DataSource ds = createDataSource(group);
		// 添加到数据源池中，以备下次使用
		dsMap.put(group, ds);
		return ds;
	}

	@Override
	public void close(String group) {
		if (group == null) {
			group = StrUtil.EMPTY;
		}

		DataSource ds = dsMap.get(group);
		if (ds != null) {
			ds.close();
			dsMap.remove(group);
		}
	}

	@Override
	public void destroy() {
		if(CollectionUtil.isNotEmpty(dsMap)){
			Collection<DataSource> values = dsMap.values();
			for (DataSource ds : values) {
				if(null != ds){
					ds.close();
				}
			}
			dsMap.clear();
		}
	}

	/**
	 * 创建数据源
	 * @param group 分组
	 * @return Tomcat数据源 {@link DataSource}
	 */
	private DataSource createDataSource(String group){
		if (group == null) {
			group = StrUtil.EMPTY;
		}
		
		Setting config = setting.getSetting(group);
		if(null == config || config.isEmpty()){
			throw new DbRuntimeException("No Tomcat jdbc pool config for group: [{}]", group);
		}
		
		final PoolProperties poolProps = new PoolProperties();
		
		//基本信息
		poolProps.setUrl(getAndRemoveProperty(config, "url", "jdbcUrl"));
		poolProps.setUsername(getAndRemoveProperty(config, "username", "user"));
		poolProps.setPassword(getAndRemoveProperty(config, "password", "pass"));
		final String driver = getAndRemoveProperty(config, "driver", "driverClassName");
		if(StrUtil.isNotBlank(driver)){
			poolProps.setDriverClassName(driver);
		}else{
			poolProps.setDriverClassName(DbUtil.identifyDriver(poolProps.getUrl()));
		}
		
		//扩展属性
		config.toBean(poolProps);
		
		final DataSource ds = new DataSource(poolProps);
		return ds;
	}
	
	/**
	 * 获得指定KEY对应的值，key1和key2为属性的两个名字，可以互作别名
	 * @param properties 属性
	 * @param key1 属性名
	 * @param key2 备用属性名
	 * @return 值
	 */
	private String getAndRemoveProperty(Setting setting, String key1, String key2){
		String value = (String) setting.remove(key1);
		if(StrUtil.isBlank(value)){
			value = (String) setting.remove(key2);
		}
		return value;
	}
}
