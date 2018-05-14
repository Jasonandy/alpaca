package cn.ucaner.alpaca.pay.trade.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.ucaner.alpaca.pay.common.core.dao.impl.BaseDaoImpl;
import cn.ucaner.alpaca.pay.trade.dao.RpTradePaymentRecordDao;
import cn.ucaner.alpaca.pay.trade.entity.RpTradePaymentRecord;
import cn.ucaner.alpaca.pay.trade.enums.TradeStatusEnum;

/**
* @Package：cn.ucaner.alpaca.pay.trade.dao.impl   
* @ClassName：RpTradePaymentRecordDaoImpl   
* @Description：   <p> 商户支付记录,dao层实现类</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:19:33   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
@Repository("rpTradePaymentRecordDao")
public class RpTradePaymentRecordDaoImpl extends BaseDaoImpl<RpTradePaymentRecord> implements RpTradePaymentRecordDao {

	/**
	 * 根据银行订单号获取支付信息
	 *
	 * @param bankOrderNo
	 * @return
	 */
	@Override
	public RpTradePaymentRecord getByBankOrderNo(String bankOrderNo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bankOrderNo", bankOrderNo);
		return super.getBy(paramMap);
	}

	/**
	 * 根据商户编号及商户订单号获取支付结果
	 *
	 * @param merchantNo
	 * @param merchantOrderNo
	 * @return
	 */
	@Override
	public RpTradePaymentRecord getSuccessRecordByMerchantNoAndMerchantOrderNo(String merchantNo, String merchantOrderNo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("status", TradeStatusEnum.SUCCESS.name());
		paramMap.put("merchantNo", merchantNo);
		paramMap.put("merchantOrderNo", merchantOrderNo);
		return super.getBy(paramMap);
	}

	/**
	 * 根据支付流水号查询支付记录
	 * 
	 * @param trxNo
	 * @return
	 */
	public RpTradePaymentRecord getByTrxNo(String trxNo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("trxNo", trxNo);
		return super.getBy(paramMap);
	}
	
	public List<Map<String, String>> getPaymentReport(String merchantNo){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("status", TradeStatusEnum.SUCCESS.name());
		paramMap.put("merchantNo", merchantNo);
		return super.getSqlSession().selectList(getStatement("getPaymentReport"),paramMap);
	}

	public List<Map<String, String>> getPayWayReport(String merchantNo){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("status", TradeStatusEnum.SUCCESS.name());
		paramMap.put("merchantNo", merchantNo);
		return super.getSqlSession().selectList(getStatement("getPayWayReport"),paramMap);
	}

}
