package cn.ucaner.alpaca.pay.reconciliation.service;

import java.util.List;
import java.util.Map;

import cn.ucaner.alpaca.pay.common.core.page.PageBean;
import cn.ucaner.alpaca.pay.common.core.page.PageParam;
import cn.ucaner.alpaca.pay.reconciliation.entity.RpAccountCheckMistake;

/**
* @Package：cn.ucaner.alpaca.pay.reconciliation.service   
* @ClassName：RpAccountCheckMistakeService   
* @Description：   <p> 对账差错接口 . </p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:31:55   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public interface RpAccountCheckMistakeService {

	/**
	 * 保存
	 */
	void saveData(RpAccountCheckMistake rpAccountCheckMistake);

	/**
	 * 更新
	 */
	void updateData(RpAccountCheckMistake rpAccountCheckMistake);

	/**
	 * 根据id获取数据
	 * 
	 * @param id
	 * @return
	 */
	RpAccountCheckMistake getDataById(String id);

	/**
	 * 获取分页数据
	 * 
	 * @param pageParam
	 * @return
	 */
	PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);

	/**
	 * 批量保存差错记录
	 * 
	 * @param mistakeList
	 */
	void saveListDate(List<RpAccountCheckMistake> mistakeList);

}