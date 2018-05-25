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
package cn.ucaner.alpaca.framework.utils.tools.core.getter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.getter   
* @ClassName：ListTypeGetter   
* @Description：   <p> 列表类型的Get接口 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午1:16:19   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface ListTypeGetter {
	/*-------------------------- List类型 start -------------------------------*/
	/**
	 * 获取Object型属性值列表
	 * 
	 * @param key 属性名
	 * @return 属性值列表
	 */
	List<Object> getObjList(String key);

	/**
	 * 获取String型属性值列表
	 * 
	 * @param key 属性名
	 * @return 属性值列表
	 */
	List<String> getStrList(String key);
	
	/**
	 * 获取Integer型属性值列表
	 * 
	 * @param key 属性名
	 * @return 属性值列表
	 */
	List<Integer> getIntList(String key);
	
	/**
	 * 获取Short型属性值列表
	 * 
	 * @param key 属性名
	 * @return 属性值列表
	 */
	List<Short> getShortList(String key);
	
	/**
	 * 获取Boolean型属性值列表
	 * 
	 * @param key 属性名
	 * @return 属性值列表
	 */
	List<Boolean> getBoolList(String key);
	
	/**
	 * 获取BigDecimal型属性值列表
	 * 
	 * @param key 属性名
	 * @return 属性值列表
	 */
	List<Long> getLongList(String key);
	
	/**
	 * 获取Character型属性值列表
	 * 
	 * @param key 属性名
	 * @return 属性值列表
	 */
	List<Character> getCharList(String key);
	
	/**
	 * 获取Double型属性值列表
	 * 
	 * @param key 属性名
	 * @return 属性值列表
	 */
	List<Double> getDoubleList(String key);
	
	/**
	 * 获取Byte型属性值列表
	 * 
	 * @param key 属性名
	 * @return 属性值列表
	 */
	List<Byte> getByteList(String key);
	
	/**
	 * 获取BigDecimal型属性值列表
	 * 
	 * @param key 属性名
	 * @return 属性值列表
	 */
	List<BigDecimal> getBigDecimalList(String key);
	
	/**
	 * 获取BigInteger型属性值列表
	 * 
	 * @param key 属性名
	 * @return 属性值列表
	 */
	List<BigInteger> getBigIntegerList(String key);
	/*-------------------------- List类型 end -------------------------------*/
}
