package cn.ucaner.alpaca.pay.account.entity;

import java.math.BigDecimal;
import java.util.Date;

import cn.ucaner.alpaca.pay.common.entity.BaseEntity;

/**
* @Package：cn.ucaner.alpaca.pay.account.entity   
* @ClassName：RpSettDailyCollect   
* @Description：   <p> 每日待结算汇总实体</p>
* @Author： - Jason   
* @CreatTime：2018年5月10日 下午10:29:26   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public class RpSettDailyCollect extends BaseEntity {

	private static final long serialVersionUID = 4096169383852235862L;

	/** 账户编号 **/
	private String accountNo;

	/** 用户名称 **/
	private String userName;

	/** 汇总日期 **/
	private Date collectDate;

	/** 汇总类型(参考枚举:SettDailyCollectTypeEnum) **/
	private String collectType;

	/** 结算批次号(结算之后再回写过来) **/
	private String batchNo;

	/** 交易总金额 **/
	private BigDecimal totalAmount = BigDecimal.ZERO;

	/** 交易总笔数 **/
	private Integer totalCount = 0;

	/** 结算状态(参考枚举:SettDailyCollectStatusEnum) **/
	private String settStatus;

	/** 风险预存期 **/
	private Integer riskDay;

	/**
	 * 账户编号
	 * 
	 * @return
	 */
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * 账户编号
	 * 
	 * @param accountNo
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo == null ? null : accountNo.trim();
	}

	/** 用户名称 **/
	public String getUserName() {
		return userName;
	}

	/** 用户名称 **/
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 汇总日期
	 * 
	 * @return
	 */
	public Date getCollectDate() {
		return collectDate;
	}

	/**
	 * 汇总日期
	 * 
	 * @param collectDate
	 */
	public void setCollectDate(Date collectDate) {
		this.collectDate = collectDate;
	}

	/**
	 * 汇总类型(参考枚举:SettDailyCollectTypeEnum)
	 * 
	 * @return
	 */
	public String getCollectType() {
		return collectType;
	}

	/**
	 * 汇总类型(参考枚举:SettDailyCollectTypeEnum)
	 * 
	 * @param collectType
	 */
	public void setCollectType(String collectType) {
		this.collectType = collectType;
	}

	/**
	 * 结算批次号(结算之后再回写过来)
	 * 
	 * @return
	 */
	public String getBatchNo() {
		return batchNo;
	}

	/**
	 * 结算批次号(结算之后再回写过来)
	 * 
	 * @param batchNo
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo == null ? null : batchNo.trim();
	}

	/**
	 * 交易总金额
	 * 
	 * @return
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	/**
	 * 交易总金额
	 * 
	 * @param totalAmount
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * 交易总笔数
	 * 
	 * @return
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * 交易总笔数
	 * 
	 * @param totalCount
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * 结算状态(参考枚举:SettDailyCollectStatusEnum)
	 * 
	 * @return
	 */
	public String getSettStatus() {
		return settStatus;
	}

	/**
	 * 结算状态(参考枚举:SettDailyCollectStatusEnum)
	 * 
	 * @param settStatus
	 */
	public void setSettStatus(String settStatus) {
		this.settStatus = settStatus;
	}

	/**
	 * 风险预存期
	 */
	public Integer getRiskDay() {
		return riskDay;
	}

	/**
	 * 风险预存期
	 */
	public void setRiskDay(Integer riskDay) {
		this.riskDay = riskDay;
	}

}