package cn.ucaner.alpaca.pay.user.dao;

import cn.ucaner.alpaca.pay.common.core.dao.BaseDao;
import cn.ucaner.alpaca.pay.user.entity.SeqBuild;

/**
* @Package：cn.ucaner.alpaca.pay.user.dao   
* @ClassName：BuildNoDao   
* @Description：   <p> 生成编号dao</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午9:42:41   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public interface BuildNoDao extends BaseDao<SeqBuild> {

    public String getSeqNextValue(SeqBuild seqBuild);

}
