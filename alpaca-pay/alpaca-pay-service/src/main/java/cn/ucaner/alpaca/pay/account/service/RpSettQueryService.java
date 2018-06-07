package cn.ucaner.alpaca.pay.account.service;

import java.util.Map;

import cn.ucaner.alpaca.pay.account.entity.RpSettRecord;
import cn.ucaner.alpaca.pay.common.exception.BizException;
import cn.ucaner.alpaca.pay.common.page.PageBean;
import cn.ucaner.alpaca.pay.common.page.PageParam;

/**
* @Package：cn.ucaner.alpaca.pay.account.service   
* @ClassName：RpSettQueryService   
* @Description：   <p> 结算查询service接口 </p>
* @Author： - Jason   
* @CreatTime：2018年5月10日 下午10:41:04   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public interface RpSettQueryService {

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
	public PageBean querySettRecordListPage(PageParam pageParam, Map<String, Object> params) throws BizException;

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
	public PageBean querySettDailyCollectListPage(PageParam pageParam, Map<String, Object> params) throws BizException;
	
	/**
	 * 根据id获取数据
	 * 
	 * @param id
	 * @return
	 */
	public RpSettRecord getDataById(String id);
}