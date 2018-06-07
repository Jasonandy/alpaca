package cn.ucaner.alpaca.pay.reconciliation.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ucaner.alpaca.pay.common.page.PageBean;
import cn.ucaner.alpaca.pay.common.page.PageParam;
import cn.ucaner.alpaca.pay.reconciliation.dao.RpAccountCheckMistakeDao;
import cn.ucaner.alpaca.pay.reconciliation.entity.RpAccountCheckMistake;
import cn.ucaner.alpaca.pay.reconciliation.service.RpAccountCheckMistakeService;

/**
* @Package：cn.ucaner.alpaca.pay.reconciliation.service.impl   
* @ClassName：RpAccountCheckMistakeServiceImpl   
* @Description：   <p> 对账批次接口实现 . </p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:33:36   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
@Service("rpAccountCheckMistakeService")
public class RpAccountCheckMistakeServiceImpl implements RpAccountCheckMistakeService {

	@Autowired
	private RpAccountCheckMistakeDao rpAccountCheckMistakeDao;

	@Override
	public void saveData(RpAccountCheckMistake rpAccountCheckMistake) {
		rpAccountCheckMistakeDao.insert(rpAccountCheckMistake);
	}

	@Override
	public void updateData(RpAccountCheckMistake rpAccountCheckMistake) {
		rpAccountCheckMistakeDao.update(rpAccountCheckMistake);
	}

	@Override
	public RpAccountCheckMistake getDataById(String id) {
		return rpAccountCheckMistakeDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return rpAccountCheckMistakeDao.listPage(pageParam, paramMap);
	}

	/**
	 * 批量保存差错记录
	 * 
	 * @param mistakeList
	 */
	public void saveListDate(List<RpAccountCheckMistake> mistakeList) {
		for (RpAccountCheckMistake mistake : mistakeList) {
			rpAccountCheckMistakeDao.insert(mistake);
		}

	}
}