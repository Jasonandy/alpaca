package cn.ucaner.alpaca.pay.notify.service;

import java.util.Map;

import cn.ucaner.alpaca.pay.common.core.page.PageBean;
import cn.ucaner.alpaca.pay.common.core.page.PageParam;
import cn.ucaner.alpaca.pay.notify.entity.RpNotifyRecord;
import cn.ucaner.alpaca.pay.notify.entity.RpNotifyRecordLog;

/**
* @Package：cn.ucaner.alpaca.pay.notify.service   
* @ClassName：RpNotifyService   
* @Description：   <p> RpNotifyService</p>
* @Author： - Jason   
* @CreatTime：2018年5月10日 下午10:46:00   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public interface RpNotifyService {

	/**
	 * 发送消息通知
	 * 
	 * @param notifyUrl
	 *            通知地址
	 * @param merchantOrderNo
	 *            商户订单号
	 * @param merchantNo
	 *            商户编号
	 */
	public void notifySend(String notifyUrl, String merchantOrderNo, String merchantNo);

	/**
	 * 订单通知
	 * 
	 * @param bankOrderNo
	 *            订单编号
	 */
	void orderSend(String bankOrderNo);

	/**
	 * 通过ID获取通知记录
	 * 
	 * @param id
	 * @return
	 */
	public RpNotifyRecord getNotifyRecordById(String id);

	/**
	 * 根据商户编号,商户订单号,通知类型获取通知记录
	 * 
	 * @param merchantNo
	 *            商户编号
	 * @param merchantOrderNo
	 *            商户订单号
	 * @param notifyType
	 *            消息类型
	 * @return
	 */
	public RpNotifyRecord getNotifyByMerchantNoAndMerchantOrderNoAndNotifyType(String merchantNo,
			String merchantOrderNo, String notifyType);

	public PageBean<RpNotifyRecord> queryNotifyRecordListPage(PageParam pageParam, Map<String, Object> paramMap);

	/**
	 * 创建消息通知
	 * 
	 * @param rpNotifyRecord
	 */
	public long createNotifyRecord(RpNotifyRecord rpNotifyRecord);

	/**
	 * 修改消息通知
	 * 
	 * @param rpNotifyRecord
	 */
	public void updateNotifyRecord(RpNotifyRecord rpNotifyRecord);

	/**
	 * 创建消息通知记录
	 * 
	 * @param rpNotifyRecordLog
	 * @return
	 */
	public long createNotifyRecordLog(RpNotifyRecordLog rpNotifyRecordLog);

}
