package cn.ucaner.alpaca.common.plugin;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import cn.ucaner.alpaca.common.util.AESUtil;

/**
* @Package：cn.ucaner.alpaca.common.plugin   
* @ClassName：EncryptPropertyPlaceholderConfigurer   
* @Description：   <p> 支持加密配置文件插件 </p>
* @Author： -    
* @CreatTime：2018年5月24日 下午2:31:18   
* @Modify By：   
* @ModifyTime：  2018年5月24日
* @Modify marker：   
* @version    V1.0
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	/**
	 * 需要加密的propertyNames[]
	 */
	private String[] propertyNames = {
		"master.jdbc.password", 
		"slave.jdbc.password",
		"generator.jdbc.password",
		"master.redis.password"
	};

	/**
	 * 解密指定propertyName的加密属性值
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 */
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		for (String p : propertyNames) {
			if (p.equalsIgnoreCase(propertyName)) {
				return AESUtil.aesDecode(propertyValue);
			}
		}
		return super.convertProperty(propertyName, propertyValue);
	}

}
