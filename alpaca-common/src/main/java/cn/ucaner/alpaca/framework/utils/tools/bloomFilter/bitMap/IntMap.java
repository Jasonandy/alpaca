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
package cn.ucaner.alpaca.framework.utils.tools.bloomFilter.bitMap;

/**
* @Package：cn.ucaner.tools.bloomFilter.bitMap   
* @ClassName：IntMap   
* @Description：   <p> 过滤器BitMap在32位机器上.这个类能发生更好的效果.一般情况下建议使用此类 </p>
* @Author： -  
* @CreatTime：2017-11-3 上午10:57:50   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class IntMap implements BitMap {

	private static final int MAX = Integer.MAX_VALUE;

	public IntMap() {
		ints = new int[93750000];
	}

	public IntMap(int size) {
		ints = new int[size];
	}

	private int[] ints = null;

	public void add(long i) {
		int r = (int) (i / BitMap.MACHINE32);
		int c = (int) (i % BitMap.MACHINE32);
		ints[r] = (int) (ints[r] | (1 << c));
	}

	public boolean contains(long i) {
		int r = (int) (i / BitMap.MACHINE32);
		int c = (int) (i % BitMap.MACHINE32);
		if (((int) ((ints[r] >>> c)) & 1) == 1) {
			return true;
		}
		return false;
	}

	public void remove(long i) {
		int r = (int) (i / BitMap.MACHINE32);
		int c = (int) (i % BitMap.MACHINE32);
		ints[r] = (int) (ints[r] & (((1 << (c + 1)) - 1) ^ MAX));
	}

}