package cn.ucaner.alpaca.pay.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @Package：cn.ucaner.alpaca.pay.gateway.controller  
* @ClassName：MerchantOrderQueryController   
* @Description：   <p> 商户查询订单结果 </p>
* @Author： -    
* @CreatTime：2018年5月11日 下午1:46:11   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
@Controller
@RequestMapping("merchantOrderQuery")
public class MerchantOrderQueryController {

    @RequestMapping
    public void singleOrderQuery(HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse){

    }
}
