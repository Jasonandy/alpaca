package cn.ucaner.alpaca.pay.account.service;

import java.math.BigDecimal;

import cn.ucaner.alpaca.pay.account.entity.RpAccount;
import cn.ucaner.alpaca.pay.common.exception.BizException;

/**
* @Package：cn.ucaner.alpaca.pay.account.service   
* @ClassName：RpAccountTransactionService   
* @Description：   <p> 账户操作service接口</p>
* @Author： - Jason   
* @CreatTime：2018年5月10日 下午10:40:25   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public interface RpAccountTransactionService {

	/** 加款:有银行流水 **/
	RpAccount creditToAccount(String userNo, BigDecimal amount, String requestNo,String bankTrxNo, String trxType, String remark) throws BizException;

	/** 减款 :有银行流水**/
	RpAccount debitToAccount(String userNo, BigDecimal amount, String requestNo,String bankTrxNo, String trxType, String remark) throws BizException;
	
	/** 加款 **/
	RpAccount creditToAccount(String userNo, BigDecimal amount, String requestNo, String trxType, String remark) throws BizException;

	/** 减款 **/
	RpAccount debitToAccount(String userNo, BigDecimal amount, String requestNo, String trxType, String remark) throws BizException;


	/** 冻结 **/
	RpAccount freezeAmount(String userNo, BigDecimal freezeAmount) throws BizException;

	/** 结算成功：解冻+减款 **/
	RpAccount unFreezeAmount(String userNo, BigDecimal amount, String requestNo, String trxType, String remark) throws BizException;
	
	/** 结算失败：解冻 **/
	RpAccount unFreezeSettAmount(String userNo, BigDecimal amount) throws BizException;

	/** 更新账户历史中的结算状态，并且累加可结算金额 **/
	void settCollectSuccess(String accountNo, String collectDate, int riskDay, BigDecimal totalAmount) throws BizException;

}