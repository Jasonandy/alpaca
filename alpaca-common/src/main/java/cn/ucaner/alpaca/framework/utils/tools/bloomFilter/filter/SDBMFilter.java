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
* @ClassName：SDBMFilter   
* @Description：   <p> SDBMFilter </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:11:15   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class SDBMFilter extends AbstractFilter {

	public SDBMFilter(long maxValue, int machineNum) {
		super(maxValue, machineNum);
	}

	public SDBMFilter(long maxValue) {
		super(maxValue);
	}

	@Override
	public long hash(String str) {
		return HashUtil.sdbmHash(str) % size;
	}

}
