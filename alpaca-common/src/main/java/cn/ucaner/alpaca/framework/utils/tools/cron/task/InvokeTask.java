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
package cn.ucaner.alpaca.framework.utils.tools.cron.task;

import java.lang.reflect.Method;

import cn.ucaner.alpaca.framework.utils.tools.core.exceptions.UtilException;
import cn.ucaner.alpaca.framework.utils.tools.core.util.ClassLoaderUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.ClassUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.ReflectUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;
import cn.ucaner.alpaca.framework.utils.tools.cron.CronException;


/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.cron.task   
* @ClassName：InvokeTask   
* @Description：   <p> 反射执行任务 </p>
* 通过传入类名#方法名，通过反射执行相应的方法<br>
* 如果是静态方法直接执行，如果是对象方法，需要类有默认的构造方法。
* @Author： -    
* @CreatTime：2018年5月25日 上午11:49:36   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class InvokeTask implements Task{
	
	private Class<?> clazz;
	private Object obj;
	private Method method;
	
	/**
	 * 构造
	 * @param classNameWithMethodName 类名与方法名的字符串表示，方法名和类名使用#隔开或者.隔开
	 */
	public InvokeTask(String classNameWithMethodName) {
		int splitIndex = classNameWithMethodName.lastIndexOf('#');
		if(splitIndex <= 0){
			splitIndex = classNameWithMethodName.lastIndexOf('.');
		}
		if (splitIndex <= 0) {
			throw new UtilException("Invalid classNameWithMethodName [{}]!", classNameWithMethodName);
		}

		//类
		final String className = classNameWithMethodName.substring(0, splitIndex);
		if(StrUtil.isBlank(className)) {
			throw new IllegalArgumentException("Class name is blank !");
		}
		this.clazz = ClassLoaderUtil.loadClass(className);
		if(null == this.clazz) {
			throw new IllegalArgumentException("Load class with name of [" + className + "] fail !");
		}
		this.obj = ReflectUtil.newInstance(this.clazz);
		
		//方法
		final String methodName = classNameWithMethodName.substring(splitIndex + 1);
		if(StrUtil.isBlank(methodName)) {
			throw new IllegalArgumentException("Method name is blank !");
		}
		this.method = ClassUtil.getPublicMethod(this.clazz, methodName);
		if(null == this.method) {
			throw new IllegalArgumentException("No method with name of [" + methodName + "] !");
		}
	}

	@Override
	public void execute() {
		try {
			ReflectUtil.invoke(this.obj, this.method, new Object[]{});
		} catch (UtilException e) {
			throw new CronException(e.getCause());
		}
	}
}
