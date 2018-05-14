package cn.ucaner.alpaca.pay.app.settlement.biz;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.ucaner.alpaca.pay.account.entity.RpAccount;
import cn.ucaner.alpaca.pay.account.service.RpSettHandleService;
import cn.ucaner.alpaca.pay.user.entity.RpUserPayConfig;
import cn.ucaner.alpaca.pay.user.service.RpUserPayConfigService;

/**
* @Package：cn.ucaner.alpaca.pay.app.settlement.biz   
* @ClassName：DailySettCollectBiz   
* @Description：   <p> 每日待结算数据汇总. </p>
* @Author： -    
* @CreatTime：2018年5月12日 下午12:10:24   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
@Component("dailySettCollectBiz")
public class DailySettCollectBiz {

	private static final Log LOG = LogFactory.getLog(DailySettCollectBiz.class);

	@Autowired
	private RpSettHandleService rpSettHandleService;
	
	@Autowired
	private RpUserPayConfigService rpUserPayConfigService;

	/**
	 * 按单个商户发起每日待结算数据统计汇总.<br/>
	 * 
	 * @param userEnterprise
	 *            单个商户的结算规则.<br/>
	 * @param endDate
	 *            统计日期 ==定时器执行的日期<br/>
	 */
	public void dailySettCollect(RpAccount rpAccount, Date endDate) {
		LOG.info("按单个商户发起每日待结算数据统计汇总");
		RpUserPayConfig rpUserPayConfig = rpUserPayConfigService.getByUserNo(rpAccount.getUserNo());
		if (rpUserPayConfig == null) {
			LOG.info("userNo:" + rpAccount.getUserNo() + ":没有商家设置信息，不进行汇总");
			return;
		}
		int riskDay = rpUserPayConfig.getRiskDay();
		rpSettHandleService.dailySettlementCollect(rpUserPayConfig.getUserNo(), endDate, riskDay,rpUserPayConfig.getUserName());
	}
}
