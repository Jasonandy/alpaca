package cn.ucaner.alpaca.pay.reconciliation.service;

import java.util.List;

import cn.ucaner.alpaca.pay.reconciliation.entity.RpAccountCheckBatch;
import cn.ucaner.alpaca.pay.reconciliation.entity.RpAccountCheckMistake;
import cn.ucaner.alpaca.pay.reconciliation.entity.RpAccountCheckMistakeScratchPool;

/**
* @Package：cn.ucaner.alpaca.pay.reconciliation.service   
* @ClassName：RpAccountCheckTransactionService   
* @Description：   <p> 对账数据事务一致性service. </p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:31:33   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public interface RpAccountCheckTransactionService {

	/**
	 * 保存
	 */
	void saveDatasaveDate(RpAccountCheckBatch batch, List<RpAccountCheckMistake> mistakeList, List<RpAccountCheckMistakeScratchPool> insertScreatchRecordList, List<RpAccountCheckMistakeScratchPool> removeScreatchRecordList);

	/**
	 * 
	 * @param list
	 * @param mistakeList
	 */
	void removeDateFromPool(List<RpAccountCheckMistakeScratchPool> list, List<RpAccountCheckMistake> mistakeList);

	/**
	 * 差错处理
	 * 
	 * @param id
	 *            差错记录id
	 * @param handleType
	 *            差错处理方式
	 * @param handleRemark
	 *            差错备注
	 */
	void handle(String id, String handleType, String handleRemark);

}