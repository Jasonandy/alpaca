package cn.ucaner.alpaca.pay.user.dao;

import cn.ucaner.alpaca.pay.common.dao.BaseDao;
import cn.ucaner.alpaca.pay.user.entity.RpUserPayInfo;

/**
* @Package：cn.ucaner.alpaca.pay.user.dao   
* @ClassName：RpUserPayInfoDao   
* @Description：   <p> 用户第三方支付信息dao</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午9:39:52   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public interface RpUserPayInfoDao  extends BaseDao<RpUserPayInfo> {

    /**
     * 通过商户编号获取商户第三方支付信息
     * @param userNo
     * @param payWayCode
     * @return
     */
    public  RpUserPayInfo getByUserNo(String userNo, String payWayCode);

}