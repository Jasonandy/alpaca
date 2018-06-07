package cn.ucaner.alpaca.pay.user.service;

import cn.ucaner.alpaca.pay.common.page.PageBean;
import cn.ucaner.alpaca.pay.common.page.PageParam;
import cn.ucaner.alpaca.pay.user.entity.RpUserPayInfo;

/**
 * 
* @Package：cn.ucaner.alpaca.pay.user.service   
* @ClassName：RpUserPayInfoService   
* @Description：   <p> 用户第三方支付信息service接口</p>
* @Author： -    
* @CreatTime：2018年5月10日 下午11:07:54   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public interface RpUserPayInfoService{
	
	/**
	 * 保存
	 */
	void saveData(RpUserPayInfo rpUserPayInfo);

	/**
	 * 更新
	 */
	void updateData(RpUserPayInfo rpUserPayInfo);

	/**
	 * 根据id获取数据
	 * 
	 * @param id
	 * @return
	 */
	RpUserPayInfo getDataById(String id);
	

	/**
	 * 获取分页数据
	 * 
	 * @param pageParam
	 * @return
	 */
	PageBean listPage(PageParam pageParam, RpUserPayInfo rpUserPayInfo);

	/**
	 * 通过商户编号获取商户支付配置信息
	 * @param userNo
	 * @param payWayCode
	 * @return
	 */
	public RpUserPayInfo getByUserNo(String userNo, String payWayCode);
	
}