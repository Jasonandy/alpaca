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

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.lang   
* @ClassName：Editor   
* @Description：   <p> 编辑器接口，常用于对于集合中的元素做统一编辑 </p>
* 此编辑器两个作用：
* <pre>
* 1、如果返回值为<code>null</code>，表示此值被抛弃 
* 2、对对象做修改
* </pre>
* @Author： - wubin   
* @CreatTime：2018年5月25日 上午11:17:50   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface Editor<T> {
	/**
	 * 修改过滤后的结果
	 * 
	 * @param t 被过滤的对象
	 * @return 修改后的对象，如果被过滤返回<code>null</code>
	 */
	public T edit(T t);
}
