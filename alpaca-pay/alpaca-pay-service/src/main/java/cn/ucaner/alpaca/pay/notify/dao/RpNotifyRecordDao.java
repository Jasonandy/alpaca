package cn.ucaner.alpaca.pay.notify.dao;

import cn.ucaner.alpaca.pay.common.dao.BaseDao;
import cn.ucaner.alpaca.pay.notify.entity.RpNotifyRecord;

/**
* @Package：cn.ucaner.alpaca.pay.notify.dao   
* @ClassName：RpNotifyRecordDao   
* @Description：   <p> RpNotifyRecordDao </p>
* @Author： -    
* @CreatTime：2018年6月7日 下午9:29:37   
* @Modify By：   
* @ModifyTime：  2018年6月7日
* @Modify marker：   
* @version    V1.0
 */
public interface RpNotifyRecordDao  extends BaseDao<RpNotifyRecord> {

    RpNotifyRecord getNotifyByMerchantNoAndMerchantOrderNoAndNotifyType(String merchantNo, String merchantOrderNo, String notifyType);

    int deleteByPrimaryKey(String id);

    int insertSelective(RpNotifyRecord record);

    RpNotifyRecord selectByPrimaryKey(String id);

    int updateByPrimaryKey(RpNotifyRecord record);
}