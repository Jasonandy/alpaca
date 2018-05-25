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
package cn.ucaner.alpaca.framework.utils.tools.bloomFilter.filter;

import cn.ucaner.alpaca.framework.utils.tools.core.util.HashUtil;

/**
* @Package：cn.ucaner.tools.bloomFilter.filter   
* @ClassName：DefaultFilter   
* @Description：   <p> 默认Bloom过滤器，使用Java自带的Hash算法</p>
* @Author： -  
* @CreatTime：2017-11-3 上午10:22:35   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class DefaultFilter extends AbstractFilter {

	public DefaultFilter(long maxValue, int MACHINENUM) {
		super(maxValue, MACHINENUM);
	}
	
	public DefaultFilter(long maxValue) {
		super(maxValue);
	}
	
	@Override
	public long hash(String str) {
		//JAVA自己带的算法
		return HashUtil.javaDefaultHash(str) % size;
	}
}
