package cn.ucaner.alpaca.pay.user.entity;

import java.io.Serializable;

import cn.ucaner.alpaca.pay.common.core.entity.BaseEntity;

/**
* @Package：cn.ucaner.alpaca.pay.user.entity   
* @ClassName：RpUserPayInfo   
* @Description：   <p> 用户第三方支付信息实体类</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午9:44:18   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class RpUserPayInfo extends BaseEntity implements Serializable {

	/**
	 * 对应关系
	 * 微信：appid
	 * 支付宝：partner
	 */
    private String appId;

    private String appSectet;

    /**
     * 对应关系
     * 微信：merchantid
     * 支付宝：seller_id
     */
    private String merchantId;

    private String appType;

    private String userNo;

    private String userName;
    
    /**
     * 对应关系
     * 微信：partnerkey
     * 支付宝：key
     */
    private String partnerKey;
    
    private String payWayCode;

    private String payWayName;
    
    /**
     * 支付宝线下产品appid
     */
    private String offlineAppId;
    /**
     * 支付宝私钥
     */
    private String rsaPrivateKey;
    
    /**
     * 支付宝公钥
     */
    private String rsaPublicKey;

    public String getOfflineAppId() {
		return offlineAppId;
	}

	public void setOfflineAppId(String offlineAppId) {
		this.offlineAppId = offlineAppId;
	}

	public String getRsaPrivateKey() {
		return rsaPrivateKey;
	}

	public void setRsaPrivateKey(String rsaPrivateKey) {
		this.rsaPrivateKey = rsaPrivateKey;
	}

	public String getRsaPublicKey() {
		return rsaPublicKey;
	}

	public void setRsaPublicKey(String rsaPublicKey) {
		this.rsaPublicKey = rsaPublicKey;
	}

	public String getPayWayCode() {
		return payWayCode;
	}

	public void setPayWayCode(String payWayCode) {
		this.payWayCode = payWayCode;
	}

	public String getPayWayName() {
		return payWayName;
	}

	public void setPayWayName(String payWayName) {
		this.payWayName = payWayName;
	}

	public String getPartnerKey() {
		return partnerKey;
	}

	public void setPartnerKey(String partnerKey) {
		this.partnerKey = partnerKey;
	}

	private static final long serialVersionUID = 1L;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getAppSectet() {
        return appSectet;
    }

    public void setAppSectet(String appSectet) {
        this.appSectet = appSectet == null ? null : appSectet.trim();
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType == null ? null : appType.trim();
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
}