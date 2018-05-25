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

import cn.ucaner.alpaca.framework.utils.tools.bloomFilter.BloomFilter;
import cn.ucaner.alpaca.framework.utils.tools.bloomFilter.bitMap.BitMap;
import cn.ucaner.alpaca.framework.utils.tools.bloomFilter.bitMap.IntMap;
import cn.ucaner.alpaca.framework.utils.tools.bloomFilter.bitMap.LongMap;

/**
* @Package：cn.ucaner.tools.bloomFilter.filter   
* @ClassName：AbstractFilter   
* @Description：   <p> 抽象Bloom过滤器</p>
* @Author： -  
* @CreatTime：2017-11-3 上午10:22:21   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public abstract class AbstractFilter implements BloomFilter {

	private BitMap bm = null;

	protected long size = 0;

	public AbstractFilter(long maxValue, int machineNum) {
		init(maxValue, machineNum);
	}

	public AbstractFilter(long maxValue) {
		this(maxValue, BitMap.MACHINE32);
	}

	public void init(long maxValue, int machineNum) {
		this.size = maxValue;
		switch (machineNum) {
			case BitMap.MACHINE32:
				bm = new IntMap((int) (size / machineNum));
				break;
			case BitMap.MACHINE64:
				bm = new LongMap((int) (size / machineNum));
				break;
			default:
				throw new RuntimeException("Error Machine number!");
		}
	}

	@Override
	public boolean contains(String str) {
		return bm.contains(hash(str));
	}

	@Override
	public boolean add(String str) {
		final long hash = this.hash(str);
		if (bm.contains(hash)) {
			return false;
		}

		bm.add(hash);
		return true;
	}

	/**
	 * 自定义Hash方法
	 * @param str 字符串
	 * @return HashCode
	 */
	public abstract long hash(String str) ;
}