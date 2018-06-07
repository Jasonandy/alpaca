package cn.ucaner.alpaca.pay.trade.dao;

import cn.ucaner.alpaca.pay.common.dao.BaseDao;
import cn.ucaner.alpaca.pay.trade.entity.RpTradePaymentOrder;

/**
* @Package：cn.ucaner.alpaca.pay.trade.dao   
* @ClassName：RpTradePaymentOrderDao   
* @Description：   <p> 商户支付订单,dao层接口 </p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:19:07   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public interface RpTradePaymentOrderDao  extends BaseDao<RpTradePaymentOrder>{

    /**
     * 根据商户编号及商户订单号获取支付订单信息
     * @param merchantNo
     * @param merchantOrderNo
     * @return
     */
    RpTradePaymentOrder selectByMerchantNoAndMerchantOrderNo(String merchantNo, String merchantOrderNo);

}
