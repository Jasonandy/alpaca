package cn.ucaner.alpaca.pay.trade.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.ucaner.alpaca.pay.common.enums.PublicEnum;

/**
* @Package：cn.ucaner.alpaca.pay.trade.vo   
* @ClassName：OrderPayResultVo   
* @Description：   <p> 支付结果展示实体</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午9:52:54   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class OrderPayResultVo implements Serializable {

	private static final long serialVersionUID = -7764029802672631390L;

	/** 状态 **/
    private String status = PublicEnum.NO.name();

    /** 金额 **/
    private BigDecimal orderPrice;

    /** 商户页面通知结果地址 **/
    private String returnUrl;

    /** 产品名称 **/
    private String productName;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", status=").append(status);
        sb.append(", orderPrice=").append(orderPrice);
        sb.append(", returnUrl=").append(returnUrl);
        sb.append(", productName=").append(productName);
        sb.append("]");
        return sb.toString();
    }
}
