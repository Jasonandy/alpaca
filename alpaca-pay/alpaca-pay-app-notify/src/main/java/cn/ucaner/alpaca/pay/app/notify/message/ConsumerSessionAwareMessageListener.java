package cn.ucaner.alpaca.pay.app.notify.message;

import java.util.Date;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.ucaner.alpaca.pay.app.notify.core.NotifyPersist;
import cn.ucaner.alpaca.pay.app.notify.core.NotifyQueue;
import cn.ucaner.alpaca.pay.common.core.exception.BizException;
import cn.ucaner.alpaca.pay.common.core.utils.StringUtil;
import cn.ucaner.alpaca.pay.notify.entity.RpNotifyRecord;
import cn.ucaner.alpaca.pay.notify.enums.NotifyStatusEnum;
import cn.ucaner.alpaca.pay.notify.service.RpNotifyService;

/**
* @Package：cn.alpaca.pay.app.notify.message   
* @ClassName：ConsumerSessionAwareMessageListener   
* @Description：   <p> ConsumerSessionAwareMessageListener 监听器</p>
* @Author： -    
* @CreatTime：2018年5月12日 下午1:42:39   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
public class ConsumerSessionAwareMessageListener  implements MessageListener {

    private static final Log log = LogFactory.getLog(ConsumerSessionAwareMessageListener.class);

    @Autowired
    private NotifyQueue notifyQueue;

    @Autowired
    private RpNotifyService rpNotifyService;

    @Autowired
    private NotifyPersist notifyPersist;

    @SuppressWarnings("static-access")
    public void onMessage(Message message) {
        try {
            ActiveMQTextMessage msg = (ActiveMQTextMessage) message;
            final String ms = msg.getText();
            log.info("== receive message:" + ms);

            JSON json = (JSON) JSONObject.parse(ms);
            RpNotifyRecord notifyRecord = JSONObject.toJavaObject(json, RpNotifyRecord.class);
            if (notifyRecord == null) {
                return;
            }
            // log.info("notifyParam:" + notifyParam);
            notifyRecord.setStatus(NotifyStatusEnum.CREATED.name());
            notifyRecord.setCreateTime(new Date());
            notifyRecord.setLastNotifyTime(new Date());

            if ( !StringUtil.isEmpty(notifyRecord.getId())){
                RpNotifyRecord notifyRecordById = rpNotifyService.getNotifyRecordById(notifyRecord.getId());
                if (notifyRecordById != null){
                    return;
                }
            }

            while (rpNotifyService == null) {
                Thread.currentThread().sleep(1000); // 主动休眠，防止类Spring 未加载完成，监听服务就开启监听出现空指针异常
            }

            try {
                // 将获取到的通知先保存到数据库中
                notifyPersist.saveNotifyRecord(notifyRecord);
                notifyRecord = rpNotifyService.getNotifyByMerchantNoAndMerchantOrderNoAndNotifyType(notifyRecord.getMerchantNo(), notifyRecord.getMerchantOrderNo(), notifyRecord.getNotifyType());

                // 添加到通知队列
                notifyQueue.addElementToList(notifyRecord);
            }  catch (BizException e) {
                log.error("BizException :", e);
            } catch (Exception e) {
                log.error(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e);
        }
    }


}
