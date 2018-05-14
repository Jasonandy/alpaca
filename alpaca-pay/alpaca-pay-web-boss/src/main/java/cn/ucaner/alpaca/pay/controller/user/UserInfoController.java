package cn.ucaner.alpaca.pay.controller.user;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.ucaner.alpaca.pay.common.core.dwz.DWZ;
import cn.ucaner.alpaca.pay.common.core.dwz.DwzAjax;
import cn.ucaner.alpaca.pay.common.core.page.PageBean;
import cn.ucaner.alpaca.pay.common.core.page.PageParam;
import cn.ucaner.alpaca.pay.user.entity.RpUserInfo;
import cn.ucaner.alpaca.pay.user.service.RpUserInfoService;

/**
* @Package：cn.ucner.alpaca.pay.controller.user   
* @ClassName：UserInfoController   
* @Description：   <p> 用户信息</p>
* @Author： -    
* @CreatTime：2018年5月12日 下午12:30:29   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
@Controller
@RequestMapping("/user/info")
public class UserInfoController {
	
	@Autowired
	private RpUserInfoService rpUserInfoService;

	/**
	 * 函数功能说明 ： 查询用户信息
	 * 
	 * @参数： @return
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/list", method ={RequestMethod.POST,RequestMethod.GET})
	public String list(RpUserInfo rpUserInfo,PageParam pageParam, Model model) {
		PageBean pageBean = rpUserInfoService.listPage(pageParam, rpUserInfo);
		model.addAttribute("pageBean", pageBean);
        model.addAttribute("pageParam", pageParam);
        model.addAttribute("rpUserInfo",rpUserInfo);
		return "user/info/list";
	}
	
	/**
	 * 函数功能说明 ：跳转添加
	 * 
	 * @参数： @return
	 * @return String
	 * @throws
	 */
	@RequiresPermissions("user:userInfo:add")
	@RequestMapping(value = "/addUI", method = RequestMethod.GET)
	public String addUI() {
		
		return "user/info/add";
	}
	
	/**
	 * 函数功能说明 ： 保存
	 * 
	 * @参数： @return
	 * @return String
	 * @throws
	 */
	@RequiresPermissions("user:userInfo:add")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Model model,@RequestParam("userName") String userName,@RequestParam("mobile") String mobile,@RequestParam("password") String password,DwzAjax dwz) {
		rpUserInfoService.registerOffline(userName, mobile, password);
		dwz.setStatusCode(DWZ.SUCCESS);
		dwz.setMessage(DWZ.SUCCESS_MSG);
		model.addAttribute("dwz", dwz);
		return DWZ.AJAX_DONE;
	}
	
	/**
	 * 函数功能说明 ： 查询用户信息 查找带回
	 * 
	 * @参数： @return
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/lookupList", method ={RequestMethod.POST,RequestMethod.GET})
	public String lookupList(RpUserInfo rpUserInfo,PageParam pageParam, Model model) {
		PageBean pageBean = rpUserInfoService.listPage(pageParam, rpUserInfo);
		model.addAttribute("pageBean", pageBean);
        model.addAttribute("pageParam", pageParam);
        model.addAttribute("rpUserInfo",rpUserInfo);
		return "user/info/lookupList";
	}

}
