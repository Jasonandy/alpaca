package cn.ucaner.alpaca.pay.trade.service;

import cn.ucaner.alpaca.pay.reconciliation.entity.RpAccountCheckMistake;

/**
* @Package：cn.ucaner.alpaca.pay.trade.service   
* @ClassName：RpTradeReconciliationService   
* @Description：   <p> 交易模块对账差错处理接口 </p>
* @Author： -    
* @CreatTime：2018年6月12日 上午9:30:14   
* @Modify By：   
* @ModifyTime：  2018年6月12日
* @Modify marker：   
* @version    V1.0
 */
public interface RpTradeReconciliationService {

	/**
	 * 平台成功，银行记录不存在，或者银行失败，以银行为准
	 * 
	 * @param trxNo
	 *            平台交易流水
	 */
	public void bankMissOrBankFailBaseBank(String trxNo);

	/**
	 * 银行成功，平台失败。
	 * 
	 * @param trxNo
	 *            平台交易流水
	 * @param bankTrxNo
	 *            银行返回流水
	 */
	public void platFailBankSuccess(String trxNo, String bankTrxNo);

	/**
	 * 处理金额不匹配异常(都是以银行数据为准才需要调整)
	 * 
	 * @param mistake
	 *            差错记录
	 * @param isBankMore
	 *            是否是银行金额多
	 */
	public void handleAmountMistake(RpAccountCheckMistake mistake, boolean isBankMore) ;

	/**
	 * 处理手续费不匹配差错（默认以银行为准）
	 * 
	 * @param mistake
	 */
	public void handleFeeMistake(RpAccountCheckMistake mistake);

}
