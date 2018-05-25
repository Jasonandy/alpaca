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
* @ClassName：BitMap   
* @Description：   <p> 所谓bitmap就是用一个bit位来标记某个元素对应的value，而key即是这个元素。
* 由于采用bit为单位来存储数据，因此在可以大大的节省存储空间
* 关键是十进制和二进制bit位需要一个map映射表，把10进制映射到bit位上</p>
* @Author： -  
* @CreatTime：2017-11-3 上午10:54:45   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public interface BitMap {

	public final int MACHINE32 = 32;
	public final int MACHINE64 = 64;

	public void add(long i);

	public boolean contains(long i);

	public void remove(long i);
}