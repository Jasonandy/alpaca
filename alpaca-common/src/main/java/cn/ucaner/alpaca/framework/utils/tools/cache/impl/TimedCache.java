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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import cn.ucaner.alpaca.framework.utils.tools.cache.GlobalPruneTimer;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.cache.impl   
* @ClassName：TimedCache   
* @Description：   定时缓存<br>
*  此缓存没有容量限制，对象只有在过期后才会被移除
* @Author： - wubin   
* @CreatTime：2018年5月25日 上午9:55:53   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class TimedCache<K, V> extends AbstractCache<K, V> {

	/** 正在执行的定时任务 */
	private ScheduledFuture<?> pruneJobFuture;

	/**
	 * 构造
	 * 
	 * @param timeout 超时（过期）时长，单位毫秒
	 */
	public TimedCache(long timeout) {
		this(timeout, new HashMap<K, CacheObj<K, V>>());
	}

	/**
	 * 构造
	 * 
	 * @param timeout 过期时长
	 * @param map 存储缓存对象的map
	 */
	public TimedCache(long timeout, Map<K, CacheObj<K, V>> map) {
		this.capacity = 0;
		this.timeout = timeout;
		this.cacheMap = map;
	}

	// ---------------------------------------------------------------- prune
	/**
	 * 清理过期对象
	 * 
	 * @return 清理数
	 */
	@Override
	protected int pruneCache() {
		int count = 0;
		Iterator<CacheObj<K, V>> values = cacheMap.values().iterator();
		CacheObj<K, V> co;
		while (values.hasNext()) {
			co = values.next();
			if (co.isExpired()) {
				values.remove();
				count++;
			}
		}
		return count;
	}

	// ---------------------------------------------------------------- auto prune
	/**
	 * 定时清理
	 * 
	 * @param delay 间隔时长，单位毫秒
	 */
	public void schedulePrune(long delay) {
		this.pruneJobFuture = GlobalPruneTimer.INSTANCE.schedule(new Runnable() {
			@Override
			public void run() {
				prune();
			}
		}, delay);
	}

	/**
	 * 取消定时清理
	 */
	public void cancelPruneSchedule() {
		if (null != pruneJobFuture) {
			pruneJobFuture.cancel(true);
		}
	}

}
