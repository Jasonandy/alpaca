package cn.ucaner.alpaca.pay.notify.dao;


import cn.ucaner.alpaca.pay.common.core.dao.BaseDao;
import cn.ucaner.alpaca.pay.notify.entity.RpNotifyRecordLog;


public interface RpNotifyRecordLogDao  extends BaseDao<RpNotifyRecordLog> {


    int deleteByPrimaryKey(String id);

    int insertSelective(RpNotifyRecordLog record);

    RpNotifyRecordLog selectByPrimaryKey(String id);


    int updateByPrimaryKey(RpNotifyRecordLog record);
}