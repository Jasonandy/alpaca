package cn.ucaner.alpaca.pay.reconciliation.service;

import java.util.List;
import java.util.Map;

import cn.ucaner.alpaca.pay.common.core.page.PageBean;
import cn.ucaner.alpaca.pay.common.core.page.PageParam;
import cn.ucaner.alpaca.pay.reconciliation.entity.RpAccountCheckBatch;

/**
* @Package：cn.ucaner.alpaca.pay.reconciliation.service   
* @ClassName：RpAccountCheckBatchService   
* @Description：   <p> 对账批次接口 . </p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:32:40   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public interface RpAccountCheckBatchService {

	/**
	 * 保存
	 */
	void saveData(RpAccountCheckBatch rpAccountCheckBatch);

	/**
	 * 更新
	 */
	void updateData(RpAccountCheckBatch rpAccountCheckBatch);

	/**
	 * 根据id获取数据
	 * 
	 * @param id
	 * @return
	 */
	RpAccountCheckBatch getDataById(String id);

	/**
	 * 获取分页数据
	 * 
	 * @param pageParam
	 * @return
	 */
	PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);

	/**
	 * 根据条件查询实体
	 * 
	 * @param paramMap
	 */
	public List<RpAccountCheckBatch> listBy(Map<String, Object> paramMap);

}