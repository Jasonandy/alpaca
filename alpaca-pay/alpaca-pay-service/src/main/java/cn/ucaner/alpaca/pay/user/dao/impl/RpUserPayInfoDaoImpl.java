package cn.ucaner.alpaca.pay.user.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.ucaner.alpaca.pay.common.core.dao.impl.BaseDaoImpl;
import cn.ucaner.alpaca.pay.user.dao.RpUserPayInfoDao;
import cn.ucaner.alpaca.pay.user.entity.RpUserPayInfo;

/**
* @Package：cn.ucaner.alpaca.pay.user.dao.impl   
* @ClassName：RpUserPayInfoDaoImpl   
* @Description：   <p> 用户第三方支付信息dao实现类</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午9:43:06   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
@Repository
public class RpUserPayInfoDaoImpl  extends BaseDaoImpl<RpUserPayInfo> implements RpUserPayInfoDao{
    /**
     * 通过商户编号获取商户第三方支付信息
     *
     * @param userNo
     * @param payWayCode
     * @return
     */
    @Override
    public RpUserPayInfo getByUserNo(String userNo, String payWayCode) {
        Map<String , Object> paramMap = new HashMap<String , Object>();
        paramMap.put("userNo",userNo);
        paramMap.put("payWayCode",payWayCode);
        return super.getBy(paramMap);
    }
}