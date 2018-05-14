package cn.ucaner.alpaca.pay.user.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ucaner.alpaca.pay.common.core.enums.PublicEnum;
import cn.ucaner.alpaca.pay.common.core.enums.PublicStatusEnum;
import cn.ucaner.alpaca.pay.common.core.utils.StringUtil;
import cn.ucaner.alpaca.pay.user.dao.RpUserBankAccountDao;
import cn.ucaner.alpaca.pay.user.entity.RpUserBankAccount;
import cn.ucaner.alpaca.pay.user.enums.BankCodeEnum;
import cn.ucaner.alpaca.pay.user.service.RpUserBankAccountService;

/**
* @Package：cn.ucaner.alpaca.pay.user.service.impl   
* @ClassName：RpUserBankAccountServiceImpl   
* @Description：   <p> 用户银行账户service实现类</p>
* @Author： -    
* @CreatTime：2018年5月10日 下午11:13:52   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
@Service("rpUserBankAccountService")
public class RpUserBankAccountServiceImpl implements RpUserBankAccountService{

	@Autowired
	private RpUserBankAccountDao rpUserBankAccountDao;
	
	@Override
	public void saveData(RpUserBankAccount rpUserBankAccount) {
		rpUserBankAccountDao.insert(rpUserBankAccount);
	}

	@Override
	public void updateData(RpUserBankAccount rpUserBankAccount) {
		rpUserBankAccountDao.update(rpUserBankAccount);
	}

	/**
	 * 根据用户编号获取银行账户
	 */
	@Override
	public RpUserBankAccount getByUserNo(String userNo){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userNo", userNo);
		paramMap.put("status", PublicStatusEnum.ACTIVE.name());
		return rpUserBankAccountDao.getBy(paramMap);
	}
	
	/**
	 * 创建或更新
	 * @param rpUserBankAccount
	 */
	@Override
	public void createOrUpdate(RpUserBankAccount rpUserBankAccount){
		RpUserBankAccount bankAccount = getByUserNo(rpUserBankAccount.getUserNo());
		if(bankAccount == null){
			bankAccount = new RpUserBankAccount();
			bankAccount.setId(StringUtil.get32UUID());
			bankAccount.setCreateTime(new Date());
			bankAccount.setEditTime(new Date());
			bankAccount.setAreas(rpUserBankAccount.getAreas());
			bankAccount.setBankAccountName(rpUserBankAccount.getBankAccountName());
			bankAccount.setBankAccountNo(rpUserBankAccount.getBankAccountNo());
			bankAccount.setBankAccountType(rpUserBankAccount.getBankAccountType());
			bankAccount.setBankCode(rpUserBankAccount.getBankCode());
			bankAccount.setBankName(BankCodeEnum.getEnum(rpUserBankAccount.getBankCode()).getDesc());
			bankAccount.setCardNo(rpUserBankAccount.getCardNo());
			bankAccount.setCardType(rpUserBankAccount.getCardType());
			bankAccount.setCity(rpUserBankAccount.getCity());
			bankAccount.setIsDefault(PublicEnum.YES.name());
			bankAccount.setMobileNo(rpUserBankAccount.getMobileNo());
			bankAccount.setProvince(rpUserBankAccount.getProvince());
			bankAccount.setRemark(rpUserBankAccount.getRemark());
			bankAccount.setStatus(PublicStatusEnum.ACTIVE.name());
			bankAccount.setUserNo(rpUserBankAccount.getUserNo());
			bankAccount.setStreet(rpUserBankAccount.getStreet());
			rpUserBankAccountDao.insert(bankAccount);
		}else{
			bankAccount.setEditTime(new Date());
			bankAccount.setAreas(rpUserBankAccount.getAreas());
			bankAccount.setBankAccountName(rpUserBankAccount.getBankAccountName());
			bankAccount.setBankAccountNo(rpUserBankAccount.getBankAccountNo());
			bankAccount.setBankAccountType(rpUserBankAccount.getBankAccountType());
			bankAccount.setBankCode(rpUserBankAccount.getBankCode());
			bankAccount.setBankName(BankCodeEnum.getEnum(rpUserBankAccount.getBankCode()).getDesc());
			bankAccount.setCardNo(rpUserBankAccount.getCardNo());
			bankAccount.setCardType(rpUserBankAccount.getCardType());
			bankAccount.setCity(rpUserBankAccount.getCity());
			bankAccount.setIsDefault(PublicEnum.YES.name());
			bankAccount.setMobileNo(rpUserBankAccount.getMobileNo());
			bankAccount.setProvince(rpUserBankAccount.getProvince());
			bankAccount.setRemark(rpUserBankAccount.getRemark());
			bankAccount.setStatus(PublicStatusEnum.ACTIVE.name());
			bankAccount.setUserNo(rpUserBankAccount.getUserNo());
			bankAccount.setStreet(rpUserBankAccount.getStreet());
			rpUserBankAccountDao.update(bankAccount);
		}
	}
}