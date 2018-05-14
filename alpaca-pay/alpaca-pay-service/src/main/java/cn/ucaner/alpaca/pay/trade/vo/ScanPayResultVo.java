package cn.ucaner.alpaca.pay.trade.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
* @Package：cn.ucaner.alpaca.pay.trade.vo   
* @ClassName：ScanPayResultVo   
* @Description：   <p> 扫码支付结果展示实体 </p>
* @Author： -    
* @CreatTime：2018年5月11日 上午9:50:10   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class ScanPayResultVo implements Serializable {

	private static final long serialVersionUID = 3423417940570942790L;

	/**
     * 支付方式编码
     */
    private String payWayCode;

    /** 金额 **/
    private BigDecimal orderAmount;

    /** 产品名称 **/
    private String productName;

    /**
     * 二维码地址
     */
    private String codeUrl;

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public String getPayWayCode() {
        return payWayCode;
    }

    public void setPayWayCode(String payWayCode) {
        this.payWayCode = payWayCode;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
