package cn.ucaner.alpaca.pay.trade.dao;

import java.util.List;
import java.util.Map;

import cn.ucaner.alpaca.pay.common.core.dao.BaseDao;
import cn.ucaner.alpaca.pay.trade.entity.RpTradePaymentRecord;

/**
* @Package：cn.ucaner.alpaca.pay.trade.dao   
* @ClassName：RpTradePaymentRecordDao   
* @Description：   <p> 商户支付记录,dao层接口</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:18:44   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public interface RpTradePaymentRecordDao extends BaseDao<RpTradePaymentRecord>{

    /**
     * 根据银行订单号获取支付信息
     * @param bankOrderNo
     * @return
     */
    RpTradePaymentRecord getByBankOrderNo(String bankOrderNo);

    /**
     * 根据商户编号及商户订单号获取支付成功的结果
     * @param merchantNo
     * @param merchantOrderNo
     * @return
     */
    RpTradePaymentRecord getSuccessRecordByMerchantNoAndMerchantOrderNo(String merchantNo , String merchantOrderNo);

    /**
	 * 根据支付流水号查询支付记录
	 * 
	 * @param trxNo
	 * @return
	 */
	RpTradePaymentRecord getByTrxNo(String trxNo);

	List<Map<String, String>> getPaymentReport(String merchantNo);

	List<Map<String, String>> getPayWayReport(String merchantNo);

}
