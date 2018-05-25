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


/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.cache.impl   
* @ClassName：CacheObj   
* @Description：   <p> 缓存对象 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午9:57:22   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class CacheObj<K, V> {
	
	final K key;
	final V obj;
	
	/** 上次访问时间 */
	long lastAccess; 
	/** 访问次数 */
	long accessCount;
	/** 对象存活时长，0表示永久存活*/
	long ttl;
	
	CacheObj(K key, V obj, long ttl) {
		this.key = key;
		this.obj = obj;
		this.ttl = ttl;
		this.lastAccess = System.currentTimeMillis();
	}
	
	/**
	 * @return 是否过期
	 */
	boolean isExpired() {
		return (ttl > 0) && (lastAccess + ttl < System.currentTimeMillis());
	}
	
	/**
	 * @return 获得对象
	 */
	V get() {
		lastAccess = System.currentTimeMillis();
		accessCount++;
		return obj;
	}

	@Override
	public String toString() {
		return "CacheObj [key=" + key + ", obj=" + obj + ", lastAccess=" + lastAccess + ", accessCount=" + accessCount + ", ttl=" + ttl + "]";
	}
}
