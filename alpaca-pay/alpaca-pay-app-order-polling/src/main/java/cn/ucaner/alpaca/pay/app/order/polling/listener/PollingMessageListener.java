package cn.ucaner.alpaca.pay.app.order.polling.listener;

import java.util.Date;
import java.util.Map;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;

import cn.ucaner.alpaca.pay.app.order.polling.core.PollingQueue;
import cn.ucaner.alpaca.pay.app.order.polling.entity.PollingParam;
import cn.ucaner.alpaca.pay.common.core.exception.BizException;
import cn.ucaner.alpaca.pay.notify.entity.RpOrderResultQueryVo;
import cn.ucaner.alpaca.pay.notify.enums.NotifyStatusEnum;

/**
* @Package：cn.ucaner.alpaca.pay.app.order.polling.listener   
* @ClassName：PollingMessageListener   
* @Description：   <p> PollingMessageListener </p>
* @Author： -    
* @CreatTime：2018年5月12日 下午2:03:42   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
public class PollingMessageListener implements MessageListener {
	private static final Log log = LogFactory.getLog(PollingMessageListener.class);

	@Autowired
	private PollingQueue pollingQueue;

	@Autowired
	private PollingParam pollingParam;

	public void onMessage(Message message) {
		try {
			ActiveMQTextMessage msg = (ActiveMQTextMessage) message;
			final String msgText = msg.getText();
			log.info("== receive bankOrderNo :" + msgText);

			RpOrderResultQueryVo rpOrderResultQueryVo = new RpOrderResultQueryVo();

			rpOrderResultQueryVo.setBankOrderNo(msgText);
			rpOrderResultQueryVo.setStatus(NotifyStatusEnum.CREATED.name());
			rpOrderResultQueryVo.setCreateTime(new Date());
			rpOrderResultQueryVo.setEditTime(new Date());
			rpOrderResultQueryVo.setLastNotifyTime(new Date());
			rpOrderResultQueryVo.setNotifyTimes(0); // 初始化通知0次
			rpOrderResultQueryVo.setLimitNotifyTimes(pollingParam.getMaxNotifyTimes()); // 最大通知次数
			Map<Integer, Integer> notifyParams = pollingParam.getNotifyParams();
			rpOrderResultQueryVo.setNotifyRule(JSONObject.toJSONString(notifyParams)); // 保存JSON

			try {

				pollingQueue.addToNotifyTaskDelayQueue(rpOrderResultQueryVo); // 添加到通知队列(第一次通知)

			}  catch (BizException e) {
				log.error("BizException :", e);
			} catch (Exception e) {
				log.error(e);
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

}
