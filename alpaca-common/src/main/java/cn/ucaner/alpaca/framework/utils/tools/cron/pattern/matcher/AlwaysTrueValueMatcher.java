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
package cn.ucaner.alpaca.framework.utils.tools.cron.pattern.matcher;

import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.cron.pattern.matcher   
* @ClassName：AlwaysTrueValueMatcher   
* @Description：   <p> 值匹配，始终返回<code>true</code></p>
* @Author： -    
* @CreatTime：2018年5月25日 上午11:43:29   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class AlwaysTrueValueMatcher implements ValueMatcher{

	@Override
	public boolean match(Integer t) {
		return true;
	}
	
	@Override
	public String toString() {
		return StrUtil.format("[Matcher]: always true.");
	}
}
