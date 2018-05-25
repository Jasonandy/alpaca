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
package cn.ucaner.alpaca.framework.utils.tools.db.ds.jndi;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;
import cn.ucaner.alpaca.framework.utils.tools.db.DbRuntimeException;
import cn.ucaner.alpaca.framework.utils.tools.db.DbUtil;
import cn.ucaner.alpaca.framework.utils.tools.db.ds.DSFactory;
import cn.ucaner.alpaca.framework.utils.tools.setting.Setting;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.ds.jndi   
* @ClassName：JndiDSFactory   
* @Description：   <p> JNDI数据源工厂类 </p>
* Setting配置样例：<br>
 * ---------------------<br>
 * [group]<br>
 * jndi = jdbc/TestDB<br>
 * ---------------------<br>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:41:46   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class JndiDSFactory extends DSFactory {
	
	public static final String DS_NAME = "JNDI DataSource";
	
	private Setting setting;
	/** 数据源池 */
	private Map<String, DataSource> dsMap;
	
	public JndiDSFactory() {
		this(null);
	}
	
	public JndiDSFactory(Setting setting) {
		super(DS_NAME, null, setting);
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
		//JNDI Datasource not support close method
	}

	@Override
	public void destroy() {
		//JNDI Datasource not support destroy method
	}

	/**
	 * 创建数据源
	 * @param group JNDI名
	 * @return 数据源 {@link DataSource}
	 */
	private DataSource createDataSource(String group){
		if (group == null) {
			group = StrUtil.EMPTY;
		}
		
		String jndiName = setting.getByGroup("jndi", group);
		if(StrUtil.isEmpty(jndiName)){
			throw new DbRuntimeException("No setting name [jndi] for group [{}]", group);
		}
		DataSource ds = DbUtil.getJndiDs(jndiName);
		
		return ds;
	}
}
