package cn.ucaner.alpaca.pay.app.notify.core;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.ucaner.alpaca.pay.app.notify.App;
import cn.ucaner.alpaca.pay.app.notify.entity.NotifyParam;
import cn.ucaner.alpaca.pay.notify.entity.RpNotifyRecord;
import cn.ucaner.alpaca.pay.notify.enums.NotifyStatusEnum;

/**
* @Package：cn.alpaca.pay.app.notify.core   
* @ClassName：NotifyQueue   
* @Description：   <p> NotifyQueue 通知队列</p>
* @Author： -    
* @CreatTime：2018年5月12日 下午1:40:08   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
@Component
public class NotifyQueue implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOG = LogFactory.getLog(NotifyQueue.class);

    @Autowired
    private NotifyParam notifyParam;

    @Autowired
    private NotifyPersist notifyPersist;
    /**
     * 将传过来的对象进行通知次数判断，之后决定是否放在任务队列中
     *
     * @param notifyRecord
     * @throws Exception
     */
    public void addElementToList(RpNotifyRecord notifyRecord) {
        if (notifyRecord == null) {
            return;
        }
        Integer notifyTimes = notifyRecord.getNotifyTimes(); // 通知次数
        Integer maxNotifyTime = 0;
        try {
            maxNotifyTime = notifyParam.getMaxNotifyTime();
        } catch (Exception e) {
            LOG.error(e);
        }
        if (notifyRecord.getVersion().intValue() == 0) {// 刚刚接收到的数据
            notifyRecord.setLastNotifyTime(new Date());
        }
        long time = notifyRecord.getLastNotifyTime().getTime();
        Map<Integer, Integer> timeMap = notifyParam.getNotifyParams();
        if (notifyTimes < maxNotifyTime) {
            Integer nextKey = notifyTimes + 1;
            Integer next = timeMap.get(nextKey);
            if (next != null) {
                time += 1000 * 60 * next + 1;
                notifyRecord.setLastNotifyTime(new Date(time));
                App.tasks.put(new NotifyTask(notifyRecord, this, notifyParam));
            }
        } else {
            try {
                // 持久化到数据库中
                notifyPersist.updateNotifyRord(notifyRecord.getId(),
                        notifyRecord.getNotifyTimes(), NotifyStatusEnum.FAILED.name());
                LOG.info("Update NotifyRecord failed,merchantNo:" + notifyRecord.getMerchantNo() + ",merchantOrderNo:"
                        + notifyRecord.getMerchantOrderNo());
            } catch (Exception e) {
                LOG.error(e);
            }
        }
    }
}
