package cn.ucaner.alpaca.pay.account.dao;

import java.util.List;
import java.util.Map;

import cn.ucaner.alpaca.pay.account.entity.RpAccountHistory;
import cn.ucaner.alpaca.pay.account.vo.DailyCollectAccountHistoryVo;
import cn.ucaner.alpaca.pay.common.dao.BaseDao;

/**
* @Package：cn.ucaner.alpaca.pay.account.dao   
* @ClassName：RpAccountHistoryDao   
* @Description：   <p> 账户历史dao</p>
* @Author： - Jason   
* @CreatTime：2018年5月10日 下午10:31:33   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public interface RpAccountHistoryDao  extends BaseDao<RpAccountHistory> {
	
	List<RpAccountHistory> listPageByParams(Map<String, Object> params);
	
	List<DailyCollectAccountHistoryVo> listDailyCollectAccountHistoryVo(Map<String, Object> params);

	/** 更新账户风险预存期外的账户历史记录记为结算完成 **/
	void updateCompleteSettTo100(Map<String, Object> params);
}