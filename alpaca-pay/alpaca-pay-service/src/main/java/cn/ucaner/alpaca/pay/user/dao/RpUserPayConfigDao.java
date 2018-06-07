package cn.ucaner.alpaca.pay.user.dao;

import cn.ucaner.alpaca.pay.common.dao.BaseDao;
import cn.ucaner.alpaca.pay.user.entity.RpUserPayConfig;

/**
* @Package：cn.ucaner.alpaca.pay.user.dao   
* @ClassName：RpUserPayConfigDao   
* @Description：   <p>  用户支付配置dao</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午9:40:09   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public interface RpUserPayConfigDao  extends BaseDao<RpUserPayConfig> {

    /**
     * 根据用户编号获取用户支付信息
     * @param userNo
     * @return
     */
    RpUserPayConfig getByUserNo(String userNo, String auditStatus);

}