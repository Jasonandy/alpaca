package cn.ucaner.alpaca.pay.user.service;

import java.util.List;

import cn.ucaner.alpaca.pay.common.core.page.PageBean;
import cn.ucaner.alpaca.pay.common.core.page.PageParam;
import cn.ucaner.alpaca.pay.user.entity.RpUserInfo;

/**
* @Package：cn.ucaner.alpaca.pay.user.service   
* @ClassName：RpUserInfoService   
* @Description：   <p> 用户信息service接口</p>
* @Author： -    
* @CreatTime：2018年5月10日 下午11:08:35   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public interface RpUserInfoService{
	
	/**
	 * 保存
	 */
	void saveData(RpUserInfo rpUserInfo);

	/**
	 * 更新
	 */
	void updateData(RpUserInfo rpUserInfo);

	/**
	 * 根据id获取数据
	 * 
	 * @param id
	 * @return
	 */
	RpUserInfo getDataById(String id);
	

	/**
	 * 获取分页数据
	 * 
	 * @param pageParam
	 * @return
	 */
	PageBean listPage(PageParam pageParam, RpUserInfo rpUserInfo);
	
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
    void registerOffline(String userName, String mobile, String password) ;

	/**
	 * 根据商户编号获取商户信息
	 * @param merchantNo
	 * @return
	 */
	RpUserInfo getDataByMerchentNo(String merchantNo);
	
	/**
	 * 根据手机号获取商户信息
	 * @param mobile
	 * @return
	 */
	RpUserInfo getDataByMobile(String mobile);
	
	/**
	 * 获取所有用户
	 * @return
	 */
	List<RpUserInfo> listAll();
	
}