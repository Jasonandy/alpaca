package cn.ucaner.alpaca.pay.app.settlement.scheduled;


/**
* @Package：cn.ucaner.alpaca.pay.app.settlement.scheduled   
* @ClassName：SettScheduled   
* @Description：   <p> 结算定时任务接口.</p>
* @Author： -    
* @CreatTime：2018年5月12日 下午12:08:50   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
public interface SettScheduled {

	/**
	 * 发起每日待结算数据汇总.
	 */
	public void launchDailySettCollect();
	
	/**
	 * 发起定期自动结算.
	 */
	public void launchAutoSett();

}
