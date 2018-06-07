package cn.ucaner.alpaca.pay.user.dao.impl;

import org.springframework.stereotype.Repository;

import cn.ucaner.alpaca.pay.common.dao.impl.BaseDaoImpl;
import cn.ucaner.alpaca.pay.user.dao.BuildNoDao;
import cn.ucaner.alpaca.pay.user.entity.SeqBuild;

/**
* @Package：cn.ucaner.alpaca.pay.user.dao.impl   
* @ClassName：BuildNoDaoImpl   
* @Description：   <p> 生成编号dao实现类 </p>
* @Author： -    
* @CreatTime：2018年5月11日 上午9:49:34   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
@Repository
public class BuildNoDaoImpl   extends BaseDaoImpl<SeqBuild> implements BuildNoDao {

    @Override
    public String getSeqNextValue(SeqBuild seqBuild) {
        return super.getSqlSession().selectOne(getStatement("getSeqNextValue"),seqBuild);
    }
}
