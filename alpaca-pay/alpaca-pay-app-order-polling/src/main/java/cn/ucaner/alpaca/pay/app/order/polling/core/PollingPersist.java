package cn.ucaner.alpaca.pay.app.order.polling.core;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ucaner.alpaca.pay.common.exception.BizException;
import cn.ucaner.alpaca.pay.notify.entity.RpOrderResultQueryVo;
import cn.ucaner.alpaca.pay.trade.service.RpTradePaymentManagerService;

/**
* @Package：cn.ucaner.alpaca.pay.app.order.polling.core   
* @ClassName：PollingPersist   
* @Description：   <p> pollingPersist</p>
* @Author： -    
* @CreatTime：2018年5月12日 下午1:58:16   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
@Service("pollingPersist")
public class PollingPersist {

    private static final Logger LOG = LoggerFactory.getLogger(PollingPersist.class);

    @Autowired
    private PollingQueue pollingQueue;

    @Autowired
    private RpTradePaymentManagerService rpTradePaymentManagerService;
    
    /**
     * 获取订单结果
     * @param rpOrderResultQueryVo
     */
    public void getOrderResult(RpOrderResultQueryVo rpOrderResultQueryVo){
    	Integer notifyTimes = rpOrderResultQueryVo.getNotifyTimes(); // 得到当前通知对象的通知次数
        Integer maxNotifyTimes = rpOrderResultQueryVo.getLimitNotifyTimes(); // 最大通知次数
        Date notifyTime = new Date(); // 本次通知的时间
        rpOrderResultQueryVo.setEditTime(notifyTime); // 取本次通知时间作为最后修改时间
        rpOrderResultQueryVo.setNotifyTimes(notifyTimes + 1); // 通知次数+1

        LOG.info("notifyTimes:{}  , maxNotifyTimes:{} " ,notifyTimes , maxNotifyTimes);
        try{
            boolean processingResult = rpTradePaymentManagerService.processingTradeRecord(rpOrderResultQueryVo.getBankOrderNo());

            LOG.info("order processing result:{}" ,processingResult);
            if (!processingResult){//返回失败,说明还未支付
                // 通知不成功（返回的结果不是success）
                if (rpOrderResultQueryVo.getNotifyTimes() < maxNotifyTimes) {
                    // 判断是否超过重发次数，未超重发次数的，再次进入延迟发送队列
                    pollingQueue.addToNotifyTaskDelayQueue(rpOrderResultQueryVo);
                    LOG.info("===>bank order {} need processing again ", rpOrderResultQueryVo.getBankOrderNo());
                } else {
                    LOG.info("bank order No {} not pay" , rpOrderResultQueryVo.getBankOrderNo());
                }
            }

        }catch (BizException e){
            LOG.error("订单处理业务异常:", e);
            if (rpOrderResultQueryVo.getNotifyTimes() < maxNotifyTimes) {
                // 判断是否超过重发次数，未超重发次数的，再次进入延迟发送队列
                pollingQueue.addToNotifyTaskDelayQueue(rpOrderResultQueryVo);
                LOG.info("===>bank order {} need processing again ", rpOrderResultQueryVo.getBankOrderNo());
            } else {
                LOG.info("bank order No {} not pay" , rpOrderResultQueryVo.getBankOrderNo());
            }
        }catch (Exception e){
            LOG.error("订单处理系统异常:", e);
            if (rpOrderResultQueryVo.getNotifyTimes() < maxNotifyTimes) {
                // 判断是否超过重发次数，未超重发次数的，再次进入延迟发送队列
                pollingQueue.addToNotifyTaskDelayQueue(rpOrderResultQueryVo);
                LOG.info("===>bank order {} need processing again ", rpOrderResultQueryVo.getBankOrderNo());
            } else {
                LOG.info("bank order No {} not pay" , rpOrderResultQueryVo.getBankOrderNo());
            }
        }
    }



}
