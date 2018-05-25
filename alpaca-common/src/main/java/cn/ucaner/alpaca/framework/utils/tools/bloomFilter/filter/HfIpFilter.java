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

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.bloomFilter.filter   
* @ClassName：HfIpFilter   
* @Description：   <p> HfIpFilter </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:10:18   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class HfIpFilter extends AbstractFilter {

	public HfIpFilter(long maxValue, int machineNum) {
		super(maxValue, machineNum);
	}

	public HfIpFilter(long maxValue) {
		super(maxValue);
	}

	@Override
	public long hash(String str) {
		int length = str.length();
		long hash = 0;
		for (int i = 0; i < length; i++) {
			hash += str.charAt(i % 4) ^ str.charAt(i);
		}
		return hash % size;
	}

}
