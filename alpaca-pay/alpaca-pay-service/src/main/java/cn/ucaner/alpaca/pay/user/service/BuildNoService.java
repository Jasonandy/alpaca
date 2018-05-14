package cn.ucaner.alpaca.pay.user.service;

/**
* @Package：cn.ucaner.alpaca.pay.user.service   
* @ClassName：BuildNoService   
* @Description：   <p> 生成编号service接口</p>
* @Author： -    
* @CreatTime：2018年5月10日 下午11:11:53   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public interface BuildNoService {

	/** 获取用户编号 **/
	String buildUserNo();

	/** 获取账户编号 **/
	String buildAccountNo();

	/** 获取支付流水号 **/
	String buildTrxNo();

	/** 获取银行订单号 **/
	String buildBankOrderNo();

	/** 获取对账批次号 **/
	String buildReconciliationNo();

}
