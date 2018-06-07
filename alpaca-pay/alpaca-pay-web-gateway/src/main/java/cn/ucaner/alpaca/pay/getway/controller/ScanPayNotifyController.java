package cn.ucaner.alpaca.pay.getway.controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ucaner.alpaca.pay.common.enums.PayWayEnum;
import cn.ucaner.alpaca.pay.common.utils.StringUtil;
import  cn.ucaner.alpaca.pay.trade.service.RpTradePaymentManagerService;
import  cn.ucaner.alpaca.pay.trade.utils.WeiXinPayUtils;
import  cn.ucaner.alpaca.pay.trade.utils.alipay.util.AliPayUtil;
import  cn.ucaner.alpaca.pay.trade.vo.OrderPayResultVo;

/**
* @Package：cn.ucaner.alpaca.pay.getway.controller   
* @ClassName：ScanPayNotifyController   
* @Description：   <p> 后台通知结果控制类 </p>
* @Author： -    
* @CreatTime：2018年5月11日 下午1:44:14   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
@Controller
@RequestMapping(value = "/scanPayNotify")
public class ScanPayNotifyController {

    @Autowired
    private RpTradePaymentManagerService rpTradePaymentManagerService;

    @RequestMapping("/notify/{payWayCode}")
    public void notify(@PathVariable("payWayCode") String  payWayCode , HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse) throws Exception {

        Map<String , String> notifyMap = new HashMap<String , String >();
        if (PayWayEnum.WEIXIN.name().equals(payWayCode)){
            InputStream inputStream = httpServletRequest.getInputStream();// 从request中取得输入流
            notifyMap = WeiXinPayUtils.parseXml(inputStream);
        }else if (PayWayEnum.ALIPAY.name().equals(payWayCode)){
            Map<String, String[]> requestParams = httpServletRequest.getParameterMap();
            notifyMap = AliPayUtil.parseNotifyMsg(requestParams);
        }

        String completeWeiXinScanPay = rpTradePaymentManagerService.completeScanPay(payWayCode ,notifyMap);
        if (!StringUtil.isEmpty(completeWeiXinScanPay)){
            if (PayWayEnum.WEIXIN.name().equals(payWayCode)){
                httpServletResponse.setContentType("text/xml");
            }
            httpServletResponse.getWriter().print(completeWeiXinScanPay);
        }
    }

    @RequestMapping("/result/{payWayCode}")
    public String result(@PathVariable("payWayCode") String payWayCode, HttpServletRequest httpServletRequest , Model model) throws Exception {

        Map<String,String> resultMap = new HashMap<String,String>();
        Map requestParams = httpServletRequest.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
//            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            valueStr = new String(valueStr);
            resultMap.put(name, valueStr);
        }

        OrderPayResultVo scanPayByResult = rpTradePaymentManagerService.completeScanPayByResult(payWayCode, resultMap);
        model.addAttribute("scanPayByResult",scanPayByResult);

        return "PayResult";
    }

}
