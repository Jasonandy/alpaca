package cn.ucaner.alpaca.pay.controller.trade;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.ucaner.alpaca.pay.common.core.enums.PayTypeEnum;
import cn.ucaner.alpaca.pay.common.core.enums.PayWayEnum;
import cn.ucaner.alpaca.pay.common.core.page.PageBean;
import cn.ucaner.alpaca.pay.common.core.page.PageParam;
import cn.ucaner.alpaca.pay.trade.enums.TradeStatusEnum;
import cn.ucaner.alpaca.pay.trade.enums.TrxTypeEnum;
import cn.ucaner.alpaca.pay.trade.service.RpTradePaymentQueryService;
import cn.ucaner.alpaca.pay.trade.vo.PaymentOrderQueryParam;
import cn.ucaner.alpaca.pay.user.enums.FundInfoTypeEnum;

/**
* @Package：cn.ucner.alpaca.pay.controller.trade   
* @ClassName：TradeController   
* @Description：   <p> 交易管理</p>
* @Author： -    
* @CreatTime：2018年5月12日 下午12:29:56   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
@Controller
@RequestMapping("/trade")
public class TradeController {

    @Autowired
    private RpTradePaymentQueryService rpTradePaymentQueryService;
    @RequiresPermissions("trade:order:view")
    @RequestMapping(value = "/listPaymentOrder", method ={RequestMethod.POST,RequestMethod.GET})
    public String listPaymentOrder(HttpServletRequest request,PaymentOrderQueryParam paymentOrderQueryParam,PageParam pageParam, Model model) {
        PageBean pageBean = rpTradePaymentQueryService.listPaymentOrderPage(pageParam, paymentOrderQueryParam);
        model.addAttribute("pageBean", pageBean);
        model.addAttribute("pageParam", pageParam);
        model.addAttribute("paymentOrderQueryParam", paymentOrderQueryParam);//查询条件

        model.addAttribute("statusEnums", TradeStatusEnum.toMap());//状态
        model.addAttribute("payWayNameEnums", PayWayEnum.toMap());//支付方式
        model.addAttribute("payTypeNameEnums", PayTypeEnum.toMap());//支付类型
        model.addAttribute("fundIntoTypeEnums", FundInfoTypeEnum.toMap());//支付类型

        return "trade/listPaymentOrder";
    }

    @RequiresPermissions("trade:record:view")
    @RequestMapping(value = "/listPaymentRecord", method ={RequestMethod.POST,RequestMethod.GET})
    public String listPaymentRecord(HttpServletRequest request,PaymentOrderQueryParam paymentOrderQueryParam,PageParam pageParam, Model model) {
        PageBean pageBean = rpTradePaymentQueryService.listPaymentRecordPage(pageParam, paymentOrderQueryParam);
        model.addAttribute("pageBean", pageBean);
        model.addAttribute("pageParam", pageParam);
        model.addAttribute("paymentOrderQueryParam", paymentOrderQueryParam);

        model.addAttribute("statusEnums", TradeStatusEnum.toMap());//状态
        model.addAttribute("payWayNameEnums", PayWayEnum.toMap());//支付方式
        model.addAttribute("payTypeNameEnums", PayTypeEnum.toMap());//支付类型
        model.addAttribute("fundIntoTypeEnums", FundInfoTypeEnum.toMap());//支付类型
        model.addAttribute("trxTypeEnums", TrxTypeEnum.toMap());//支付类型
        return "trade/listPaymentRecord";
    }
}
