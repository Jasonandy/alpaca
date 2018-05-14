package cn.ucaner.alpaca.pay.user.service;

import cn.ucaner.alpaca.pay.user.entity.RpUserBankAccount;

/**
* @Package：cn.ucaner.alpaca.pay.user.service   
* @ClassName：RpUserBankAccountService   
* @Description：   <p> 用户银行账户service接口</p>
* @Author： -    
* @CreatTime：2018年5月10日 下午11:09:09   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public interface RpUserBankAccountService{
	
	/**
	 * 保存
	 */
	void saveData(RpUserBankAccount rpUserBankAccount);

	/**
	 * 更新
	 */
	void updateData(RpUserBankAccount rpUserBankAccount);

	/**
	 * 根据用户编号获取银行账户
	 */
	RpUserBankAccount getByUserNo(String userNo);

	/**
	 * 创建或更新
	 * @param rpUserBankAccount
	 */
	void createOrUpdate(RpUserBankAccount rpUserBankAccount);
}