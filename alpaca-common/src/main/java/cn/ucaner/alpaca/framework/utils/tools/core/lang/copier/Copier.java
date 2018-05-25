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
package cn.ucaner.alpaca.framework.utils.tools.core.lang.copier;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.lang.copier   
* @ClassName：Copier   
* @Description：   <p> 拷贝接口 @param <T> 拷贝目标类型 </p>
* @Author： - wubin   
* @CreatTime：2018年5月25日 上午11:58:55   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface Copier<T> {
	/**
	 * 执行拷贝
	 * @return 拷贝的目标
	 */
	T copy();
}
