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
package cn.ucaner.alpaca.framework.utils.beanConvert;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
* @Package：cn.ucaner.common.utils.beanConvert   
* @ClassName：BeanMapConvert   
* @Description：   <p> Bean与Map的转换</p>
* @Author： - Jason 
* @CreatTime：2017年10月24日 下午3:51:19   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class BeanMapConvert {
   
	/**
	 * Bean转换为Map
	 * @param object
	 * @return
	 */
    public static Map<String,Object> bean2MapObject(Object object){
        if(object == null){
            return null;
        }

        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(object);

                    map.put(key, value);
                }
            }
        } catch (Exception e) {
           e.printStackTrace();
        }

        return map;
    }

   /**
    *  Map转换为Java Bean
    * @param map
    * @param object
    * @return
    */
    public static Object map2Bean(Map<?, ?> map,Object object){
        if(map == null || object == null){
            return null;
        }
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (map.containsKey(key)) {
                    Object value = map.get(key);
                    // 得到property对应的setter方法
                    Method setter = property.getWriteMethod();
                    setter.invoke(object, value);
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return object;
    }
    
    /**
     * Test for Jason 
     */
    public static void main(String[] args) {
		DemoBean demoBean = new DemoBean();
		demoBean.setAge(23);
		demoBean.setName("Jason");
		demoBean.setSex(null);
    	System.out.println(bean2MapObject(demoBean));
	}
}
