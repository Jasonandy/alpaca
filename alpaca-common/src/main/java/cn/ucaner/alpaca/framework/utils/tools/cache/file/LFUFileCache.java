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
package cn.ucaner.alpaca.framework.utils.tools.cache.file;

import java.io.File;

import cn.ucaner.alpaca.framework.utils.tools.cache.Cache;
import cn.ucaner.alpaca.framework.utils.tools.cache.impl.LFUCache;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.cache.file   
* @ClassName：LFUFileCache   
* @Description：   <p> 使用LFU缓存文件，以解决频繁读取文件引起的性能问题 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午9:53:32   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class LFUFileCache extends AbstractFileCache{
	
	/**
	 * 构造<br>
	 * 最大文件大小为缓存容量的一半<br>
	 * 默认无超时
	 * @param capacity 缓存容量
	 */
	public LFUFileCache(int capacity) {
		this(capacity, capacity / 2, 0);
	}

	/**
	 * 构造<br>
	 * 默认无超时
	 * @param capacity 缓存容量
	 * @param maxFileSize 最大文件大小
	 */
	public LFUFileCache(int capacity, int maxFileSize) {
		this(capacity, maxFileSize, 0);
	}

	/**
	 * 构造
	 * @param capacity 缓存容量
	 * @param maxFileSize 文件最大大小
	 * @param timeout 默认超时时间，0表示无默认超时
	 */
	public LFUFileCache(int capacity, int maxFileSize, long timeout) {
		super(capacity, maxFileSize, timeout);
	}

	@Override
	protected Cache<File, byte[]> initCache() {
		Cache<File, byte[]> cache = new LFUCache<File, byte[]>(this.capacity, this.timeout) {
			@Override
			public boolean isFull() {
				return LFUFileCache.this.usedSize > this.capacity;
			}
			
			@Override
			protected void onRemove(File key, byte[] cachedObject) {
				usedSize -= cachedObject.length;
			}
		};
		return cache;
	}

}
