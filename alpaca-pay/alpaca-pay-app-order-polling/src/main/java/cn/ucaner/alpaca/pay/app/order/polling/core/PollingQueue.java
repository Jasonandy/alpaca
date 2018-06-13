package cn.ucaner.alpaca.pay.app.order.polling.core;


import java.io.Serializable;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import cn.ucaner.alpaca.pay.app.order.polling.App;
import cn.ucaner.alpaca.pay.common.utils.DateUtils;
import cn.ucaner.alpaca.pay.notify.entity.RpOrderResultQueryVo;

/**
* @Package：cn.ucaner.alpaca.pay.app.order.polling.core   
* @ClassName：PollingQueue   
* @Description：   <p> PollingQueue</p>
* @Author： -    
* @CreatTime：2018年5月12日 下午1:58:46   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
@Component
public class PollingQueue implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log logger = LogFactory.getLog(PollingQueue.class);

    /**
     * 将传过来的对象进行通知次数判断，决定是否放在任务队列中.<br/>
     * @param rpOrderResultQueryVo
     * @throws Exception
     */
    public void addToNotifyTaskDelayQueue(RpOrderResultQueryVo rpOrderResultQueryVo) {
        if (rpOrderResultQueryVo == null) {
            return;
        }
        logger.info("===>addToOrderQueryTaskDelayQueue bank order no:" + rpOrderResultQueryVo.getBankOrderNo());
        Integer notifyTimes = rpOrderResultQueryVo.getNotifyTimes(); // 通知次数
        Integer maxNotifyTimes = rpOrderResultQueryVo.getLimitNotifyTimes(); // 最大通知次数

        if (rpOrderResultQueryVo.getNotifyTimes().intValue() == 0) {
            rpOrderResultQueryVo.setLastNotifyTime(new Date()); // 第一次发送(取当前时间)
        }else{
            rpOrderResultQueryVo.setLastNotifyTime(rpOrderResultQueryVo.getEditTime()); // 非第一次发送（取上一次修改时间，也是上一次发送时间）
        }

        if (notifyTimes < maxNotifyTimes) {
            // 未超过最大通知次数，继续下一次通知
            logger.info("===>bank order No  " + rpOrderResultQueryVo.getBankOrderNo() + ", 上次通知时间lastNotifyTime:" + DateUtils.formatDate(rpOrderResultQueryVo.getLastNotifyTime(), "yyyy-MM-dd HH:mm:ss SSS"));
            App.tasks.put(new PollingTask(rpOrderResultQueryVo));
        }

    }
}
