package cn.ucaner.alpaca.pay.controller.account;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.ucaner.alpaca.pay.account.entity.RpAccount;
import cn.ucaner.alpaca.pay.account.entity.RpAccountHistory;
import cn.ucaner.alpaca.pay.account.service.RpAccountHistoryService;
import cn.ucaner.alpaca.pay.account.service.RpAccountService;
import cn.ucaner.alpaca.pay.common.entity.ApiCommonResultVo;
import cn.ucaner.alpaca.pay.common.page.PageBean;
import cn.ucaner.alpaca.pay.common.page.PageParam;
import cn.ucaner.alpaca.pay.common.utils.EncryptUtil;
import cn.ucaner.alpaca.pay.controller.common.BaseController;
import cn.ucaner.alpaca.pay.controller.common.ConstantClass;
import cn.ucaner.alpaca.pay.controller.common.JSONParam;
import cn.ucaner.alpaca.pay.user.entity.RpPayWay;
import cn.ucaner.alpaca.pay.user.entity.RpUserInfo;
import cn.ucaner.alpaca.pay.user.entity.RpUserPayConfig;
import cn.ucaner.alpaca.pay.user.service.RpPayWayService;
import cn.ucaner.alpaca.pay.user.service.RpUserInfoService;
import cn.ucaner.alpaca.pay.user.service.RpUserPayConfigService;

/**
* @Package：cn.ucaner.alpaca.pay.controller.account   
* @ClassName：AccountController   
* @Description：   <p> AccountController </p>
* @Author： -    
* @CreatTime：2018年5月12日 下午2:17:45   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
@Controller
@RequestMapping("/merchant/account")
public class AccountController extends BaseController {
	@Autowired
	private RpUserPayConfigService rpUserPayConfigService;
	@Autowired
	private RpAccountService rpAccountService;
	@Autowired
	private RpPayWayService rpPayWayService;
	@Autowired
	private RpAccountHistoryService rpAccountHistoryService;
	@Autowired
	private RpUserInfoService rpUserInfoService;

	/**
	 * 函数功能说明 ： 查询用户信息
	 * 
	 * @参数： @return
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/getAccountInfo", method ={RequestMethod.POST,RequestMethod.GET})
	public String getAccountInfo(HttpServletRequest request) {
		RpUserInfo rpUserInfo = (RpUserInfo)request.getSession().getAttribute(ConstantClass.USER);
		String userNo = rpUserInfo.getUserNo();
		RpAccount rpAccount = rpAccountService.getDataByUserNo(userNo);
		RpUserPayConfig rpUserPayConfig = rpUserPayConfigService.getByUserNo(userNo);
		List<RpPayWay> rpPayWayList = new ArrayList<RpPayWay>(); 
		if(rpUserPayConfig != null){
			rpPayWayList = rpPayWayService.listByProductCode(rpUserPayConfig.getProductCode());
		}
		
		
		request.setAttribute("rpAccount", rpAccount);
		request.setAttribute("rpUserPayConfig", rpUserPayConfig);
		request.setAttribute("rpPayWayList", rpPayWayList);
		return "account/info";
	}
	
	   @RequestMapping(value = "/ajaxAccountInfo", method ={RequestMethod.POST,RequestMethod.GET})     
	    @ResponseBody
	    public String ajaxAccountInfo(HttpServletRequest request,@RequestBody JSONParam[] params) throws IllegalAccessException, InvocationTargetException {  
		    RpUserInfo rpUserInfo = (RpUserInfo)request.getSession().getAttribute(ConstantClass.USER);
			String userNo = rpUserInfo.getUserNo(); 
		   //convertToMap定义于父类，将参数数组中的所有元素加入一个HashMap     
	        HashMap<String, String> paramMap = convertToMap(params);     
	        String sEcho = paramMap.get("sEcho");     
	        int start = Integer.parseInt(paramMap.get("iDisplayStart"));     
	        int length = Integer.parseInt(paramMap.get("iDisplayLength"));     
	             
	        //customerService.search返回的第一个元素是满足查询条件的记录总数，后面的是     
	        //页面当前页需要显示的记录数据   
			PageParam pageParam = new PageParam(start/length+1, length);
			RpAccountHistory rpAccountHistory = new RpAccountHistory();
			rpAccountHistory.setUserNo(userNo);
			PageBean pageBean = rpAccountHistoryService.listPage(pageParam, rpAccountHistory);
	        Long count = Long.valueOf(pageBean.getTotalCount()+"");     
	             
	        String jsonString = JSON.toJSONString(pageBean.getRecordList());
	        String json = "{\"sEcho\":" + sEcho + ",\"iTotalRecords\":" + count.longValue() + ",\"iTotalDisplayRecords\":" + count.longValue() + ",\"aaData\":" + jsonString + "}";  
	        return json;   
	    }    
	   
	   @RequestMapping(value = "/savePassword", method ={RequestMethod.POST,RequestMethod.GET})     
	    @ResponseBody
	    public ApiCommonResultVo savePassword(HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {  
		    RpUserInfo rpUserInfo = (RpUserInfo)request.getSession().getAttribute(ConstantClass.USER);
		    String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");
			if(!EncryptUtil.encodeMD5String(oldPassword).equals(rpUserInfo.getPassword())){
				return new ApiCommonResultVo(-1, "操作失败，密码错误", "");
			}else{
				rpUserInfo.setPassword(EncryptUtil.encodeMD5String(newPassword));
				rpUserInfoService.updateData(rpUserInfo);
				request.getSession().setAttribute(ConstantClass.USER, rpUserInfo);
				return new ApiCommonResultVo(0, "操作成功", "");
			}
	    }  
	   
		@RequestMapping(value = "/savePayPass", method = { RequestMethod.POST, RequestMethod.GET })
		@ResponseBody
		public ApiCommonResultVo savePayPass(HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
			RpUserInfo rpUserInfo = (RpUserInfo) request.getSession().getAttribute(ConstantClass.USER);
			String oldPayPass = request.getParameter("oldPayPass");
			String newPayPass = request.getParameter("newPayPass");
			if (!EncryptUtil.encodeMD5String(oldPayPass).equals(rpUserInfo.getPayPwd())) {
				return new ApiCommonResultVo(-1, "操作失败，原支付密码错误", "");
			} else {
				rpUserInfo.setPayPwd(EncryptUtil.encodeMD5String(newPayPass));
				rpUserInfoService.updateData(rpUserInfo);
				request.getSession().setAttribute(ConstantClass.USER, rpUserInfo);
				return new ApiCommonResultVo(0, "操作成功", "");
			}
		}
}
