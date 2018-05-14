package cn.ucaner.alpaca.pay.reconciliation.service;

import java.util.List;
import java.util.Map;

import cn.ucaner.alpaca.pay.common.core.page.PageBean;
import cn.ucaner.alpaca.pay.common.core.page.PageParam;
import cn.ucaner.alpaca.pay.reconciliation.entity.RpAccountCheckMistakeScratchPool;

/**
* @Package：cn.ucaner.alpaca.pay.reconciliation.service   
* @ClassName：RpAccountCheckMistakeScratchPoolService   
* @Description：   <p> 对账暂存池接口 .</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:32:13   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public interface RpAccountCheckMistakeScratchPoolService {

	/**
	 * 保存
	 */
	void saveData(RpAccountCheckMistakeScratchPool rpAccountCheckMistakeScratchPool);

	/**
	 * 批量保存记录
	 * 
	 * @param ScratchPoolList
	 */
	public void savaListDate(List<RpAccountCheckMistakeScratchPool> scratchPoolList);

	/**
	 * 更新
	 */
	void updateData(RpAccountCheckMistakeScratchPool rpAccountCheckMistakeScratchPool);

	/**
	 * 根据id获取数据
	 * 
	 * @param id
	 * @return
	 */
	RpAccountCheckMistakeScratchPool getDataById(String id);

	/**
	 * 获取分页数据
	 * 
	 * @param pageParam
	 * @return
	 */
	PageBean listPage(PageParam pageParam, RpAccountCheckMistakeScratchPool rpAccountCheckMistakeScratchPool);

	/**
	 * 从缓冲池中删除数据
	 * 
	 * @param scratchPoolList
	 */
	void deleteFromPool(List<RpAccountCheckMistakeScratchPool> scratchPoolList);

	/**
	 * 查询出缓存池中所有的数据
	 * 
	 * @return
	 */
	List<RpAccountCheckMistakeScratchPool> listScratchPoolRecord(Map<String, Object> paramMap);

}