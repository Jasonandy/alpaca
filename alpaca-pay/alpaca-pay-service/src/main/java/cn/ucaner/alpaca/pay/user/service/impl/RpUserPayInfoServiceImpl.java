package cn.ucaner.alpaca.pay.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ucaner.alpaca.pay.common.page.PageBean;
import cn.ucaner.alpaca.pay.common.page.PageParam;
import cn.ucaner.alpaca.pay.user.dao.RpUserPayInfoDao;
import cn.ucaner.alpaca.pay.user.entity.RpUserPayInfo;
import cn.ucaner.alpaca.pay.user.service.RpUserPayInfoService;

/**
* @Package：cn.ucaner.alpaca.pay.user.service.impl   
* @ClassName：RpUserPayInfoServiceImpl   
* @Description：   <p> 用户第三方支付信息service实现类</p>
* @Author： -    
* @CreatTime：2018年5月10日 下午11:12:22   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
@Service("rpUserPayInfoService")
public class RpUserPayInfoServiceImpl implements RpUserPayInfoService{

	@Autowired
	private RpUserPayInfoDao rpUserPayInfoDao;
	
	@Override
	public void saveData(RpUserPayInfo rpUserPayInfo) {
		rpUserPayInfoDao.insert(rpUserPayInfo);
	}

	@Override
	public void updateData(RpUserPayInfo rpUserPayInfo) {
		rpUserPayInfoDao.update(rpUserPayInfo);
	}

	@Override
	public RpUserPayInfo getDataById(String id) {
		return rpUserPayInfoDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, RpUserPayInfo rpUserPayInfo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return rpUserPayInfoDao.listPage(pageParam, paramMap);
	}

	/**
	 * 通过商户编号获取商户支付配置信息
	 *
	 * @param userNO
	 * @return
	 */
	@Override
	public RpUserPayInfo getByUserNo(String userNo, String payWayCode) {
		return rpUserPayInfoDao.getByUserNo(userNo, payWayCode);
	}
}