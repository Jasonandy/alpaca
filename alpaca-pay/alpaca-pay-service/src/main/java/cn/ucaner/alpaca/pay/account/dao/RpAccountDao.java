package cn.ucaner.alpaca.pay.account.dao;

import java.util.Map;

import cn.ucaner.alpaca.pay.account.entity.RpAccount;
import cn.ucaner.alpaca.pay.common.dao.BaseDao;

/**
* @Package：cn.ucaner.alpaca.pay.account.dao   
* @ClassName：RpAccountDao   
* @Description：   <p>  账户dao</p>
* @Author： - Jason   
* @CreatTime：2018年5月10日 下午10:31:59   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public interface RpAccountDao  extends BaseDao<RpAccount> {
	
	RpAccount getByAccountNo(String accountNo);

	RpAccount getByUserNo(Map<String, Object> map);
}