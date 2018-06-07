package cn.ucaner.alpaca.pay.account.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.ucaner.alpaca.pay.account.dao.RpAccountHistoryDao;
import cn.ucaner.alpaca.pay.account.entity.RpAccountHistory;
import cn.ucaner.alpaca.pay.account.vo.DailyCollectAccountHistoryVo;
import cn.ucaner.alpaca.pay.common.dao.impl.BaseDaoImpl;


/**
* @Package：cn.ucaner.alpaca.pay.account.dao.impl   
* @ClassName：RpAccountHistoryDaoImpl   
* @Description：   <p> 账户历史dao实现类</p>
* @Author： - Jason   
* @CreatTime：2018年5月10日 下午10:33:49   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
@Repository
public class RpAccountHistoryDaoImpl  extends BaseDaoImpl<RpAccountHistory> implements RpAccountHistoryDao{
	
	public List<RpAccountHistory> listPageByParams(Map<String, Object> params){
		return this.listBy(params);
	}
	
	public List<DailyCollectAccountHistoryVo> listDailyCollectAccountHistoryVo(Map<String, Object> params){
		return this.getSessionTemplate().selectList(getStatement("listDailyCollectAccountHistoryVo"), params);
	}

	/** 更新账户风险预存期外的账户历史记录记为结算完成 **/
	public void updateCompleteSettTo100(Map<String, Object> params){
		this.getSessionTemplate().update(getStatement("updateCompleteSettTo100"), params);
	}
}