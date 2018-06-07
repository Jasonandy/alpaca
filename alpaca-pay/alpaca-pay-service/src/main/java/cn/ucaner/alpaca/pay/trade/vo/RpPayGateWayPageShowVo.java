package cn.ucaner.alpaca.pay.trade.vo;

import java.math.BigDecimal;
import java.util.Map;

import cn.ucaner.alpaca.pay.common.enums.PayWayEnum;

/**
* @Package：cn.ucaner.alpaca.pay.trade.vo   
* @ClassName：RpPayGateWayPageShowVo   
* @Description：   <p> 支付网关页面展示实体</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午9:50:32   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class RpPayGateWayPageShowVo {

    /** 订单金额 **/
    private BigDecimal orderAmount;

    /** 产品名称 **/
    private String productName;

    /** 商户名称 **/
    private String merchantName;

    /** 商户订单号 **/
    private String merchantOrderNo;

    /** 商户支付key **/
    private String payKey;

    /** 支付方式列表 **/
    private Map<String , PayWayEnum> payWayEnumMap;

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

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Map<String, PayWayEnum> getPayWayEnumMap() {
        return payWayEnumMap;
    }

    public void setPayWayEnumMap(Map<String, PayWayEnum> payWayEnumMap) {
        this.payWayEnumMap = payWayEnumMap;
    }

    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

    public String getPayKey() {
        return payKey;
    }

    public void setPayKey(String payKey) {
        this.payKey = payKey;
    }
}
