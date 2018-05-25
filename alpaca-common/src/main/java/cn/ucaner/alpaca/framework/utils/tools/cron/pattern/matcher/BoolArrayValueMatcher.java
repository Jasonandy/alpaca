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

import java.util.Collections;
import java.util.List;

import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.cron.pattern.matcher   
* @ClassName：BoolArrayValueMatcher   
* @Description：   <p>  将表达式中的数字值列表转换为Boolean数组，匹配时匹配相应数组位 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午11:43:46   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class BoolArrayValueMatcher implements ValueMatcher{
	
	boolean[] bValues;
	
	public BoolArrayValueMatcher(List<Integer> intValueList) {
		bValues = new boolean[Collections.max(intValueList) + 1];
		for (Integer value : intValueList) {
			bValues[value] = true;
		}
	}

	@Override
	public boolean match(Integer value) {
		if(null == value || value >= bValues.length){
			return false;
		}
		return bValues[value];
	}
	
	@Override
	public String toString() {
		return StrUtil.format("Matcher:{}", (Object)this.bValues);
	}
}
