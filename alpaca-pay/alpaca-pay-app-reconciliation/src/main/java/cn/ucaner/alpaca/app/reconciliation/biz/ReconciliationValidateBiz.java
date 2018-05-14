package cn.ucaner.alpaca.app.reconciliation.biz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.ucaner.alpaca.app.reconciliation.utils.DateUtil;
import cn.ucaner.alpaca.pay.reconciliation.entity.RpAccountCheckBatch;
import cn.ucaner.alpaca.pay.reconciliation.entity.RpAccountCheckMistake;
import cn.ucaner.alpaca.pay.reconciliation.entity.RpAccountCheckMistakeScratchPool;
import cn.ucaner.alpaca.pay.reconciliation.enums.BatchStatusEnum;
import cn.ucaner.alpaca.pay.reconciliation.enums.MistakeHandleStatusEnum;
import cn.ucaner.alpaca.pay.reconciliation.enums.ReconciliationMistakeTypeEnum;
import cn.ucaner.alpaca.pay.reconciliation.service.RpAccountCheckBatchService;
import cn.ucaner.alpaca.pay.reconciliation.service.RpAccountCheckMistakeScratchPoolService;
import cn.ucaner.alpaca.pay.reconciliation.service.RpAccountCheckTransactionService;

/**
* @Package：cn.ucaner.alpaca.app.reconciliation.biz   
* @ClassName：ReconciliationValidateBiz   
* @Description：   <p> 对账验证biz，(检查是否已经对过账)</p>
* @Author： -    
* @CreatTime：2018年5月12日 下午2:46:28   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
@Component("reconciliationValidateBiz")
public class ReconciliationValidateBiz {

	private static final Log LOG = LogFactory.getLog(ReconciliationValidateBiz.class);

	@Autowired
	private RpAccountCheckBatchService rpAccountCheckBatchService;
	@Autowired
	private RpAccountCheckTransactionService rpAccountCheckTransactionService;
	@Autowired
	private RpAccountCheckMistakeScratchPoolService rpAccountCheckMistakeScratchPoolService;

	/**
	 * 判断某支付方式某天是否对过账，避免重复对账
	 * 
	 * @param interfaceCode
	 *            支付方式
	 * @param billDate
	 *            账单日
	 * @return
	 */
	public Boolean isChecked(String interfaceCode, Date billDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String billDateStr = sdf.format(billDate);
		LOG.info("检查,支付方式[" + interfaceCode + "],订单日期[" + billDateStr + "]");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("billDate", billDateStr);
		paramMap.put("interfaceCode", interfaceCode);
		// 除非对账错误或者对账异常才可以发起第二次对账
		paramMap.put("status", BatchStatusEnum.ERROR.name() + "," + BatchStatusEnum.FAIL.name());

		List<RpAccountCheckBatch> list = rpAccountCheckBatchService.listBy(paramMap);
		if (list.isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * 如果缓冲池中有三天前的数据就清理掉并记录差错
	 */
	public void validateScratchPool() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(DateUtil.addDay(new Date(), -3));
		// 查询是否有创建时间是三天前的数据
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("maxDate", dateStr);
		List<RpAccountCheckMistakeScratchPool> list = rpAccountCheckMistakeScratchPoolService.listScratchPoolRecord(paramMap);
		List<RpAccountCheckMistake> mistakeList = null;
		// 如果有数据
		if (!list.isEmpty()) {
			mistakeList = new ArrayList<RpAccountCheckMistake>();
			for (RpAccountCheckMistakeScratchPool scratchRecord : list) {
				// 创建差错记录
				RpAccountCheckMistake mistake = new RpAccountCheckMistake();
				mistake.setAccountCheckBatchNo(scratchRecord.getBatchNo());
				mistake.setBillDate(scratchRecord.getBillDate());
				mistake.setErrType(ReconciliationMistakeTypeEnum.BANK_MISS.name());
				mistake.setHandleStatus(MistakeHandleStatusEnum.NOHANDLE.name());
				mistake.setBankType(scratchRecord.getPayWayCode());

				mistake.setOrderNo(scratchRecord.getMerchantOrderNo());
				mistake.setTradeTime(scratchRecord.getPaySuccessTime());
				mistake.setTrxNo(scratchRecord.getTrxNo());
				mistake.setOrderAmount(scratchRecord.getOrderAmount());
				mistake.setRefundAmount(scratchRecord.getSuccessRefundAmount());
				mistake.setTradeStatus(scratchRecord.getStatus());
				mistake.setFee(scratchRecord.getPlatCost());
				mistakeList.add(mistake);
			}

			rpAccountCheckTransactionService.removeDateFromPool(list, mistakeList);

		}

	}
}
