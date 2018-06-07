package cn.ucaner.alpaca.pay.account.service;

import cn.ucaner.alpaca.pay.account.entity.RpAccountHistory;
import cn.ucaner.alpaca.pay.common.page.PageBean;
import cn.ucaner.alpaca.pay.common.page.PageParam;

/**
* @Package：cn.ucaner.alpaca.pay.account.service   
* @ClassName：RpAccountHistoryService   
* @Description：   <p> 账户历史service接口</p>
* @Author： - Jason   
* @CreatTime：2018年5月10日 下午10:39:15   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public interface RpAccountHistoryService{
	
	/**
	 * 保存
	 */
	void saveData(RpAccountHistory rpAccountHistory);

	/**
	 * 更新
	 */
	void updateData(RpAccountHistory rpAccountHistory);

	/**
	 * 根据id获取数据
	 * 
	 * @param id
	 * @return
	 */
	RpAccountHistory getDataById(String id);
	

	/**
	 * 获取分页数据
	 * 
	 * @param pageParam
	 * @return
	 */
	PageBean listPage(PageParam pageParam, RpAccountHistory rpAccountHistory);
	
}