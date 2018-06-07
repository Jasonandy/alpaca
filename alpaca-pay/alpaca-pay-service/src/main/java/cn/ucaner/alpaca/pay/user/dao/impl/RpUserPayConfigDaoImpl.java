package cn.ucaner.alpaca.pay.user.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.ucaner.alpaca.pay.common.dao.impl.BaseDaoImpl;
import cn.ucaner.alpaca.pay.common.enums.PublicStatusEnum;
import cn.ucaner.alpaca.pay.user.dao.RpUserPayConfigDao;
import cn.ucaner.alpaca.pay.user.entity.RpUserPayConfig;

/**
* @Package：cn.ucaner.alpaca.pay.user.dao.impl   
* @ClassName：RpUserPayConfigDaoImpl   
* @Description：   <p> 用户支付配置dao实现类 </p>
* @Author： -    
* @CreatTime：2018年5月11日 上午9:43:29   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
@Repository
public class RpUserPayConfigDaoImpl  extends BaseDaoImpl<RpUserPayConfig> implements RpUserPayConfigDao{
    @Override
    public RpUserPayConfig getByUserNo(String userNo, String auditStatus) {
        Map<String , Object> paramMap = new HashMap<String , Object>();
        paramMap.put("userNo",userNo);
        paramMap.put("status", PublicStatusEnum.ACTIVE.name());
        paramMap.put("auditStatus", auditStatus);
        return super.getBy(paramMap);
    }
}