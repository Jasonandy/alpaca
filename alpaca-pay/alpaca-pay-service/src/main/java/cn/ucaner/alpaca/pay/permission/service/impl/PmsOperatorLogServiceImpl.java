package cn.ucaner.alpaca.pay.permission.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ucaner.alpaca.pay.common.core.page.PageBean;
import cn.ucaner.alpaca.pay.common.core.page.PageParam;
import cn.ucaner.alpaca.pay.permission.dao.PmsOperatorLogDao;
import cn.ucaner.alpaca.pay.permission.entity.PmsOperatorLog;
import cn.ucaner.alpaca.pay.permission.service.PmsOperatorLogService;

/**
* @Package：cn.ucaner.alpaca.pay.permission.service.impl   
* @ClassName：PmsOperatorLogServiceImpl   
* @Description：   <p> 操作员service接口实现</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:15:00   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
@Service("pmsOperatorLogService")
public class PmsOperatorLogServiceImpl implements PmsOperatorLogService {
	@Autowired
	private PmsOperatorLogDao pmsOperatorLogDao;

	/**
	 * 创建pmsOperator
	 */
	public void saveData(PmsOperatorLog pmsOperatorLog) {
		pmsOperatorLogDao.insert(pmsOperatorLog);
	}

	/**
	 * 修改pmsOperator
	 */
	public void updateData(PmsOperatorLog pmsOperatorLog) {
		pmsOperatorLogDao.update(pmsOperatorLog);
	}

	/**
	 * 根据id获取数据pmsOperator
	 * 
	 * @param id
	 * @return
	 */
	public PmsOperatorLog getDataById(Long id) {
		return pmsOperatorLogDao.getById(id);

	}

	/**
	 * 分页查询pmsOperator
	 * 
	 * @param pageParam
	 * @param ActivityVo
	 *            PmsOperator
	 * @return
	 */
	public PageBean listPage(PageParam pageParam, PmsOperatorLog pmsOperatorLog) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return pmsOperatorLogDao.listPage(pageParam, paramMap);
	}

}
