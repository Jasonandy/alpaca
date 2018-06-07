package cn.ucaner.alpaca.pay.reconciliation.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ucaner.alpaca.pay.common.page.PageBean;
import cn.ucaner.alpaca.pay.common.page.PageParam;
import cn.ucaner.alpaca.pay.reconciliation.dao.RpAccountCheckBatchDao;
import cn.ucaner.alpaca.pay.reconciliation.entity.RpAccountCheckBatch;
import cn.ucaner.alpaca.pay.reconciliation.service.RpAccountCheckBatchService;

/**
* @Package：cn.ucaner.alpaca.pay.reconciliation.service.impl   
* @ClassName：RpAccountCheckBatchServiceImpl   
* @Description：   <p> 对账批次接口实现 . </p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:34:24   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
@Service("rpAccountCheckBatchService")
public class RpAccountCheckBatchServiceImpl implements RpAccountCheckBatchService {

	@Autowired
	private RpAccountCheckBatchDao rpAccountCheckBatchDao;

	@Override
	public void saveData(RpAccountCheckBatch rpAccountCheckBatch) {
		rpAccountCheckBatchDao.insert(rpAccountCheckBatch);
	}

	@Override
	public void updateData(RpAccountCheckBatch rpAccountCheckBatch) {
		rpAccountCheckBatchDao.update(rpAccountCheckBatch);
	}

	@Override
	public RpAccountCheckBatch getDataById(String id) {
		return rpAccountCheckBatchDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {

		return rpAccountCheckBatchDao.listPage(pageParam, paramMap);
	}

	/**
	 * 根据条件查询实体
	 * 
	 * @param paramMap
	 */
	public List<RpAccountCheckBatch> listBy(Map<String, Object> paramMap) {
		return rpAccountCheckBatchDao.listBy(paramMap);
	}

}