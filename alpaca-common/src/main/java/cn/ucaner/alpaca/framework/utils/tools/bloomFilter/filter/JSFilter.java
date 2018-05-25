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
* @ClassName：JSFilter   
* @Description：   <p> JSFilter </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:10:32   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class JSFilter extends AbstractFilter {

	public JSFilter(long maxValue, int machineNum) {
		super(maxValue, machineNum);
	}

	public JSFilter(long maxValue) {
		super(maxValue);
	}

	@Override
	public long hash(String str) {
		int hash = 1315423911;

		for (int i = 0; i < str.length(); i++) {
			hash ^= ((hash << 5) + str.charAt(i) + (hash >> 2));
		}
		
		if(hash<0) {
			hash*=-1 ;
		}
		
		return hash % size;
	}

}
