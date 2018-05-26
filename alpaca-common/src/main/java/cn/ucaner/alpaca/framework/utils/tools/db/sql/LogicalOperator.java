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
package cn.ucaner.alpaca.framework.utils.tools.db.sql;

import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.sql   
* @ClassName：LogicalOperator   
* @Description：   <p> 逻辑运算符 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:27:31   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public enum LogicalOperator{
	/** 且，两个条件都满足 */
	AND,
	/** 或，满足多个条件的一个即可 */
	OR;
	
	/**
	 * 给定字符串逻辑运算符是否与当前逻辑运算符一致，不区分大小写，自动去除两边空白符
	 * 
	 * @param logicalOperatorStr 逻辑运算符字符串
	 * @return 是否与当前逻辑运算符一致
	 * @since 3.2.1
	 */
	public boolean isSame(String logicalOperatorStr) {
		if(StrUtil.isBlank(logicalOperatorStr)) {
			return false;
		}
		return this.name().equalsIgnoreCase(logicalOperatorStr.trim());
	}
}