package cn.ucaner.alpaca.pay.account.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ucaner.alpaca.pay.account.dao.RpAccountDao;
import cn.ucaner.alpaca.pay.account.entity.RpAccount;
import cn.ucaner.alpaca.pay.account.service.RpAccountService;
import cn.ucaner.alpaca.pay.common.page.PageBean;
import cn.ucaner.alpaca.pay.common.page.PageParam;

/**
* @Package：cn.ucaner.alpaca.pay.account.service.impl   
* @ClassName：RpAccountServiceImpl   
* @Description：   <p> 账户service实现类</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午9:35:20   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
@Service("rpAccountService")
public class RpAccountServiceImpl implements RpAccountService{

	@Autowired
	private RpAccountDao rpAccountDao;
	
	@Override
	public void saveData(RpAccount rpAccount) {
		rpAccountDao.insert(rpAccount);
	}

	@Override
	public void updateData(RpAccount rpAccount) {
		rpAccountDao.update(rpAccount);
	}

	@Override
	public RpAccount getDataById(String id) {
		return rpAccountDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, RpAccount rpAccount) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("accountNo", rpAccount.getAccountNo());
		return rpAccountDao.listPage(pageParam, paramMap);
	}
	
	@Override
	public RpAccount getDataByUserNo(String userNo){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userNo", userNo);
		return rpAccountDao.getBy(paramMap);
	}
}