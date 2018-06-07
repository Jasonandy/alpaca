package cn.ucaner.alpaca.pay.trade.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.ucaner.alpaca.pay.common.dao.impl.BaseDaoImpl;
import cn.ucaner.alpaca.pay.trade.dao.RpTradePaymentOrderDao;
import cn.ucaner.alpaca.pay.trade.entity.RpTradePaymentOrder;

/**
* @Package：cn.ucaner.alpaca.pay.trade.dao.impl   
* @ClassName：RpTradePaymentOrderDaoImpl   
* @Description：   <p> 商户支付订单,dao层实现类</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:19:47   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
@Repository("rpTradePaymentOrderDao")
public class RpTradePaymentOrderDaoImpl extends BaseDaoImpl<RpTradePaymentOrder> implements RpTradePaymentOrderDao{


    /**
     * 根据商户编号及商户订单号获取支付订单信息
     * @param merchantNo    商户编号
     * @param merchantOrderNo   商户订单号
     * @return
     */
    @Override
    public RpTradePaymentOrder selectByMerchantNoAndMerchantOrderNo(String merchantNo, String merchantOrderNo) {
        Map<String , Object> paramMap = new HashMap<String , Object>();
        paramMap.put("merchantNo",merchantNo);
        paramMap.put("merchantOrderNo",merchantOrderNo);
        return super.getBy(paramMap);
    }

}
