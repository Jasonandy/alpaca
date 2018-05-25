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
* @Package：cn.ucaner.alpaca.framework.utils.tools.bloomFilter.filter   
* @ClassName：RSFilter   
* @Description：   <p> RSFilter </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:11:01   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class RSFilter extends AbstractFilter {

	public RSFilter(long maxValue, int machineNum) {
		super(maxValue, machineNum);
	}

	public RSFilter(long maxValue) {
		super(maxValue);
	}

	@Override
	public long hash(String str) {
		return HashUtil.rsHash(str) % size;
	}

}
