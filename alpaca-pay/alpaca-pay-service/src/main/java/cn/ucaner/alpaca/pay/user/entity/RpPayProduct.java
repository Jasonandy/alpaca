package cn.ucaner.alpaca.pay.user.entity;

import java.io.Serializable;

import cn.ucaner.alpaca.pay.common.core.entity.BaseEntity;
import cn.ucaner.alpaca.pay.common.core.enums.PublicEnum;

/**
* @Package：cn.ucaner.alpaca.pay.user.entity   
* @ClassName：RpPayProduct   
* @Description：   <p> 支付产品实体类</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午9:47:18   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class RpPayProduct extends BaseEntity implements Serializable {

    private String productCode;

    private String productName;
    
    private String auditStatus;

    private static final long serialVersionUID = 1L;

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

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }
    
    public String getAuditStatusDesc() {
    	return PublicEnum.getEnum(this.getAuditStatus()).getDesc();
    }
}