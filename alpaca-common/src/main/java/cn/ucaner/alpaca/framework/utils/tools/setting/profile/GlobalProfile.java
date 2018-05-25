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
package cn.ucaner.alpaca.framework.utils.tools.setting.profile;

import cn.ucaner.alpaca.framework.utils.tools.core.lang.Singleton;
import cn.ucaner.alpaca.framework.utils.tools.setting.Setting;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.setting.profile   
* @ClassName：GlobalProfile   
* @Description：   <p> 全局的Profile配置中心 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:14:27   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class GlobalProfile {

	private GlobalProfile() {
	}

	// -------------------------------------------------------------------------------- Static method start
	/**
	 * 设置全局环境
	 * @param profile 环境
	 * @return {@link Profile}
	 */
	public static Profile setProfile(String profile) {
		return Singleton.get(Profile.class, profile);
	}

	/**
	 * 获得全局的当前环境下对应的配置文件
	 * @param settingName 配置文件名，可以忽略默认后者（.setting）
	 * @return {@link Setting}
	 */
	public static Setting getSetting(String settingName) {
		return Singleton.get(Profile.class).getSetting(settingName);
	}
	// -------------------------------------------------------------------------------- Static method end
}
