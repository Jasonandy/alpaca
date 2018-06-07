package cn.ucaner.alpaca.pay.notify.dao;


import cn.ucaner.alpaca.pay.common.dao.BaseDao;
import cn.ucaner.alpaca.pay.notify.entity.RpNotifyRecordLog;

/**
* @Package：cn.ucaner.alpaca.pay.notify.dao   
* @ClassName：RpNotifyRecordLogDao   
* @Description：   <p> RpNotifyRecordLogDao </p>
* @Author： -    
* @CreatTime：2018年6月7日 下午9:29:49   
* @Modify By：   
* @ModifyTime：  2018年6月7日
* @Modify marker：   
* @version    V1.0
 */
public interface RpNotifyRecordLogDao  extends BaseDao<RpNotifyRecordLog> {


    int deleteByPrimaryKey(String id);

    int insertSelective(RpNotifyRecordLog record);

    RpNotifyRecordLog selectByPrimaryKey(String id);


    int updateByPrimaryKey(RpNotifyRecordLog record);
}