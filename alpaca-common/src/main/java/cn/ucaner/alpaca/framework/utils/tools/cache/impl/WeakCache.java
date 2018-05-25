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
package cn.ucaner.alpaca.framework.utils.tools.cache.impl;

import java.util.WeakHashMap;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.cache.impl   
* @ClassName：WeakCache   
* @Description：   <p>  弱引用缓存<br>
* 对于一个给定的键，其映射的存在并不阻止垃圾回收器对该键的丢弃，这就使该键成为可终止的，被终止，然后被回收。<br>
* 丢弃某个键时，其条目从映射中有效地移除。<br>
* </p>
* @Author： - wubin   
* @CreatTime：2018年5月25日 上午9:55:20   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class WeakCache<K, V> extends TimedCache<K, V>{

	public WeakCache(long timeout) {
		super(timeout, new WeakHashMap<K, CacheObj<K, V>>());
	}

}
