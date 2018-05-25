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

import java.util.List;


/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.cron.pattern.matcher   
* @ClassName：YearValueMatcher   
* @Description：   <p> 年匹配 </p>
* <br> 考虑年数字太大，不适合boolean数组，单独使用列表遍历匹配  
* @Author： - 
* @CreatTime：2018年5月25日 上午11:44:06   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class YearValueMatcher implements ValueMatcher{
	
	private List<Integer> valueList;
	
	public YearValueMatcher(List<Integer> intValueList) {
		this.valueList = intValueList;
	}

	@Override
	public boolean match(Integer t) {
		return valueList.contains(t);
	}
}
