package cn.ucaner.alpaca.pay.app.settlement.biz;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.ucaner.alpaca.pay.account.entity.RpAccount;
import cn.ucaner.alpaca.pay.account.service.RpSettHandleService;
import cn.ucaner.alpaca.pay.common.core.enums.PublicEnum;
import cn.ucaner.alpaca.pay.user.entity.RpUserPayConfig;
import cn.ucaner.alpaca.pay.user.service.RpUserPayConfigService;

/**
* @Package：cn.ucaner.alpaca.pay.app.settlement.biz   
* @ClassName：SettBiz   
* @Description：   <p> 结算业务逻辑类.</p>
* @Author： -    
* @CreatTime：2018年5月12日 下午12:09:43   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
@Component("settBiz")
public class SettBiz {

	private static final Log LOG = LogFactory.getLog(SettBiz.class);

	@Autowired
	private DailySettCollectBiz dailySettCollectBiz;
	@Autowired
	private RpUserPayConfigService rpUserPayConfigService;
	@Autowired
	private RpSettHandleService rpSettHandleService;

	/**
	 * 发起每日待结算数据统计汇总.<br/>
	 * 
	 * @param userEnterpriseList
	 *            结算商户.<br/>
	 * @param collectDate
	 *            统计截止日期(一般为昨天的日期)
	 */
	public void launchDailySettCollect(List<RpAccount> accountList, Date endDate) {

		if (accountList == null || accountList.isEmpty()) {
			return;
		}
		// 单商户发起结算
		for (RpAccount rpAccount : accountList) {
			try {
				LOG.debug(rpAccount.getUserNo() + ":开始汇总");
				dailySettCollectBiz.dailySettCollect(rpAccount, endDate);
				LOG.debug(rpAccount.getUserNo() + ":汇总结束");
			} catch (Exception e) {
				LOG.error(rpAccount.getUserNo()+":汇总异常", e);
			}
		}
	}

	/**
	 * 发起定期自动结算.<br/>
	 * 
	 * @param userEnterpriseList
	 *            结算商户.<br/>
	 */
	public void launchAutoSett(List<RpAccount> accountList) {
		if (accountList == null || accountList.isEmpty()) {
			return;
		}
		// 单商户发起结算
		for (RpAccount rpAccount : accountList) {
			try {
				RpUserPayConfig rpUserPayConfig = rpUserPayConfigService.getByUserNo(rpAccount.getUserNo());
				if (rpUserPayConfig == null) {
					LOG.info(rpAccount.getUserNo() + "没有商家设置信息，不进行结算");
					continue;
				}
				if (rpUserPayConfig.getIsAutoSett().equals(PublicEnum.YES.name())) {
					LOG.debug(rpAccount.getUserNo() + ":开始自动结算");
					rpSettHandleService.launchAutoSett(rpAccount.getUserNo());
					LOG.debug(rpAccount.getUserNo() + ":自动结算结束");
				} else {
					LOG.info(rpAccount.getUserNo() + ":非自动结算商家");
				}
			} catch (Exception e) {
				LOG.error("自动结算异常：" + rpAccount.getUserNo(), e);
			}
		}

	}
}
