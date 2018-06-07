package cn.ucaner.alpaca.pay.reconciliation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ucaner.alpaca.pay.common.page.PageBean;
import cn.ucaner.alpaca.pay.common.page.PageParam;
import cn.ucaner.alpaca.pay.reconciliation.dao.RpAccountCheckMistakeScratchPoolDao;
import cn.ucaner.alpaca.pay.reconciliation.entity.RpAccountCheckMistakeScratchPool;
import cn.ucaner.alpaca.pay.reconciliation.service.RpAccountCheckMistakeScratchPoolService;

/**
* @Package：cn.ucaner.alpaca.pay.reconciliation.service.impl   
* @ClassName：RpAccountCheckMistakeScratchPoolServiceImpl   
* @Description：   <p> 对账暂存池接口实现 </p>
* @Author： - wubin   
* @CreatTime：2018年5月11日 上午10:33:51   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
@Service("rpAccountCheckMistakeScratchPoolService")
public class RpAccountCheckMistakeScratchPoolServiceImpl implements RpAccountCheckMistakeScratchPoolService {

	@Autowired
	private RpAccountCheckMistakeScratchPoolDao rpAccountCheckMistakeScratchPoolDao;

	@Override
	public void saveData(RpAccountCheckMistakeScratchPool RpAccountCheckMistakeScratchPool) {
		rpAccountCheckMistakeScratchPoolDao.insert(RpAccountCheckMistakeScratchPool);
	}

	/**
	 * 批量保存记录
	 * 
	 * @param ScratchPoolList
	 */
	public void savaListDate(List<RpAccountCheckMistakeScratchPool> scratchPoolList) {
		for (RpAccountCheckMistakeScratchPool record : scratchPoolList) {
			rpAccountCheckMistakeScratchPoolDao.insert(record);
		}
	}

	@Override
	public void updateData(RpAccountCheckMistakeScratchPool RpAccountCheckMistakeScratchPool) {
		rpAccountCheckMistakeScratchPoolDao.update(RpAccountCheckMistakeScratchPool);
	}

	@Override
	public RpAccountCheckMistakeScratchPool getDataById(String id) {
		return rpAccountCheckMistakeScratchPoolDao.getById(id);
	}

	/**
	 * 获取分页数据
	 * 
	 * @param pageParam
	 * @return
	 */
	public PageBean listPage(PageParam pageParam, RpAccountCheckMistakeScratchPool rpAccountCheckMistakeScratchPool) {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		return rpAccountCheckMistakeScratchPoolDao.listPage(pageParam, paramMap);
	}

	/**
	 * 从缓冲池中删除数据
	 * 
	 * @param scratchPoolList
	 */
	public void deleteFromPool(List<RpAccountCheckMistakeScratchPool> scratchPoolList) {
		for (RpAccountCheckMistakeScratchPool record : scratchPoolList) {
			rpAccountCheckMistakeScratchPoolDao.delete(record.getId());
		}

	}

	/**
	 * 查询出缓存池中所有的数据
	 * 
	 * @return
	 */
	public List<RpAccountCheckMistakeScratchPool> listScratchPoolRecord(Map<String, Object> paramMap) {
		if (paramMap == null) {
			paramMap = new HashMap<String, Object>();
		}
		return rpAccountCheckMistakeScratchPoolDao.listByColumn(paramMap);
	}
}