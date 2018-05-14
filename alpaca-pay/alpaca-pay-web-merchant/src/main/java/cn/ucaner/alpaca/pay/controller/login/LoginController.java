package cn.ucaner.alpaca.pay.controller.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.ucaner.alpaca.pay.common.core.utils.EncryptUtil;
import cn.ucaner.alpaca.pay.common.core.utils.StringUtil;
import cn.ucaner.alpaca.pay.controller.common.BaseController;
import cn.ucaner.alpaca.pay.controller.common.ConstantClass;
import cn.ucaner.alpaca.pay.user.entity.RpUserInfo;
import cn.ucaner.alpaca.pay.user.service.RpUserInfoService;

/**
* @Package：cn.ucaner.alpaca.pay.controller.login   
* @ClassName：LoginController   
* @Description：   <p>  登录 </p>
* @Author： -    
* @CreatTime：2018年5月12日 下午2:24:21   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
@Controller
public class LoginController extends BaseController {
	@Autowired
	private RpUserInfoService rpUserInfoService;

	/**
	 * 函数功能说明 ：登录
	 * 
	 * @参数： @return
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/login", method ={RequestMethod.POST,RequestMethod.GET})
	public String login(HttpServletRequest request, Model model) {
		
		return "system/login";
	}
	
	/**
	 * 函数功能说明 ：退出
	 * 
	 * @参数： @return
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/logout", method ={RequestMethod.POST,RequestMethod.GET})
	public String logout(HttpServletRequest request, Model model) {
		request.getSession().removeAttribute(ConstantClass.USER);
		return "system/login";
	}
	
	/**
	 * 函数功能说明 ：首页
	 * 
	 * @参数： @return
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/index", method ={RequestMethod.POST,RequestMethod.GET})
	public String index(HttpServletRequest request, Model model) {
		// 获取登录的用户
        RpUserInfo rpUserInfo = (RpUserInfo)request.getSession().getAttribute(ConstantClass.USER);
        if(rpUserInfo != null){
        	return "system/index";
        }
		
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		String msg = "";
		if(StringUtil.isEmpty(mobile)){
			msg = "请输入手机号/密码";
			model.addAttribute("msg", msg);
			return "system/login";
		}
		if(StringUtil.isEmpty(password)){
			msg = "请输入手机号/密码";
			model.addAttribute("msg", msg);
			return "system/login";
		}
		rpUserInfo = rpUserInfoService.getDataByMobile(mobile);
		if (rpUserInfo == null) {
			msg = "用户名/密码错误";
		}
		else if(!EncryptUtil.encodeMD5String(password).equals(rpUserInfo.getPassword())){
			msg = "用户名/密码错误";
		}
		model.addAttribute("mobile", mobile);
		model.addAttribute("password", password);
		request.getSession().setAttribute(ConstantClass.USER, rpUserInfo);
		if(!StringUtil.isEmpty(msg)){
			model.addAttribute("msg", msg);
			return "system/login";
		}
		return "system/index";
	}

}
