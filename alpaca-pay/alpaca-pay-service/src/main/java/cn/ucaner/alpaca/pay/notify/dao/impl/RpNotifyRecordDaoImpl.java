package cn.ucaner.alpaca.pay.notify.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.ucaner.alpaca.pay.common.dao.impl.BaseDaoImpl;
import cn.ucaner.alpaca.pay.notify.dao.RpNotifyRecordDao;
import cn.ucaner.alpaca.pay.notify.entity.RpNotifyRecord;

/**
* @Package：cn.ucaner.alpaca.pay.notify.dao.impl   
* @ClassName：RpNotifyRecordDaoImpl   
* @Description：   <p> RpNotifyRecordDaoImpl</p>
* @Author： -    
* @CreatTime：2018年6月7日 下午9:30:04   
* @Modify By：   
* @ModifyTime：  2018年6月7日
* @Modify marker：   
* @version    V1.0
 */
@Repository("rpNotifyRecordDao")
public class RpNotifyRecordDaoImpl extends BaseDaoImpl<RpNotifyRecord> implements RpNotifyRecordDao {


    @Override
    public RpNotifyRecord getNotifyByMerchantNoAndMerchantOrderNoAndNotifyType(String merchantNo, String merchantOrderNo, String notifyType) {
        Map<String , Object> paramMap = new HashMap<String , Object>();
        paramMap.put("merchantNo",merchantNo);
        paramMap.put("merchantOrderNo",merchantOrderNo);
        paramMap.put("notifyType",notifyType);
        return super.getBy(paramMap);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insertSelective(RpNotifyRecord record) {
        return 0;
    }

    @Override
    public RpNotifyRecord selectByPrimaryKey(String id) {
        return null;
    }


    @Override
    public int updateByPrimaryKey(RpNotifyRecord record) {
        return 0;
    }

}
