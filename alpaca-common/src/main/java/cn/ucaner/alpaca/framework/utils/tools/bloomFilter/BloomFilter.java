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
package cn.ucaner.alpaca.framework.utils.tools.bloomFilter;

/**
* @Package：cn.ucaner.tools.bloomFilter   
* @ClassName：BloomFilter   
* @Description：   <p> Bloom filter 是由 Howard Bloom 在 1970 年提出的二进制向量数据结构，它具有很好的空间和时间效率，被用来检测一个元素是不是集合中的一个成员。<br>
* 如果检测结果为是，该元素不一定在集合中；但如果检测结果为否，该元素一定不在集合中。<br>
* 因此Bloom filter具有100%的召回率。这样每个检测请求返回有“在集合内（可能错误）”和“不在集合内（绝对不在集合内）”两种情况。<br></p>
* @Author： -  
* @CreatTime：2017-11-3 上午9:58:06   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public interface BloomFilter {
	
	/**
	 *  Bloom-Filter，即布隆过滤器，1970年由Bloom中提出。
	 *  它可以用于检索一个元素是否在一个集合中。
	 *  Bloom Filter（BF）是一种空间效率很高的随机数据结构，它利用位数组很简洁地表示一个集合，
	 *  并能判断一个元素是否属于这个集合。
	 *  它是一个判断元素是否存在集合的快速的概率算法。
	 *  Bloom Filter有可能会出现错误判断，但不会漏掉判断。也
	 *  就是Bloom Filter判断元素不再集合，那肯定不在。如果判断元素存在集合中，有一定的概率判断错误。
	 *  因此，Bloom Filter不适合那些“零错误”的应用场合。
	 *  而在能容忍低错误率的应用场合下，Bloom Filter比其他常见的算法（如hash，折半查找）极大节省了空间。 
	 *  它的优点是空间效率和查询时间都远远超过一般的算法，缺点是有一定的误识别率和删除困难。
	 *  eg:http://blog.csdn.net/hguisu/article/details/7866173   by Jason
	 */

	/**
	 * @param str 字符串
	 * @return 判断一个字符串是否bitMap中存在
	 */
	public boolean contains(String str);

	/**
	 * 在boolean的bitMap中增加一个字符串<br>
	 * 如果存在就返回<code>false</code> .如果不存在.先增加这个字符串.再返回<code>true</code>
	 * @param str 字符串
	 * @return 是否加入成功，如果存在就返回<code>false</code> .如果不存在返回<code>true</code>
	 */
	public boolean add(String str);
	
	/**
	 * 常见的Hash算法
	 * 1. 加法Hash
	 * 2. 位运算Hash
	 * 3. 乘法Hash
	 * 4. 除法Hash
	 * 5. 查表Hash
	 * 6. 混合Hash
	 */
}