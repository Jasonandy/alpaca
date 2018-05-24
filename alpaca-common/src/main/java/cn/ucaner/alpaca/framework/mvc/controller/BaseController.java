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
package cn.ucaner.alpaca.framework.mvc.controller;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import cn.ucaner.alpaca.framework.mvc.entity.BaseEntity;
import cn.ucaner.alpaca.framework.mvc.service.BaseService;

/**
* @Package：cn.ucaner.framework.mvc.controller   
* @ClassName：BaseController   
* @Description：   <p> BaseController</p>
* @Author： - Jason 
* @CreatTime：2017年8月30日 下午1:53:13   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public abstract class BaseController<T extends BaseEntity, PK extends Serializable> {

	/**
	 * 获取服务
	 * 
	 * @return BaseService
	 */
	protected abstract BaseService<T, PK> getService();

	/**
	 * 获取基础路径
	 * @return
	 */
	protected abstract String getBasePath();

	/**
	 * getRootAbsolutePath方法
	 *<p>获取项目在操作系统的绝对路径</p>
	 *		返回形如D:\工具\Tomcat-6.0\webapps\projectname\字符串   其中projectname为项目名称
	 * @param request
	 * @return
	 * @author : Asiainfo R&D deparment(GuangZhou)/Yuce 
	 */
	public String getRootAbsolutePath(HttpServletRequest request) {
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		return rootPath;
	}

	/**
	 * 得到应用的访问头地址 http://ip(域名):端口/应用名
	 * @param request
	 * @return
	 */
	public String getBasePath(HttpServletRequest request) {
		String appUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
		return appUrl.concat(request.getContextPath());
	}

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		// 1. 使用spring自带的CustomDateEditor
		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// binder.registerCustomEditor(Date.class, new
		// CustomDateEditor(dateFormat, true));
		//2. 自定义的PropertyEditorSupport
		binder.registerCustomEditor(Date.class, new DateConvertEditor());
	}

}
