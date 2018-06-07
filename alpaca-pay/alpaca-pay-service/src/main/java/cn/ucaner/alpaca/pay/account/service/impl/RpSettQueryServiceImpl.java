package cn.ucaner.alpaca.pay.account.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ucaner.alpaca.pay.account.dao.RpSettDailyCollectDao;
import cn.ucaner.alpaca.pay.account.dao.RpSettRecordDao;
import cn.ucaner.alpaca.pay.account.entity.RpSettRecord;
import cn.ucaner.alpaca.pay.account.service.RpSettQueryService;
import cn.ucaner.alpaca.pay.common.exception.BizException;
import cn.ucaner.alpaca.pay.common.page.PageBean;
import cn.ucaner.alpaca.pay.common.page.PageParam;

/**
* @Package：cn.ucaner.alpaca.pay.account.service.impl   
* @ClassName：RpSettQueryServiceImpl   
* @Description：   <p> 结算查询service实现类</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午9:36:30   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
@Service("rpSettQueryService")
public class RpSettQueryServiceImpl implements RpSettQueryService {

	@Autowired
	private RpSettRecordDao rpSettRecordDao;
	@Autowired
	private RpSettDailyCollectDao settDailyCollectMapper;

	/**
	 * 根据参数分页查询结算记录
	 * 
	 * @param pageParam
	 * @param params
	 *            ：map的key为 ：accountNo、userNo、settStatus...可以参考实体
	 * 
	 * @return
	 * @throws BizException
	 */
	public PageBean querySettRecordListPage(PageParam pageParam, Map<String, Object> params) throws BizException{
		return rpSettRecordDao.listPage(pageParam, params);
	}

	/**
	 * 根据参数分页查询结算日汇总记录
	 * 
	 * @param pageParam
	 * @param params
	 *            ：map的key为 ：accountNo...可以参考实体
	 * 
	 * @return
	 * @throws BizException
	 */
	public PageBean querySettDailyCollectListPage(PageParam pageParam, Map<String, Object> params) throws BizException{
		return settDailyCollectMapper.listPage(pageParam, params);
	}
	
	/**
	 * 根据id获取数据
	 * 
	 * @param id
	 * @return
	 */
	public RpSettRecord getDataById(String id){
		return rpSettRecordDao.getById(id);
	}
}
