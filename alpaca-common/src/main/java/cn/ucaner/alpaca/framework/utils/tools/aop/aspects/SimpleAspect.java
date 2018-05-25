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
package cn.ucaner.alpaca.framework.utils.tools.aop.aspects;

import java.lang.reflect.Method;

import cn.ucaner.alpaca.framework.utils.tools.aop.Aspect;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.aop.aspects   
* @ClassName：SimpleAspect   
* @Description：   <p> 简单切面类，不做任何操作<br>可以继承此类实现自己需要的方法即可</p>
* @Author： -    
* @CreatTime：2018年5月25日 上午9:49:49   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class SimpleAspect extends Aspect{
	
	public SimpleAspect(Object target) {
		super(target);
	}

	@Override
	public boolean before(Object target, Method method, Object[] args) {
		//继承此类后实现此方法
		return true;
	}

	@Override
	public boolean after(Object target, Method method, Object[] args) {
		//继承此类后实现此方法
		return true;
	}

	@Override
	public boolean afterException(Object target, Method method, Object[] args, Throwable e) {
		//继承此类后实现此方法
		return true;
	}

}
