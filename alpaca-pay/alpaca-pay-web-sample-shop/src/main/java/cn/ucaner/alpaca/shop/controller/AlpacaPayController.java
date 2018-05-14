package cn.ucaner.alpaca.shop.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ucaner.alpaca.shop.utils.MerchantApiUtil;
import cn.ucaner.alpaca.shop.utils.PayConfigUtil;

/**
* @Package：cn.ucaner.alpaca.shop.controller   
* @ClassName：AlpacaPayController   
* @Description：   <p> 支付控制类</p>
* @Author： -    
* @CreatTime：2018年5月12日 下午3:24:37   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
@Controller
@RequestMapping(value = "/alpacaPay")
public class AlpacaPayController extends BaseController {
	
	private static final Log log = LogFactory.getLog(AlpacaPayController.class);

    @RequestMapping("/scanPay")
    public String scanPay(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {
        Map<String, Object> paramMap = new HashMap<String, Object>();

        String orderPriceStr = getString_UrlDecode_UTF8("orderPrice"); // 订单金额 , 单位:元
        paramMap.put("orderPrice", orderPriceStr);
        String payWayCode = getString_UrlDecode_UTF8("payWayCode"); // 支付方式编码 支付宝: ALIPAY  微信:WEIXIN
        paramMap.put("payWayCode", payWayCode);

        String orderNo = String.valueOf(System.currentTimeMillis());    // 订单编号
        paramMap.put("orderNo", orderNo);

        Date orderDate = new Date();//订单日期
        String orderDateStr = new SimpleDateFormat("yyyyMMdd").format(orderDate);// 订单日期
        paramMap.put("orderDate", orderDateStr);

        Date orderTime = new Date();//订单时间
        String orderTimeStr = new SimpleDateFormat("yyyyMMddHHmmss").format(orderTime);// 订单时间
        paramMap.put("orderTime", orderTimeStr);

        paramMap.put("payKey", PayConfigUtil.readConfig("payKey"));
        String productName = getString_UrlDecode_UTF8("productName"); // 商品名称
        paramMap.put("productName", productName);

        String orderIp = PayConfigUtil.readConfig("orderIp"); // 下单IP
        paramMap.put("orderIp", orderIp);

        String orderPeriodStr = PayConfigUtil.readConfig("orderPeriod"); // 订单有效期
        paramMap.put("orderPeriod", orderPeriodStr);
        String returnUrl = PayConfigUtil.readConfig("returnUrl"); // 页面通知返回url
        paramMap.put("returnUrl", returnUrl);
        String notifyUrl = PayConfigUtil.readConfig("notifyUrl"); // 后台消息通知Url
        paramMap.put("notifyUrl", notifyUrl);
        String remark = getString_UrlDecode_UTF8("remark"); // 支付备注
        paramMap.put("remark", remark);

        ////////////扩展字段,选填,原值返回///////////
        String field1 = "扩展字段1"; // 扩展字段1
        paramMap.put("field1", field1);
        String field2 = "扩展字段2"; // 扩展字段2
        paramMap.put("field2", field2);
        String field3 = "扩展字段3"; // 扩展字段3
        paramMap.put("field3", field3);
        String field4 = "扩展字段4"; // 扩展字段4
        paramMap.put("field4", field4);
        String field5 = "扩展字段5"; // 扩展字段5
        paramMap.put("field5", field5);

        /////签名及生成请求API的方法///
        String sign = MerchantApiUtil.getSign(paramMap, PayConfigUtil.readConfig("paySecret"));
        paramMap.put("sign", sign);

        String buildRequest = MerchantApiUtil.buildRequest(paramMap, "get", "确定", PayConfigUtil.readConfig("scanPayUrl"));

        model.addAttribute("payMessage", buildRequest);
        
        String logStr = String.format("ScanPay 扫码支付入参为:%s,支付方式为:%s ,订单号为:%s", buildRequest,payWayCode,orderNo);
        
        log.info("cn.ucaner.alpaca.shop.controller.AlpacaPayController Method:scanPay "+logStr);

        return "toPay";
    }

    @RequestMapping("/toF2FPay")
    public static String toF2FPay() {
        return "/f2fPay";
    }

    /**
     * 模拟商户F2F条码支付
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param model
     * @return
     */
    @RequestMapping("/f2fPay")
    public String f2fPay(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {
        Map<String, Object> paramMap = new HashMap<String, Object>();

        String orderPriceStr = getString_UrlDecode_UTF8("orderPrice"); // 订单金额 , 单位:元
        paramMap.put("orderPrice", orderPriceStr);
        String payWayCode = getString_UrlDecode_UTF8("payWayCode"); // 支付方式编码 支付宝: ALIPAY  微信:WEIXIN
        paramMap.put("payWayCode", payWayCode);

        String orderNo = String.valueOf(System.currentTimeMillis());    // 订单编号
        paramMap.put("orderNo", orderNo);

        Date orderDate = new Date();//订单日期
        String orderDateStr = new SimpleDateFormat("yyyyMMdd").format(orderDate);// 订单日期
        paramMap.put("orderDate", orderDateStr);

        Date orderTime = new Date();//订单时间
        String orderTimeStr = new SimpleDateFormat("yyyyMMddHHmmss").format(orderTime);// 订单时间
        paramMap.put("orderTime", orderTimeStr);

        paramMap.put("payKey", PayConfigUtil.readConfig("payKey"));
        String productName = getString_UrlDecode_UTF8("productName"); // 商品名称
        paramMap.put("productName", productName);

        String authCode = getString_UrlDecode_UTF8("authCode"); // 商品名称
        paramMap.put("authCode", authCode);

        String orderIp = PayConfigUtil.readConfig("orderIp"); // 下单IP
        paramMap.put("orderIp", orderIp);

        String remark = getString_UrlDecode_UTF8("remark"); // 支付备注
        paramMap.put("remark", remark);

        ////////////扩展字段,选填,原值返回///////////
        String field1 = "扩展字段1"; // 扩展字段1
        paramMap.put("field1", field1);
        String field2 = "扩展字段2"; // 扩展字段2
        paramMap.put("field2", field2);
        String field3 = "扩展字段3"; // 扩展字段3
        paramMap.put("field3", field3);
        String field4 = "扩展字段4"; // 扩展字段4
        paramMap.put("field4", field4);
        String field5 = "扩展字段5"; // 扩展字段5
        paramMap.put("field5", field5);

        /////签名及生成请求API的方法///
        String sign = MerchantApiUtil.getSign(paramMap, PayConfigUtil.readConfig("paySecret"));
        paramMap.put("sign", sign);

        String buildRequest = MerchantApiUtil.buildRequest(paramMap, "get", "确定", PayConfigUtil.readConfig("f2fPayUrl"));

        model.addAttribute("payMessage", buildRequest);
        
        String logStr = String.format("f2fPay 支付入参为:%s,支付方式为:%s ,订单号为:%s", buildRequest,payWayCode,orderNo);
        
        log.info("cn.ucaner.alpaca.shop.controller.AlpacaPayController Method:f2fPay "+logStr);

        return "toPay";
    }

    /**
     * 模拟小程序支付
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param model
     * @return
     */
    @RequestMapping("/programpay")
    public String programpay(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {
        Map<String, Object> paramMap = new HashMap<String, Object>();

        String orderPriceStr = getString_UrlDecode_UTF8("orderPrice"); // 订单金额 , 单位:元
        paramMap.put("orderPrice", orderPriceStr);
        String payWayCode = getString_UrlDecode_UTF8("payWayCode"); // 支付方式编码 支付宝: ALIPAY  微信:WEIXIN
        paramMap.put("payWayCode", payWayCode);

        String orderNo = String.valueOf(System.currentTimeMillis());    // 订单编号
        paramMap.put("orderNo", orderNo);

        Date orderDate = new Date();//订单日期
        String orderDateStr = new SimpleDateFormat("yyyyMMdd").format(orderDate);// 订单日期
        paramMap.put("orderDate", orderDateStr);

        Date orderTime = new Date();//订单时间
        String orderTimeStr = new SimpleDateFormat("yyyyMMddHHmmss").format(orderTime);// 订单时间
        paramMap.put("orderTime", orderTimeStr);

        paramMap.put("payKey", PayConfigUtil.readConfig("payKey"));
        String productName = getString_UrlDecode_UTF8("productName"); // 商品名称
        paramMap.put("productName", productName);

        String authCode = getString_UrlDecode_UTF8("openId"); // 商品名称
        paramMap.put("openId", authCode);

        String orderIp = PayConfigUtil.readConfig("orderIp"); // 下单IP
        paramMap.put("orderIp", orderIp);

        String remark = getString_UrlDecode_UTF8("remark"); // 支付备注
        paramMap.put("remark", remark);

        ////////////扩展字段,选填,原值返回///////////
        String field1 = "扩展字段1"; // 扩展字段1
        paramMap.put("field1", field1);
        String field2 = "扩展字段2"; // 扩展字段2
        paramMap.put("field2", field2);
        String field3 = "扩展字段3"; // 扩展字段3
        paramMap.put("field3", field3);
        String field4 = "扩展字段4"; // 扩展字段4
        paramMap.put("field4", field4);
        String field5 = "扩展字段5"; // 扩展字段5
        paramMap.put("field5", field5);

        /////签名及生成请求API的方法///
        String sign = MerchantApiUtil.getSign(paramMap, PayConfigUtil.readConfig("paySecret"));
        paramMap.put("sign", sign);

        //String buildRequest = MerchantApiUtil.buildRequest(paramMap, "get", "确定", PayConfigUtil.readConfig("programpayUrl"));
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(PayConfigUtil.readConfig("programpayUrl"));
        try {
            List<NameValuePair> list = new ArrayList<>();
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(),String.valueOf(entry.getValue())));
            }
            post.setEntity(new UrlEncodedFormEntity(list,"UTF-8"));
            HttpResponse httpResponse = httpClient.execute(post);
            String result = EntityUtils.toString(httpResponse.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        Map<String, Object> paramMap = new HashMap<String, Object>();

        paramMap.put("orderPrice", "0.11");
        paramMap.put("payWayCode", "WEIXIN");// 支付方式编码 支付宝: ALIPAY  微信:WEIXIN
        String orderNo = String.valueOf(System.currentTimeMillis());    // 订单编号
        paramMap.put("orderNo", orderNo);

        Date orderDate = new Date();//订单日期
        String orderDateStr = new SimpleDateFormat("yyyyMMdd").format(orderDate);// 订单日期
        paramMap.put("orderDate", orderDateStr);

        Date orderTime = new Date();//订单时间
        String orderTimeStr = new SimpleDateFormat("yyyyMMddHHmmss").format(orderTime);// 订单时间
        paramMap.put("orderTime", orderTimeStr);

        paramMap.put("payKey", PayConfigUtil.readConfig("payKey"));
        paramMap.put("productName", "test");

        String notifyUrl = "https://www.baidu.com"; // 后台消息通知Url
        paramMap.put("notifyUrl", notifyUrl);

        paramMap.put("openId", "okocOwGt2w6uasvHEakh3SlhjcT4");

        String orderIp = PayConfigUtil.readConfig("orderIp"); // 下单IP
        paramMap.put("orderIp", orderIp);

        paramMap.put("remark", "test");

        ////////////扩展字段,选填,原值返回///////////
        String field1 = "1"; // 扩展字段1
        paramMap.put("field1", field1);
        String field2 = "2"; // 扩展字段2
        paramMap.put("field2", field2);
        String field3 = "3"; // 扩展字段3
        paramMap.put("field3", field3);
        String field4 = "4"; // 扩展字段4
        paramMap.put("field4", field4);
        String field5 = "5"; // 扩展字段5
        paramMap.put("field5", field5);

        /////签名及生成请求API的方法///
        String sign = MerchantApiUtil.getSign(paramMap, PayConfigUtil.readConfig("paySecret"));
        paramMap.put("sign", sign);

        //String buildRequest = MerchantApiUtil.buildRequest(paramMap, "get", "确定", PayConfigUtil.readConfig("programpayUrl"));
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(PayConfigUtil.readConfig("programpayUrl"));
        try {
            List<NameValuePair> list = new ArrayList<>();
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(),String.valueOf(entry.getValue())));
            }
            post.setEntity(new UrlEncodedFormEntity(list,"UTF-8"));
            HttpResponse httpResponse = httpClient.execute(post);
            String result = EntityUtils.toString(httpResponse.getEntity());
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // System.out.println(buildRequest);
    }

}
