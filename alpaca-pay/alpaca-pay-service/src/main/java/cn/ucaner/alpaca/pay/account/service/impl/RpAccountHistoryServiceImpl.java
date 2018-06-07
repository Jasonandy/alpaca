package cn.ucaner.alpaca.pay.account.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ucaner.alpaca.pay.account.dao.RpAccountHistoryDao;
import cn.ucaner.alpaca.pay.account.entity.RpAccountHistory;
import cn.ucaner.alpaca.pay.account.service.RpAccountHistoryService;
import cn.ucaner.alpaca.pay.common.page.PageBean;
import cn.ucaner.alpaca.pay.common.page.PageParam;

/**
* @Package：cn.ucaner.alpaca.pay.account.service.impl   
* @ClassName：RpAccountHistoryServiceImpl   
* @Description：   <p> 账户历史service实现类</p>
* @Author： - Jason   
* @CreatTime：2018年5月10日 下午10:38:38   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
@Service("rpAccountHistoryService")
public class RpAccountHistoryServiceImpl implements RpAccountHistoryService{

	@Autowired
	private RpAccountHistoryDao rpAccountHistoryDao;
	
	@Override
	public void saveData(RpAccountHistory rpAccountHistory) {
		rpAccountHistoryDao.insert(rpAccountHistory);
	}

	@Override
	public void updateData(RpAccountHistory rpAccountHistory) {
		rpAccountHistoryDao.update(rpAccountHistory);
	}

	@Override
	public RpAccountHistory getDataById(String id) {
		return rpAccountHistoryDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, RpAccountHistory rpAccountHistory) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("accountNo", rpAccountHistory.getAccountNo());
		return rpAccountHistoryDao.listPage(pageParam, paramMap);
	}
}