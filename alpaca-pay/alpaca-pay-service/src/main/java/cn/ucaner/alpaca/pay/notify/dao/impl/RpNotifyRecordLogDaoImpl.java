package cn.ucaner.alpaca.pay.notify.dao.impl;

import org.springframework.stereotype.Repository;

import cn.ucaner.alpaca.pay.common.core.dao.impl.BaseDaoImpl;
import cn.ucaner.alpaca.pay.notify.dao.RpNotifyRecordLogDao;
import cn.ucaner.alpaca.pay.notify.entity.RpNotifyRecordLog;

@Repository("rpNotifyRecordLogDao")
public class RpNotifyRecordLogDaoImpl extends BaseDaoImpl<RpNotifyRecordLog> implements RpNotifyRecordLogDao {
    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insertSelective(RpNotifyRecordLog record) {
        return 0;
    }

    @Override
    public RpNotifyRecordLog selectByPrimaryKey(String id) {
        return null;
    }


    @Override
    public int updateByPrimaryKey(RpNotifyRecordLog record) {
        return 0;
    }
}
