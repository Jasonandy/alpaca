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
package cn.ucaner.alpaca.framework.utils.tools.core.lang;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

import cn.ucaner.alpaca.framework.utils.tools.core.clone.CloneSupport;
import cn.ucaner.alpaca.framework.utils.tools.core.collection.ArrayIterator;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.lang   
* @ClassName：Tuple   
* @Description：   <p> 不可变数组类型，用于多值返回 </p>
* 多值可以支持每个元素值类型不同
* @Author： -    
* @CreatTime：2018年5月25日 下午12:03:09   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class Tuple extends CloneSupport<Tuple> implements Iterable<Object>, Serializable{
	
	private static final long serialVersionUID = -7689304393482182157L;
	
	private Object[] members;
	
	/**
	 * 构造
	 * @param members 成员数组
	 */
	public Tuple(Object... members) {
		this.members = members;
	}
	
	/**
	 * 获取指定位置元素
	 * @param <T> 返回对象类型
	 * @param index 位置
	 * @return 元素
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(int index){
		return (T) members[index];
	}
	
	/**
	 * 获得所有元素
	 * @return 获得所有元素
	 */
	public Object[] getMembers(){
		return this.members;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(members);
	}

	@Override
	public Iterator<Object> iterator() {
		return new ArrayIterator<Object>(members);
	}
}
