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
package cn.ucaner.alpaca.framework.utils.json;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
* @Package：cn.ucaner.common.utils   
* @ClassName：JsonUtils   
* @Description：   <p> Json数据转换工具 </p>
* @Author： - Jason 
* @CreatTime：2017年10月24日 上午10:51:35   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class JsonUtils {

	/**
	 * 将Javabean转换为Map
	 * @param javaBean javaBean
	 * @return Map对象
	 */
	public static Map<String, Object> toMap(Object javaBean) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Method[] methods = javaBean.getClass().getDeclaredMethods();
			for (Method method : methods) {
				try {
					if (method.getName().startsWith("get")) {
						String field = method.getName();
						field = field.substring(field.indexOf("get") + 3);
						field = field.toLowerCase().charAt(0) + field.substring(1);

						Object value = method.invoke(javaBean, (Object[]) null);
						result.put(field, null == value ? "" : value.toString());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return result;
		} catch (SecurityException e) {
			return result;
		}
	}

	/**
	 * 将Json对象转换成Map
	 * @param jsonString json对象
	 * @return Map对象
	 * @throws JSONException
	 */
	public static Map<String, String> toMap(String jsonString) throws JSONException {
		JSONObject jsonObject = JSONObject.parseObject(jsonString);
		Map<String, String> result = new HashMap<String, String>();
		Iterator<?> iterator = jsonObject.entrySet().iterator();
		String key = null;
		String value = null;
		while (iterator.hasNext()) {
			key = (String) iterator.next();
			value = jsonObject.getString(key);
			result.put(key, value);
		}
		return result;
	}

	public static Map<String, Object> parseJSON2Map(String jsonStr) throws JSONException {
		Map<String, Object> map = new HashMap<String, Object>();
		//最外层解析
		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
		//Iterator iterator = jsonObject.entrySet().iterator();
		for (Object key : jsonObject.keySet()) {
			Object value = jsonObject.get(key);
			if (value instanceof JSONArray) {
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				JSONArray jsonArray = ( (JSONArray) value );
				for (int i = 0; i < jsonArray.size(); i++) {
					JSONObject json2 = jsonArray.getJSONObject(i);
					list.add(parseJSON2Map(json2.toString()));

				}
				map.put((String) key, list);
			} else if (value instanceof JSONObject) {
				Map<String, Object> subMap = parseJSON2Map(value.toString());
				map.put((String) key, subMap);
			} else {
				map.put((String) key, value);
			}
		}
		return map;
	}

	/**
	 * 将JavaBean转换成JSONObject（通过Map中转）
	 * @param bean javaBean
	 * @return json对象
	 */
	public static JSONObject toJSON(Object bean) {
		return new JSONObject(toMap(bean));
	}

	/**
	 * 将Map转换成Javabean
	 * @param javabean javaBean
	 * @param data     Map数据
	 */
	public static Object toJavaBean(Object javabean, Map<?, ?> data) {
		Method[] methods = javabean.getClass().getDeclaredMethods();
		for (Method method : methods) {
			try {
				if (method.getName().startsWith("set")) {
					String field = method.getName();
					field = field.substring(field.indexOf("set") + 3);
					field = field.toLowerCase().charAt(0) + field.substring(1);
					method.invoke(javabean, new Object[] { data.get(field) });
				}
			} catch (Exception e) {
			}
		}
		return javabean;
	}

	/**
	 * JSONObject到JavaBean
	 * @param javabean
	 * @return json对象
	 * @throws java.text.ParseException json解析异常
	 * @throws JSONException
	 */
	public static void toJavaBean(Object javabean, String jsonString) throws ParseException, JSONException {
		JSONObject jsonObject = JSONObject.parseObject(jsonString);
		Map<?, ?> map = toMap(jsonObject.toString());
		toJavaBean(javabean, map);
	}
	
	/**
	 * For Test By Jason
	 */
	public static void main(String[] args) {
		
	}
}