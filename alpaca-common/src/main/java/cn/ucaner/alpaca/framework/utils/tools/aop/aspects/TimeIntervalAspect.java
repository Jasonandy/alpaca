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

import cn.ucaner.alpaca.framework.utils.tools.core.date.TimeInterval;
import cn.ucaner.alpaca.framework.utils.tools.log.Log;
import cn.ucaner.alpaca.framework.utils.tools.log.LogFactory;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.aop.aspects   
* @ClassName：TimeIntervalAspect   
* @Description：   <p> 通过日志打印方法的执行时间的切面 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午9:50:18   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class TimeIntervalAspect extends SimpleAspect{
	
	private static final Log log = LogFactory.get();

	public TimeIntervalAspect(Object target) {
		super(target);
	}
	
	private TimeInterval interval = new TimeInterval();

	@Override
	public boolean before(Object target, Method method, Object[] args) {
		interval.start();//开始计时
		return true;
	}
	
	@Override
	public boolean after(Object target, Method method, Object[] args) {
		log.info("Method [{}.{}] execute spend [{}]ms", target.getClass().getName(), method.getName(), interval.intervalMs());
		return true;
	}
}
