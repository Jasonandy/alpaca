package cn.ucaner.alpaca.pay.app.settlement.scheduled.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.ucaner.alpaca.pay.account.entity.RpAccount;
import cn.ucaner.alpaca.pay.account.service.RpAccountQueryService;
import cn.ucaner.alpaca.pay.app.settlement.biz.SettBiz;
import cn.ucaner.alpaca.pay.app.settlement.scheduled.SettScheduled;

/**
* @Package：cn.ucaner.alpaca.pay.app.settlement.scheduled.impl   
* @ClassName：SettScheduledImpl   
* @Description：   <p> 结算定时任务实现. </p>
* @Author： -    
* @CreatTime：2018年5月12日 下午12:09:10   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
@Component("settScheduled")
public class SettScheduledImpl implements SettScheduled {

	@Autowired
	private SettBiz settBiz;
	
	@Autowired
	private RpAccountQueryService rpAccountQueryService;

	/**
	 * 发起每日待结算数据汇总.
	 */
	public void launchDailySettCollect() {
		// 查询所有需要跑批的商户账户
		List<RpAccount> list = rpAccountQueryService.listAll();
		Date endDate = new Date();
		settBiz.launchDailySettCollect(list, endDate); // 统计数据
	}

	/**
	 * 发起定期自动结算.
	 */
	public void launchAutoSett() {
		// 查询所有需要跑批的商户账户
		List<RpAccount> list = rpAccountQueryService.listAll();
		settBiz.launchAutoSett(list);
	}

}
