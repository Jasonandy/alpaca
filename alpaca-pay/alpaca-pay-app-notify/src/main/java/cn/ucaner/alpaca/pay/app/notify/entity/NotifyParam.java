package cn.ucaner.alpaca.pay.app.notify.entity;

import java.util.Map;

/**
* @Package：cn.alpaca.pay.app.notify.entity   
* @ClassName：NotifyParam   
* @Description：   <p> 通知参数</p>
* @Author： -    
* @CreatTime：2018年5月12日 下午1:42:03   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
public class NotifyParam {

    private Map<Integer, Integer> notifyParams;// 通知时间次数map
    private String successValue;// 通知后用于判断是否成功的返回值。由HttpResponse获取

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

    public Integer getMaxNotifyTime() {
        return notifyParams == null ? 0 : notifyParams.size();
    }

}
