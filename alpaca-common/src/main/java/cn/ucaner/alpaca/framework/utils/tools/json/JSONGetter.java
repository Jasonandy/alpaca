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
package cn.ucaner.alpaca.framework.utils.tools.json;

import cn.ucaner.alpaca.framework.utils.tools.core.convert.ConvertException;
import cn.ucaner.alpaca.framework.utils.tools.core.getter.OptNullBasicTypeFromObjectGetter;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.json   
* @ClassName：JSONGetter   
* @Description：   <p> 用于JSON的Getter类，提供各种类型的Getter方法 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:59:00   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public abstract class JSONGetter<K> extends OptNullBasicTypeFromObjectGetter<K>{
	
	/**
	 * 获得JSONArray对象<br>
	 * 如果值为其它类型对象，尝试转换为{@link JSONArray}返回，否则抛出异常
	 * 
	 * @param key KEY
	 * @return JSONArray对象，如果值为null或者非JSONArray类型，返回null
	 */
	public JSONArray getJSONArray(K key) {
		final Object object = this.getObj(key);
		if(null == object) {
			return null;
		}
		
		if(object instanceof JSONArray) {
			return (JSONArray) object;
		}
		return new JSONArray(object);
	}

	/**
	 * 获得JSONObject对象<br>
	 * 如果值为其它类型对象，尝试转换为{@link JSONObject}返回，否则抛出异常
	 * 
	 * @param key KEY
	 * @return JSONArray对象，如果值为null或者非JSONObject类型，返回null
	 */
	public JSONObject getJSONObject(K key) {
		final Object object = this.getObj(key);
		if(null == object) {
			return null;
		}
		
		if(object instanceof JSONObject) {
			return (JSONObject) object;
		}
		return new JSONObject(object);
	}
	
	/**
	 * 从JSON中直接获取Bean对象<br>
	 * 先获取JSONObject对象，然后转为Bean对象
	 * 
	 * @param <T> Bean类型
	 * @param key KEY
	 * @param beanType Bean类型
	 * @return Bean对象，如果值为null或者非JSONObject类型，返回null
	 * @since 3.1.1
	 */
	public <T> T getBean(K key, Class<T> beanType) {
		final JSONObject obj = getJSONObject(key);
		return (null == obj) ? null : obj.toBean(beanType);
	}
	
	/**
	 * 获取指定类型的对象<br>
	 * 转换失败或抛出异常
	 * 
	 * @param <T> 获取的对象类型
	 * @param key 键
	 * @param type 获取对象类型
	 * @return 对象
	 * @throws ConvertException 转换异常
	 * @since 3.0.8
	 */
	public <T> T get(K key, Class<T> type) throws ConvertException{
		return get(key, type, false);
	}
	
	/**
	 * 获取指定类型的对象
	 * 
	 * @param <T> 获取的对象类型
	 * @param key 键
	 * @param type 获取对象类型
	 * @param ignoreError 是否跳过转换失败的对象或值
	 * @return 对象
	 * @throws ConvertException 转换异常
	 * @since 3.0.8
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(K key, Class<T> type, boolean ignoreError) throws ConvertException{
		final Object value = this.getObj(key);
		if(null == value){
			return null;
		}
		return (T) InternalJSONUtil.jsonConvert(type, value, ignoreError);
	}
}
