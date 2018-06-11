package cn.ucaner.alpaca.pay.notify.service.impl;

import java.util.Map;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.ucaner.alpaca.pay.common.config.MqConfig;
import cn.ucaner.alpaca.pay.common.page.PageBean;
import cn.ucaner.alpaca.pay.common.page.PageParam;
import cn.ucaner.alpaca.pay.notify.dao.RpNotifyRecordDao;
import cn.ucaner.alpaca.pay.notify.dao.RpNotifyRecordLogDao;
import cn.ucaner.alpaca.pay.notify.entity.RpNotifyRecord;
import cn.ucaner.alpaca.pay.notify.entity.RpNotifyRecordLog;
import cn.ucaner.alpaca.pay.notify.enums.NotifyStatusEnum;
import cn.ucaner.alpaca.pay.notify.enums.NotifyTypeEnum;
import cn.ucaner.alpaca.pay.notify.service.RpNotifyService;

/**
* @Package：cn.ucaner.alpaca.pay.notify.service.impl   
* @ClassName：RpNotifyServiceImpl   
* @Description：   <p> RpNotifyServiceImpl</p>
* @Author： - Jason   
* @CreatTime：2018年5月10日 下午10:45:30   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
@Service("rpNotifyService")
public class RpNotifyServiceImpl implements RpNotifyService {

	@Autowired
	private JmsTemplate notifyJmsTemplate;

	@Autowired
	private RpNotifyRecordDao rpNotifyRecordDao;

	@Autowired
	private RpNotifyRecordLogDao rpNotifyRecordLogDao;

	@Resource(name = "jmsTemplate")
	private JmsTemplate jmsTemplate;

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
	@Override
	public void notifySend(String notifyUrl, String merchantOrderNo, String merchantNo) {

		RpNotifyRecord record = new RpNotifyRecord();
		record.setNotifyTimes(0);
		record.setLimitNotifyTimes(5);
		record.setStatus(NotifyStatusEnum.CREATED.name());
		record.setUrl(notifyUrl);
		record.setMerchantOrderNo(merchantOrderNo);
		record.setMerchantNo(merchantNo);
		record.setNotifyType(NotifyTypeEnum.MERCHANT.name());

		Object toJSON = JSONObject.toJSON(record);
		final String str = toJSON.toString();
		
		notifyJmsTemplate.setDefaultDestinationName(MqConfig.MERCHANT_NOTIFY_QUEUE);
		/*notifyJmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(str);
			}
		});*/
	}

	/**
	 * 订单通知
	 * 
	 * @param merchantOrderNo
	 */
	@Override
	public void orderSend(String bankOrderNo) {
		final String orderNo = bankOrderNo;
		
		jmsTemplate.setDefaultDestinationName(MqConfig.ORDER_NOTIFY_QUEUE);
		/*jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(orderNo);
			}
		});*/
	}

	/**
	 * 通过ID获取通知记录
	 *
	 * @param id
	 * @return
	 */
	@Override
	public RpNotifyRecord getNotifyRecordById(String id) {
		return rpNotifyRecordDao.getById(id);
	}

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
	@Override
	public RpNotifyRecord getNotifyByMerchantNoAndMerchantOrderNoAndNotifyType(String merchantNo,
			String merchantOrderNo, String notifyType) {
		return rpNotifyRecordDao.getNotifyByMerchantNoAndMerchantOrderNoAndNotifyType(merchantNo, merchantOrderNo,
				notifyType);
	}

	@Override
	public PageBean<RpNotifyRecord> queryNotifyRecordListPage(PageParam pageParam, Map<String, Object> paramMap) {
		return rpNotifyRecordDao.listPage(pageParam, paramMap);
	}

	/**
	 * 创建消息通知
	 *
	 * @param rpNotifyRecord
	 */
	@Override
	public long createNotifyRecord(RpNotifyRecord rpNotifyRecord) {
		return rpNotifyRecordDao.insert(rpNotifyRecord);
	}

	/**
	 * 修改消息通知
	 *
	 * @param rpNotifyRecord
	 */
	@Override
	public void updateNotifyRecord(RpNotifyRecord rpNotifyRecord) {
		rpNotifyRecordDao.update(rpNotifyRecord);
	}

	/**
	 * 创建消息通知记录
	 *
	 * @param rpNotifyRecordLog
	 * @return
	 */
	@Override
	public long createNotifyRecordLog(RpNotifyRecordLog rpNotifyRecordLog) {
		return rpNotifyRecordLogDao.insert(rpNotifyRecordLog);
	}

}
