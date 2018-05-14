package cn.ucaner.alpaca.pay.user.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ucaner.alpaca.pay.account.entity.RpAccount;
import cn.ucaner.alpaca.pay.account.service.RpAccountService;
import cn.ucaner.alpaca.pay.common.core.enums.PublicStatusEnum;
import cn.ucaner.alpaca.pay.common.core.page.PageBean;
import cn.ucaner.alpaca.pay.common.core.page.PageParam;
import cn.ucaner.alpaca.pay.common.core.utils.EncryptUtil;
import cn.ucaner.alpaca.pay.common.core.utils.StringUtil;
import cn.ucaner.alpaca.pay.user.dao.RpUserInfoDao;
import cn.ucaner.alpaca.pay.user.entity.RpUserInfo;
import cn.ucaner.alpaca.pay.user.service.BuildNoService;
import cn.ucaner.alpaca.pay.user.service.RpUserInfoService;

/**
* @Package：cn.ucaner.alpaca.pay.user.service.impl   
* @ClassName：RpUserInfoServiceImpl   
* @Description：   <p> 用户信息service实现类</p>
* @Author： -    
* @CreatTime：2018年5月10日 下午11:13:18   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
@Service("rpUserInfoService")
public class RpUserInfoServiceImpl implements RpUserInfoService{

	@Autowired
	private RpUserInfoDao rpUserInfoDao;
	
	@Autowired
	private BuildNoService buildNoService;
	
	@Autowired
	private RpAccountService rpAccountService;
	
	@Override
	public void saveData(RpUserInfo rpUserInfo) {
		rpUserInfoDao.insert(rpUserInfo);
	}

	@Override
	public void updateData(RpUserInfo rpUserInfo) {
		rpUserInfoDao.update(rpUserInfo);
	}

	@Override
	public RpUserInfo getDataById(String id) {
		return rpUserInfoDao.getById(id);
	}

	@Override
	public PageBean listPage(PageParam pageParam, RpUserInfo rpUserInfo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userNo", rpUserInfo.getUserNo());
		return rpUserInfoDao.listPage(pageParam, paramMap);
	}
	
    /**
     * 用户线下注册
     * 
     * @param userName
     *            用户名
     * @param mobile
     *            手机号
     * @param password
     *            密码
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void registerOffline(String userName, String mobile, String password) {
        String userNo = buildNoService.buildUserNo();
        String accountNo = buildNoService.buildAccountNo();

        //生成用户信息
        RpUserInfo rpUserInfo = new RpUserInfo();
        rpUserInfo.setAccountNo(accountNo);
        rpUserInfo.setCreateTime(new Date());
        rpUserInfo.setId(StringUtil.get32UUID());
        rpUserInfo.setStatus(PublicStatusEnum.ACTIVE.name());
        rpUserInfo.setUserName(userName);
        rpUserInfo.setUserNo(userNo);
        rpUserInfo.setMobile(mobile);
        rpUserInfo.setPassword(EncryptUtil.encodeMD5String(password));
        rpUserInfo.setPayPwd(EncryptUtil.encodeMD5String("123456"));
        rpUserInfo.setVersion(0);
        this.saveData(rpUserInfo);

        // 生成账户信息
        RpAccount rpAccount = new RpAccount();
        rpAccount.setAccountNo(accountNo);
        rpAccount.setAccountType("0");
        rpAccount.setCreateTime(new Date());
        rpAccount.setEditTime(new Date());
        rpAccount.setId(StringUtil.get32UUID());
        rpAccount.setStatus(PublicStatusEnum.ACTIVE.name());
        rpAccount.setUserNo(userNo);
        rpAccount.setBalance(new BigDecimal("0"));
        rpAccount.setSecurityMoney(new BigDecimal("0"));
        rpAccount.setSettAmount(new BigDecimal("0"));
        rpAccount.setTodayExpend(new BigDecimal("0"));
        rpAccount.setTodayIncome(new BigDecimal("0"));
        rpAccount.setUnbalance(new BigDecimal("0"));
        rpAccount.setTotalExpend(new BigDecimal("0"));
        rpAccount.setTotalIncome(new BigDecimal("0"));
        rpAccountService.saveData(rpAccount);
    }

    /**
     * 根据商户编号获取商户信息
     *
     * @param merchantNo
     * @return
     */
    @Override
    public RpUserInfo getDataByMerchentNo(String merchantNo) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userNo", merchantNo);
		paramMap.put("status", PublicStatusEnum.ACTIVE.name());
		return rpUserInfoDao.getBy(paramMap);
    }
    
    /**
	 * 根据手机号获取商户信息
	 * @param mobile
	 * @return
	 */
    @Override
    public RpUserInfo getDataByMobile(String mobile){
    	Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mobile", mobile);
		paramMap.put("status", PublicStatusEnum.ACTIVE.name());
		return rpUserInfoDao.getBy(paramMap);
    }
    
    /**
	 * 获取所有用户
	 * @return
	 */
    @Override
    public List<RpUserInfo> listAll(){
    	Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("status", PublicStatusEnum.ACTIVE.name());
		return rpUserInfoDao.listBy(paramMap);
	}
}