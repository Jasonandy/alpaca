package cn.ucaner.alpaca.common.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
* @Package：cn.ucaner.alpaca.common.util   
* @ClassName：EhCacheUtil   
* @Description：   <p> Ehcache工具类 </p>
* @Author： -    
* @CreatTime：2018年5月24日 下午2:14:36   
* @Modify By：   
* @ModifyTime：  2018年5月24日
* @Modify marker：   
* @version    V1.0
 */
public class EhCacheUtil {

    /**
     * 获取缓存
     * @param cacheName
     * @return
     */
    private static Cache getCache(String cacheName) {
        CacheManager cacheManager = CacheManager.getInstance();
        if (null == cacheManager) {
            return null;
        }
        Cache cache = cacheManager.getCache(cacheName);
        if (null == cache) {
            return null;
        }
        return cache;
    }

    /**
     * 新增缓存记录
     * @param cacheName
     * @param key
     * @param value
     */
    public static void put(String cacheName, String key, Object value) {
        Cache cache = getCache(cacheName);
        if (null != cache) {
            Element element = new Element(key, value);
            cache.put(element);
        }
    }

    /**
     * 删除缓存记录
     * @param cacheName
     * @param key
     * @return
     */
    public static boolean remove(String cacheName, String key) {
        Cache cache = getCache(cacheName);
        if (null == cache) {
            return false;
        }
        return cache.remove(key);
    }

    /**
     * 删除全部缓存记录
     * @param cacheName
     * @return
     */
    public static void removeAll(String cacheName) {
        Cache cache = getCache(cacheName);
        if (null != cache) {
            cache.removeAll();
        }
    }

    /**
     * 获取缓存记录
     * @param cacheName
     * @param key
     * @return
     */
    public static Object get(String cacheName, String key) {
        Cache cache = getCache(cacheName);
        if (null == cache) {
            return null;
        }
        Element cacheElement = cache.get(key);
        if (null == cacheElement) {
            return null;
        }
        return cacheElement.getObjectValue();
    }


}
