package cn.ucaner.alpaca.pay.user.entity;

import java.io.Serializable;

import cn.ucaner.alpaca.pay.common.entity.BaseEntity;
import cn.ucaner.alpaca.pay.common.enums.PublicEnum;
import cn.ucaner.alpaca.pay.common.enums.SecurityRatingEnum;
import cn.ucaner.alpaca.pay.user.enums.FundInfoTypeEnum;

/**
* @Package：cn.ucaner.alpaca.pay.user.entity   
* @ClassName：RpUserPayConfig   
* @Description：   <p> 用户支付配置实体类</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午9:43:50   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class RpUserPayConfig extends BaseEntity implements Serializable {

	/**
	 * auditStatus 审计状态
	 */
    private String auditStatus;

    /**
     * 
     */
    private String isAutoSett;

    /**
     * 产品码
     */
    private String productCode;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 用户号
     */
    private String userNo;

    private String userName;

    private Integer riskDay;
    
    private String payKey;
    
    private String fundIntoType;

    private String paySecret;

    /** 安全等级 **/
    private String securityRating = SecurityRatingEnum.MD5.name(); //MD5("MD5") MD5_IP("MD5+IP白名单");  

    /**商户服务器IP **/
    private String merchantServerIp;

    public String getPaySecret() {
        return paySecret;
    }

    public void setPaySecret(String paySecret) {
        this.paySecret = paySecret;
    }

    public String getFundIntoType() {
        return fundIntoType;
    }

    public void setFundIntoType(String fundIntoType) {
        this.fundIntoType = fundIntoType;
    }

    private static final long serialVersionUID = 1L;

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    public String getIsAutoSett() {
        return isAutoSett;
    }

    public void setIsAutoSett(String isAutoSett) {
        this.isAutoSett = isAutoSett == null ? null : isAutoSett.trim();
    }
    
    public String getPayKey() {
		return payKey;
	}

	public void setPayKey(String payKey) {
		this.payKey = payKey;
	}

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getRiskDay() {
        return riskDay;
    }

    public void setRiskDay(Integer riskDay) {
        this.riskDay = riskDay;
    }

    public String getAuditStatusDesc() {
    	return PublicEnum.getEnum(this.getAuditStatus()).getDesc();
    }
    
    public String getFundIntoTypeDesc() {
    	return FundInfoTypeEnum.getEnum(this.getFundIntoType()).getDesc();
    }

    public String getSecurityRating() {
        return securityRating;
    }

    public void setSecurityRating(String securityRating) {
        this.securityRating = securityRating;
    }

    public String getMerchantServerIp() {
        return merchantServerIp;
    }

    public void setMerchantServerIp(String merchantServerIp) {
        this.merchantServerIp = merchantServerIp;
    }
}