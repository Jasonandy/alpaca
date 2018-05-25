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
* @ClassName：ELFFilter   
* @Description：   <p> ELFFilter </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午9:52:13   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class ELFFilter extends AbstractFilter {

	public ELFFilter(long maxValue, int MACHINENUM) {
		super(maxValue, MACHINENUM);
	}
	
	public ELFFilter(long maxValue) {
		super(maxValue);
	}
	
	@Override
	public long hash(String str) {
		return HashUtil.elfHash(str) % size;
	}

}
