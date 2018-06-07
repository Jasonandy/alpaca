package cn.ucaner.alpaca.pay.account.service;

import cn.ucaner.alpaca.pay.account.entity.RpAccount;
import cn.ucaner.alpaca.pay.common.page.PageBean;
import cn.ucaner.alpaca.pay.common.page.PageParam;

/**
* @Package：cn.ucaner.alpaca.pay.account.service   
* @ClassName：RpAccountService   
* @Description：   <p> 账户service接口 </p>
* @Author： - wubin   
* @CreatTime：2018年5月10日 下午10:40:03   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public interface RpAccountService{
	
	/**
	 * 保存
	 */
	void saveData(RpAccount rpAccount);

	/**
	 * 更新
	 */
	void updateData(RpAccount rpAccount);

	/**
	 * 根据id获取数据
	 * 
	 * @param id
	 * @return
	 */
	RpAccount getDataById(String id);
	

	/**
	 * 获取分页数据
	 * 
	 * @param pageParam
	 * @return
	 */
	PageBean listPage(PageParam pageParam, RpAccount rpAccount);
	
	/**
	 * 根据userNo获取数据
	 * 
	 * @param userNo
	 * @return
	 */
	RpAccount getDataByUserNo(String userNo);
	
}