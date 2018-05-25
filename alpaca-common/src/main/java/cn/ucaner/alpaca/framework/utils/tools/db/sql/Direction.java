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
* @ClassName：Direction   
* @Description：   <p> 排序方式（升序或者降序） </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:27:45   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public enum Direction{
	/** 升序 */
	ASC,
	/** 降序 */
	DESC;
	
	/**
	 * 根据字符串值返回对应{@link Direction}值
	 * 
	 * @param value 排序方式字符串，只能是 ASC或DESC
	 * @return {@link Direction}
	 * @throws IllegalArgumentException in case the given value cannot be parsed into an enum value.
	 */
	public static Direction fromString(String value) throws IllegalArgumentException{

		try {
			return Direction.valueOf(value.toUpperCase());
		} catch (Exception e) {
			throw new IllegalArgumentException(StrUtil.format(
					"Invalid value [{}] for orders given! Has to be either 'desc' or 'asc' (case insensitive).", value), e);
		}
	}
}
