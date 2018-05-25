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
package cn.ucaner.alpaca.framework.utils.tools.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import cn.ucaner.alpaca.framework.utils.tools.core.exceptions.UtilException;
import cn.ucaner.alpaca.framework.utils.tools.core.util.ReflectUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.aop   
* @ClassName：Aspect   
* @Description：   <p> 切面抽象 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午9:50:35   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public abstract class Aspect implements InvocationHandler{
	
	private Object target;
	
	public Aspect(Object target) {
		this.target = target;
	}
	
	public Object getTarget(){
		return this.target;
	}
	
	/**
	 * 目标方法执行前的操作
	 * @param target 目标对象
	 * @param method 目标方法
	 * @param args 参数
	 * @return 是否继续执行接下来的操作
	 */
	public abstract boolean before(Object target, Method method, Object[] args);
	
	/**
	 * 目标方法执行后的操作
	 * @param target 目标对象
	 * @param method 目标方法
	 * @param args 参数
	 * @return 是否允许返回值（接下来的操作）
	 */
	public abstract boolean after(Object target, Method method, Object[] args);
	
	/**
	 * 目标方法抛出异常时的操作
	 * @param target 目标对象
	 * @param method 目标方法
	 * @param args 参数
	 * @param e 异常
	 * @return 是否允许抛出异常
	 */
	public abstract boolean afterException(Object target, Method method, Object[] args, Throwable e);
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		if(before(target, method, args)){
			try {
				result = ReflectUtil.invoke(target, method, args);
			}catch (UtilException e) {
				final Throwable cause = e.getCause();
				if(e.getCause() instanceof InvocationTargetException) {
					afterException(target, method, args, ((InvocationTargetException)cause).getTargetException());
				}else {
					throw e;//其它异常属于代理的异常，直接抛出
				}
			}
		}
		if(after(target, method, args)){
			return result;
		}
		return null;
	}
	
}
