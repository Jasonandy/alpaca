package cn.ucaner.alpaca.pay.app.order.polling.entity;

import java.util.Map;

/**
* @Package：cn.ucaner.alpaca.pay.app.order.polling.entity   
* @ClassName：PollingParam   
* @Description：   <p> PollingParam</p>
* @Author： -    
* @CreatTime：2018年5月12日 下午2:00:51   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
public class PollingParam {

    /**
     * 通知参数（通知规则Map）
     */
    private Map<Integer, Integer> notifyParams;

    /**
     * 通知后用于判断是否成功的返回值（成功标识）,由HttpResponse获取
     */
    private String successValue;

    public Map<Integer, Integer> getNotifyParams() {
        return notifyParams;
    }

    public void setNotifyParams(Map<Integer, Integer> notifyParams) {
        this.notifyParams = notifyParams;
    }

    public String getSuccessValue() {
        return successValue;
    }

    public void setSuccessValue(String successValue) {
        this.successValue = successValue;
    }

    /**
     * 最大通知次数限制.
     * @return
     */
    public Integer getMaxNotifyTimes() {
        return notifyParams == null ? 0 : notifyParams.size();
    }

}
