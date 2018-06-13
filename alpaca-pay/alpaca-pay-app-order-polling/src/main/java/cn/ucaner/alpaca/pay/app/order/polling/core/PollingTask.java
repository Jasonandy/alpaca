package cn.ucaner.alpaca.pay.app.order.polling.core;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ucaner.alpaca.pay.app.order.polling.App;
import cn.ucaner.alpaca.pay.common.utils.DateUtils;
import cn.ucaner.alpaca.pay.notify.entity.RpOrderResultQueryVo;

/**
* @Package：cn.ucaner.alpaca.pay.app.order.polling.core   
* @ClassName：PollingTask   
* @Description：   <p> PollingTask</p>
* @Author： -    
* @CreatTime：2018年5月12日 下午1:59:54   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
public class PollingTask implements Runnable, Delayed {

    private static final Logger logger = LoggerFactory.getLogger(PollingTask.class);

    private long executeTime;

    private PollingPersist pollingPersist = App.pollingPersist;

    private RpOrderResultQueryVo rpOrderResultQueryVo;

    public PollingTask() {
    }

    public PollingTask(RpOrderResultQueryVo rpOrderResultQueryVo) {
        super();
        this.rpOrderResultQueryVo = rpOrderResultQueryVo;
        this.executeTime = getExecuteTime(rpOrderResultQueryVo);
    }

    /**
     * 计算任务允许执行的开始时间(executeTime).<br/>
     *
     * @param rpOrderResultQueryVo
     * @return
     */
    private long getExecuteTime(RpOrderResultQueryVo rpOrderResultQueryVo) {
        long lastNotifyTime = rpOrderResultQueryVo.getLastNotifyTime().getTime(); // 最后通知时间（上次通知时间）
        Integer notifyTimes = rpOrderResultQueryVo.getNotifyTimes(); // 已通知次数
        logger.info("===>pollingTimes:{}",notifyTimes);
        //Integer nextNotifyTimeInterval = pollingParam.getNotifyParams().get(notifyTimes + 1); // 当前发送次数对应的时间间隔数（分钟数）
        Integer nextNotifyTimeInterval = rpOrderResultQueryVo.getNotifyRuleMap().get(String.valueOf(notifyTimes + 1)); // 当前发送次数对应的时间间隔数（分钟数）
        long nextNotifyTime = (nextNotifyTimeInterval == null ? 0 : nextNotifyTimeInterval * 1000) + lastNotifyTime;
        logger.info("===>notify id:{}, nextNotifyTime:{}" ,rpOrderResultQueryVo.getId() , DateUtils.formatDate(new Date(nextNotifyTime), "yyyy-MM-dd HH:mm:ss SSS"));
        return nextNotifyTime;
    }

    /**
     * 比较当前时间(task.executeTime)与任务允许执行的开始时间(executeTime).<br/>
     * 如果当前时间到了或超过任务允许执行的开始时间，那么就返回-1，可以执行。
     */
    public int compareTo(Delayed o) {
        PollingTask task = (PollingTask) o;
        return executeTime > task.executeTime ? 1 : (executeTime < task.executeTime ? -1 : 0);
    }

    public long getDelay(TimeUnit unit) {
        return unit.convert(executeTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    /**
     * 执行通知处理.
     */
    public void run() {
        pollingPersist.getOrderResult(rpOrderResultQueryVo);
    }
}
