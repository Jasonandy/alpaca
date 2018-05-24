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
package cn.ucaner.alpaca.framework.interceptor;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
* @Package：cn.ucaner.framework.interceptor   
* @ClassName：MethodTimeAdviceInterceptor   
* @Description：   <p> 时长统计   方便系统性能统计</p>
* @Author： - Jason  
* @CreatTime：2017年8月30日 下午1:51:48   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class MethodTimeAdviceInterceptor implements MethodBeforeAdvice, AfterReturningAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(MethodTimeAdviceInterceptor.class);
	
	long tt = 0;

	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		tt = System.currentTimeMillis();
	}

	/**
	 * 统计性能
	 */
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		if (logger.isDebugEnabled()) {
			long lastTime = System.currentTimeMillis() - tt;
			StringBuffer buf =
			        new StringBuffer("EXECUTE:(").append(arg1.getName()).append(") BEGIN=").append(tt).append(", END=")
			                .append(System.currentTimeMillis()).append(", ELAPSE=").append(lastTime);
			logger.debug(buf.toString());
		}
	}
}
