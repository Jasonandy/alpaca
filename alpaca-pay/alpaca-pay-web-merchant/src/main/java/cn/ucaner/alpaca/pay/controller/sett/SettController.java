package cn.ucaner.alpaca.pay.controller.sett;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.ucaner.alpaca.pay.account.service.RpAccountService;
import cn.ucaner.alpaca.pay.account.service.RpSettHandleService;
import cn.ucaner.alpaca.pay.account.service.RpSettQueryService;
import cn.ucaner.alpaca.pay.common.core.page.PageBean;
import cn.ucaner.alpaca.pay.common.core.page.PageParam;
import cn.ucaner.alpaca.pay.common.core.utils.StringUtil;
import cn.ucaner.alpaca.pay.controller.common.BaseController;
import cn.ucaner.alpaca.pay.controller.common.ConstantClass;
import cn.ucaner.alpaca.pay.controller.common.JSONParam;
import cn.ucaner.alpaca.pay.user.entity.RpUserInfo;

/**
* @Package：cn.ucaner.alpaca.pay.controller.sett   
* @ClassName：SettController   
* @Description：   <p> 结算信息 </p>
* @Author： -    
* @CreatTime：2018年5月12日 下午2:24:52   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
@Controller
@RequestMapping("/merchant/sett")
public class SettController extends BaseController {
	
	private static final Log LOG = LogFactory.getLog(SettController.class);
	@Autowired
	private RpSettHandleService rpSettHandleService;
	@Autowired
	private RpSettQueryService rpSettQueryService;
	@Autowired
	private RpAccountService rpAccountService;

	/**
	 * 函数功能说明 ： 查询结算记录
	 * 
	 * @参数： @return
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/getSettList", method = { RequestMethod.POST, RequestMethod.GET })
	public String getAccountInfo(HttpServletRequest request) {

		return "sett/list";
	}

	@RequestMapping(value = "/ajaxSettList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String ajaxPaymentList(HttpServletRequest request, @RequestBody JSONParam[] params) throws IllegalAccessException, InvocationTargetException {
		// convertToMap定义于父类，将参数数组中的所有元素加入一个HashMap
		HashMap<String, String> paramMap = convertToMap(params);
		String sEcho = paramMap.get("sEcho");
		int start = Integer.parseInt(paramMap.get("iDisplayStart"));
		int length = Integer.parseInt(paramMap.get("iDisplayLength"));
		String beginDate = paramMap.get("beginDate");
		String endDate = paramMap.get("endDate");
		if (StringUtil.isEmpty(beginDate) && !StringUtil.isEmpty(endDate)) {
			beginDate = endDate;
		}
		if (StringUtil.isEmpty(endDate) && !StringUtil.isEmpty(beginDate)) {
			endDate = beginDate;
		}
		String merchantRequestNo = paramMap.get("merchantRequestNo");
		String status = paramMap.get("status");
		RpUserInfo userInfo = (RpUserInfo) request.getSession().getAttribute(ConstantClass.USER);

		// 页面当前页需要显示的记录数据
		PageParam pageParam = new PageParam(start / length + 1, length);
		Map<String, Object> settMap = new HashMap<String, Object>();
		settMap.put("userNo", userInfo.getUserNo());
		settMap.put("settStatus", status);
		settMap.put("merchantRequestNo", merchantRequestNo);
		settMap.put("beginDate", beginDate);
		settMap.put("endDate", endDate);
		PageBean pageBean = rpSettQueryService.querySettRecordListPage(pageParam, settMap);
		
		Long count = Long.valueOf(pageBean.getTotalCount() + "");

		String jsonString = JSON.toJSONString(pageBean.getRecordList());
		String json = "{\"sEcho\":" + sEcho + ",\"iTotalRecords\":" + count.longValue() + ",\"iTotalDisplayRecords\":" + count.longValue() + ",\"aaData\":" + jsonString + "}";
		return json;
	}

}
