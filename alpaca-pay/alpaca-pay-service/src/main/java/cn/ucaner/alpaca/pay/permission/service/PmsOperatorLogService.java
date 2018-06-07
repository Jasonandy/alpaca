package cn.ucaner.alpaca.pay.permission.service;

import cn.ucaner.alpaca.pay.common.page.PageBean;
import cn.ucaner.alpaca.pay.common.page.PageParam;
import cn.ucaner.alpaca.pay.permission.entity.PmsOperatorLog;

/**
* @Package：cn.ucaner.alpaca.pay.permission.service   
* @ClassName：PmsOperatorLogService   
* @Description：   <p> 操作员日志service接口 </p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:12:21   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public interface PmsOperatorLogService {

	/**
	 * 创建pmsOperatorLog
	 */
	void saveData(PmsOperatorLog pmsOperatorLog);

	/**
	 * 修改pmsOperatorLog
	 */
	void updateData(PmsOperatorLog pmsOperatorLog);

	/**
	 * 根据id获取数据pmsOperatorLog
	 * 
	 * @param id
	 * @return
	 */
	PmsOperatorLog getDataById(Long id);

	/**
	 * 分页查询pmsOperatorLog
	 * 
	 * @param pageParam
	 * @param ActivityVo
	 *            PmsOperatorLog
	 * @return
	 */
	PageBean listPage(PageParam pageParam, PmsOperatorLog pmsOperatorLog);

}
