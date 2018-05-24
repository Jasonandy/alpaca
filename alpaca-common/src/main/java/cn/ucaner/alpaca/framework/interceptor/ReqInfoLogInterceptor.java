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

import java.io.Serializable;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.ucaner.alpaca.framework.utils.string.StringHelper;

/**
* @Package：cn.ucaner.framework.interceptor   
* @ClassName：ReqInfoLogInterceptor   
* @Description：   <p> ReqInfoLogInterceptor</p>
* @Author： - Jason 
* @CreatTime：2017年8月30日 下午1:52:13   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class ReqInfoLogInterceptor implements HandlerInterceptor, Serializable {

	private static final long serialVersionUID = 1485772771215514457L;

	private static Logger logger = LoggerFactory.getLogger(ReqInfoLogInterceptor.class);

	/**
	* 描述: 前置处理  by Jason  登录过滤 免登等
	* @param paramHttpServletRequest
	* @param paramHttpServletResponse
	* @param paramObject
	* @return
	* @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, Object paramObject)
	        throws Exception {
		if (logger.isDebugEnabled()) {
			long begin = System.currentTimeMillis();

			String uri = paramHttpServletRequest.getRequestURI();

			if (paramObject instanceof HandlerMethod) {
				Method method = ( (HandlerMethod) paramObject ).getMethod();

				logger.info(StringHelper.buildInfoString("", "开始请求", uri, ".", method.getName(), ""));

				logger.info(StringHelper.map2String(paramHttpServletRequest.getParameterMap(), "" + "请求数据", "",
				        "--------------------------------------------------------", true, "="));
			}
			paramHttpServletRequest.setAttribute("begin", begin);
			paramHttpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
		}

		return true;
	}

	/**
	* 描述:  postHandle
	* @param paramHttpServletRequest
	* @param paramHttpServletResponse
	* @param paramObject
	* @param paramModelAndView
	* @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, Object paramObject,
	        ModelAndView paramModelAndView) throws Exception {
		if (logger.isDebugEnabled()) {
			long begin = (Long) paramHttpServletRequest.getAttribute("begin");
			paramHttpServletRequest.removeAttribute("startTime");
			String uri = paramHttpServletRequest.getRequestURI();
			logger.info(StringHelper.buildInfoString("", "", "结束", uri, ",耗时", System.currentTimeMillis() - begin, "毫秒"));
		}
	}

	/**
	* 描述: afterCompletion
	* @param paramHttpServletRequest
	* @param paramHttpServletResponse
	* @param paramObject
	* @param paramException
	* @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, Object paramObject,
	        Exception paramException) throws Exception {
	}

}
