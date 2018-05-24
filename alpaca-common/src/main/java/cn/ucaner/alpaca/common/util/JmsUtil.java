package cn.ucaner.alpaca.common.util;

import org.apache.activemq.ScheduledMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;
import java.io.Serializable;

/**
* @Package：cn.ucaner.alpaca.common.util   
* @ClassName：JmsUtil   
* @Description：   <p> JmsUtil</p>
* @Author： -    
* @CreatTime：2018年5月24日 下午2:14:58   
* @Modify By：   
* @ModifyTime：  2018年5月24日
* @Modify marker：   
* @version    V1.0
 */
public class JmsUtil {

    /**
     * 发送文本消息
     * @param jmsTemplate
     * @param destination
     * @param textMessage
     */
    public static void sendMessage(JmsTemplate jmsTemplate, Destination destination, final String textMessage) {
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(textMessage);
            }
        });
    }

    /**
     * 发送对象消息
     * @param jmsTemplate
     * @param destination
     * @param objectMessage
     */
    public static void sendMessage(JmsTemplate jmsTemplate, Destination destination, final Serializable objectMessage) {
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(objectMessage);
            }
        });
    }

    /**
     * 延迟发送对象消息
     * @param jmsTemplate
     * @param destination
     * @param objectMessage
     * @param delay
     */
    public static void sendMessageDelay(JmsTemplate jmsTemplate, Destination destination, final Serializable objectMessage, final long delay) {
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage om = session.createObjectMessage(objectMessage);
                om.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
                om.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD, 1 * 1000);
                om.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT, 1);
                return om;
            }
        });
    }

}
