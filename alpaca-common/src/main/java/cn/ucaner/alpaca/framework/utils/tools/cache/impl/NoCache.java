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

import java.util.Iterator;

import cn.ucaner.alpaca.framework.utils.tools.cache.Cache;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.cache.impl   
* @ClassName：NoCache   
* @Description：   <p> 无缓存实现，用于快速关闭缓存 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:00:12   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class NoCache<K, V> implements Cache<K, V> {

	@Override
	public int capacity() {
		return 0;
	}

	@Override
	public long timeout() {
		return 0;
	}

	@Override
	public void put(K key, V object) {
		// 跳过
	}

	@Override
	public void put(K key, V object, long timeout) {
		// 跳过
	}
	
	@Override
	public boolean containsKey(K key) {
		return false;
	}

	@Override
	public V get(K key) {
		return null;
	}

	@Override
	public Iterator<V> iterator() {
		return null;
	}

	@Override
	public int prune() {
		return 0;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public void remove(K key) {
		// 跳过
	}

	@Override
	public void clear() {
		// 跳过
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

}
