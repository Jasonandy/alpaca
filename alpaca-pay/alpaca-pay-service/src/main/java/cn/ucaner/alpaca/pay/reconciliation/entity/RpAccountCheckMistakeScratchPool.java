package cn.ucaner.alpaca.pay.reconciliation.entity;

import java.math.BigDecimal;
import java.util.Date;

import cn.ucaner.alpaca.pay.common.core.entity.BaseEntity;


/**
* @Package：cn.ucaner.alpaca.pay.reconciliation.entity   
* @ClassName：RpAccountCheckMistakeScratchPool   
* @Description：   <p> 对账暂存池.</p>
* @Author： -    
* @CreatTime：2018年5月10日 下午11:05:57   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public class RpAccountCheckMistakeScratchPool extends BaseEntity {

	private static final long serialVersionUID = -3462155769895979049L;

	/** 商品名称 **/
	private String productName;

	/** 商户订单号 **/
	private String merchantOrderNo;

	/** 流水号 **/
	private String trxNo;

	/** 银行流水号 **/
	private String bankOrderNo;

	private String bankTrxNo;

	private BigDecimal orderAmount;

	private BigDecimal platIncome;

	private BigDecimal feeRate;

	private BigDecimal platCost;

	private BigDecimal platProfit;

	private String payWayCode;

	private String payWayName;

	private Date paySuccessTime;

	private Date completeTime;

	private String isRefund;

	private Short refundTimes;

	private BigDecimal successRefundAmount;

	private String batchNo;

	private Date billDate;

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName == null ? null : productName.trim();
	}

	public String getMerchantOrderNo() {
		return merchantOrderNo;
	}

	public void setMerchantOrderNo(String merchantOrderNo) {
		this.merchantOrderNo = merchantOrderNo == null ? null : merchantOrderNo.trim();
	}

	public String getTrxNo() {
		return trxNo;
	}

	public void setTrxNo(String trxNo) {
		this.trxNo = trxNo == null ? null : trxNo.trim();
	}

	public String getBankOrderNo() {
		return bankOrderNo;
	}

	public void setBankOrderNo(String bankOrderNo) {
		this.bankOrderNo = bankOrderNo == null ? null : bankOrderNo.trim();
	}

	public String getBankTrxNo() {
		return bankTrxNo;
	}

	public void setBankTrxNo(String bankTrxNo) {
		this.bankTrxNo = bankTrxNo == null ? null : bankTrxNo.trim();
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public BigDecimal getPlatIncome() {
		return platIncome;
	}

	public void setPlatIncome(BigDecimal platIncome) {
		this.platIncome = platIncome;
	}

	public BigDecimal getFeeRate() {
		return feeRate;
	}

	public void setFeeRate(BigDecimal feeRate) {
		this.feeRate = feeRate;
	}

	public BigDecimal getPlatCost() {
		return platCost;
	}

	public void setPlatCost(BigDecimal platCost) {
		this.platCost = platCost;
	}

	public BigDecimal getPlatProfit() {
		return platProfit;
	}

	public void setPlatProfit(BigDecimal platProfit) {
		this.platProfit = platProfit;
	}

	public String getPayWayCode() {
		return payWayCode;
	}

	public void setPayWayCode(String payWayCode) {
		this.payWayCode = payWayCode == null ? null : payWayCode.trim();
	}

	public String getPayWayName() {
		return payWayName;
	}

	public void setPayWayName(String payWayName) {
		this.payWayName = payWayName == null ? null : payWayName.trim();
	}

	public Date getPaySuccessTime() {
		return paySuccessTime;
	}

	public void setPaySuccessTime(Date paySuccessTime) {
		this.paySuccessTime = paySuccessTime;
	}

	public Date getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public String getIsRefund() {
		return isRefund;
	}

	public void setIsRefund(String isRefund) {
		this.isRefund = isRefund == null ? null : isRefund.trim();
	}

	public Short getRefundTimes() {
		return refundTimes;
	}

	public void setRefundTimes(Short refundTimes) {
		this.refundTimes = refundTimes;
	}

	public BigDecimal getSuccessRefundAmount() {
		return successRefundAmount;
	}

	public void setSuccessRefundAmount(BigDecimal successRefundAmount) {
		this.successRefundAmount = successRefundAmount;
	}

}