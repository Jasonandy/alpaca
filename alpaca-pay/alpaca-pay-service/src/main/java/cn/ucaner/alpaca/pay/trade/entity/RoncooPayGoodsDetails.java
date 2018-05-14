package cn.ucaner.alpaca.pay.trade.entity;

/**
* @Package：cn.ucaner.alpaca.pay.trade.entity   
* @ClassName：RoncooPayGoodsDetails   
* @Description：   <p> 支付商品明细描述</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:07:07   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class RoncooPayGoodsDetails {

    /** 构造函数 传入所需参数 **/
    public RoncooPayGoodsDetails (String goodsId , String goodsName ,Long singlePrice , Integer nums){
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.singlePrice = singlePrice;
        this.nums = nums;
    }

    /** 商品ID **/
    private String goodsId;

    /** 名称 **/
    private String goodsName;

    /** 单价 **/
    private Long singlePrice;

    /** 数量 **/
    private Integer nums;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(Long singlePrice) {
        this.singlePrice = singlePrice;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }
}
