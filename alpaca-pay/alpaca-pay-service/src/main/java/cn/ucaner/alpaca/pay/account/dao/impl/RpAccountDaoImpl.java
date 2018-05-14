package cn.ucaner.alpaca.pay.account.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.ucaner.alpaca.pay.account.dao.RpAccountDao;
import cn.ucaner.alpaca.pay.account.entity.RpAccount;
import cn.ucaner.alpaca.pay.common.core.dao.impl.BaseDaoImpl;
import cn.ucaner.alpaca.pay.common.core.enums.PublicStatusEnum;

/**
* @Package：cn.ucaner.alpaca.pay.account.dao.impl   
* @ClassName：RpAccountDaoImpl   
* @Description：   <p> 账户dao实现类</p>
* @Author： - Jason   
* @CreatTime：2018年5月10日 下午10:23:25   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
@Repository
public class RpAccountDaoImpl  extends BaseDaoImpl<RpAccount> implements RpAccountDao{
	
	public RpAccount getByAccountNo(String accountNo){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("accountNo", accountNo);
		paramMap.put("status", PublicStatusEnum.ACTIVE.name());
		return this.getBy(paramMap);
	}

	public RpAccount getByUserNo(Map<String, Object> map){
		return this.getSessionTemplate().selectOne(getStatement("getByUserNo"), map);
	}
}