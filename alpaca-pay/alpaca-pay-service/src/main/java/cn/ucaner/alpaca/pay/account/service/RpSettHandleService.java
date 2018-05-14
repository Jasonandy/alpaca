package cn.ucaner.alpaca.pay.account.service;

import java.math.BigDecimal;
import java.util.Date;

/**
* @Package：cn.ucaner.alpaca.pay.account.service   
* @ClassName：RpSettHandleService   
* @Description：   <p> 结算核心业务处理接口</p>
* @Author： - Jason   
* @CreatTime：2018年5月10日 下午10:40:50   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public interface RpSettHandleService {

	/**
	 * 按单个商户发起每日待结算数据统计汇总.<br/>
	 * 
	 * @param userNo
	 *            用户编号.
	 * @param endDate
	 *            汇总结束日期.
	 * @param riskDay
	 *            风险预存期.
	 * @param userName
	 *            用户名称
	 * @param codeNum
	 *            企业代号
	 */
	public void dailySettlementCollect(String userNo, Date endDate, int riskDay, String userName);

	/**
	 * 发起结算
	 * 
	 * @param userNo
	 * @param accountNo
	 * @param settAmount
	 * @param bankAccount
	 */
	public void launchSett(String userNo, BigDecimal settAmount);

	/**
	 * 发起自动结算
	 * 
	 * @param userNo 
	 */
	public void launchAutoSett(String userNo);
	
	
	/**
	 * 结算审核
	 */
	public void audit(String settId, String settStatus, String remark);
	
	/**
	 * 打款
	 */
	public void remit(String settId, String settStatus, String remark);
	
}