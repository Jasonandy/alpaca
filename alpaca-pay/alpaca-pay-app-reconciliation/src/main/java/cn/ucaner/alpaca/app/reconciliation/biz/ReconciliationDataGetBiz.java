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

import cn.ucaner.alpaca.pay.trade.entity.RpTradePaymentRecord;
import cn.ucaner.alpaca.pay.trade.enums.TradeStatusEnum;
import cn.ucaner.alpaca.pay.trade.service.RpTradePaymentQueryService;

/**
* @Package：cn.ucaner.alpaca.app.reconciliation.biz   
* @ClassName：ReconciliationDataGetBiz   
* @Description：   <p> 平台数据获取biz业务类</p>
* @Author： -    
* @CreatTime：2018年5月12日 下午2:49:03   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
@Component("reconciliationDataGetBiz")
public class ReconciliationDataGetBiz {

	private static final Log LOG = LogFactory.getLog(ReconciliationDataGetBiz.class);

	@Autowired
	private RpTradePaymentQueryService rpTradePaymentQueryService;

	/**
	 * 获取平台指定支付渠道、指定订单日下[所有成功]的数据
	 * 
	 * @param billDate
	 *            账单日
	 * @param interfaceCode
	 *            支付渠道
	 * @return
	 */
	public List<RpTradePaymentRecord> getSuccessPlatformDateByBillDate(Date billDate, String interfaceCode) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String billDateStr = sdf.format(billDate);

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("billDate", billDateStr);
		paramMap.put("interfaceCode", interfaceCode);
		paramMap.put("status", TradeStatusEnum.SUCCESS.name());

		LOG.info("开始查询平台支付成功的数据：billDate[" + billDateStr + "],支付方式为[" + interfaceCode + "]");
		List<RpTradePaymentRecord> recordList = rpTradePaymentQueryService.listPaymentRecord(paramMap);
		if (recordList == null) {
			recordList = new ArrayList<RpTradePaymentRecord>();
		}
		LOG.info("查询得到的数据count[" + recordList.size() + "]");
		return recordList;

	}

	/**
	 * 获取平台指定支付渠道、指定订单日下[所有]的数据
	 * 
	 * @param billDate
	 *            账单日
	 * @param interfaceCode
	 *            支付渠道
	 * @return
	 */
	public List<RpTradePaymentRecord> getAllPlatformDateByBillDate(Date billDate, String interfaceCode) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String billDateStr = sdf.format(billDate);

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("billDate", billDateStr);
		paramMap.put("interfaceCode", interfaceCode);

		LOG.info("开始查询平台支付所有的数据：billDate[" + billDateStr + "],支付方式为[" + interfaceCode + "]");
		List<RpTradePaymentRecord> recordList = rpTradePaymentQueryService.listPaymentRecord(paramMap);
		if (recordList == null) {
			recordList = new ArrayList<RpTradePaymentRecord>();
		}
		LOG.info("查询得到的数据count[" + recordList.size() + "]");

		return recordList;

	}
}
