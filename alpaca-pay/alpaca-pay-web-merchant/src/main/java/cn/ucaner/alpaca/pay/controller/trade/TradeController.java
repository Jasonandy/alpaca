package cn.ucaner.alpaca.pay.controller.trade;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.ucaner.alpaca.pay.common.page.PageBean;
import cn.ucaner.alpaca.pay.common.page.PageParam;
import cn.ucaner.alpaca.pay.controller.common.BaseController;
import cn.ucaner.alpaca.pay.controller.common.ConstantClass;
import cn.ucaner.alpaca.pay.controller.common.JSONParam;
import cn.ucaner.alpaca.pay.trade.enums.TradeStatusEnum;
import cn.ucaner.alpaca.pay.trade.service.RpTradePaymentQueryService;
import cn.ucaner.alpaca.pay.trade.vo.PaymentOrderQueryParam;
import cn.ucaner.alpaca.pay.user.entity.RpUserInfo;


/**
* @Package：cn.ucaner.alpaca.pay.controller.trade   
* @ClassName：TradeController   
* @Description：   <p> TradeController 交易控制器 </p>
* @Author： -    
* @CreatTime：2018年5月12日 下午2:25:24   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
@Controller
@RequestMapping("/merchant/trade")
public class TradeController extends BaseController {

    @Autowired
    private RpTradePaymentQueryService rpTradePaymentQueryService;
    

    @RequestMapping(value = "/getPaymentList", method ={RequestMethod.POST,RequestMethod.GET})
    public String getPaymentList(HttpServletRequest request,Model model) {
		return "trade/order";
    }
    
    @RequestMapping(value = "/ajaxPaymentList", method ={RequestMethod.POST,RequestMethod.GET})     
    @ResponseBody
    public String ajaxPaymentList(HttpServletRequest request,@RequestBody JSONParam[] params) throws IllegalAccessException, InvocationTargetException {  
        //convertToMap定义于父类，将参数数组中的所有元素加入一个HashMap     
        HashMap<String, String> paramMap = convertToMap(params);     
        String sEcho = paramMap.get("sEcho");     
        int start = Integer.parseInt(paramMap.get("iDisplayStart"));     
        int length = Integer.parseInt(paramMap.get("iDisplayLength"));     
        RpUserInfo userInfo = (RpUserInfo)request.getSession().getAttribute(ConstantClass.USER);
             
        //customerService.search返回的第一个元素是满足查询条件的记录总数，后面的是     
        //页面当前页需要显示的记录数据   
		PageParam pageParam = new PageParam(start/length+1, length);
		PaymentOrderQueryParam param = new PaymentOrderQueryParam();
		param.setMerchantNo(userInfo.getUserNo());
		param.setStatus(TradeStatusEnum.SUCCESS.name());
        PageBean pageBean = rpTradePaymentQueryService.listPaymentRecordPage(pageParam, param);
        Long count = Long.valueOf(pageBean.getTotalCount()+"");     
             
        String jsonString = JSON.toJSONString(pageBean.getRecordList());
        String json = "{\"sEcho\":" + sEcho + ",\"iTotalRecords\":" + count.longValue() + ",\"iTotalDisplayRecords\":" + count.longValue() + ",\"aaData\":" + jsonString + "}";  
        return json;   
    }    
    
    @RequestMapping(value = "/ajaxPaymentReport", method ={RequestMethod.POST,RequestMethod.GET})     
    @ResponseBody
    public List ajaxPaymentReport(HttpServletRequest request){     
        RpUserInfo userInfo = (RpUserInfo)request.getSession().getAttribute(ConstantClass.USER);
             
        List<Map<String, String>> paymentReport = rpTradePaymentQueryService.getPaymentReport(userInfo.getUserNo());
        String jsonString = JSON.toJSONString(paymentReport);
        System.out.println(jsonString);
        return paymentReport;
    } 
}
