package cn.ucaner.alpaca.pay.user.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.ucaner.alpaca.pay.common.core.exception.BizException;

/**
* @Package：cn.ucaner.alpaca.pay.user.exception   
* @ClassName：PayBizException   
* @Description：   <p> 支付业务异常类</p>
* @Author： -    
* @CreatTime：2018年5月10日 下午11:09:54   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public class PayBizException extends BizException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7163126205323125757L;

	/** 支付方式已存在 **/
    public static final int PAY_TYPE_IS_EXIST = 101;
    
    /** 支付产品已存在 **/
    public static final int PAY_PRODUCT_IS_EXIST = 102;
    
    /** 支付产品已关联数据 **/
    public static final int PAY_PRODUCT_HAS_DATA = 103;
    
    /** 用户支付配置已存在 **/
    public static final int USER_PAY_CONFIG_IS_EXIST = 104;
    
    /** 用户支付配置不存在 **/
    public static final int USER_PAY_CONFIG_IS_NOT_EXIST = 105;
    
    /** 用户支付配置已生效 **/
    public static final int USER_PAY_CONFIG_IS_EFFECTIVE = 106;
    
    /** 支付产品已生效 **/
    public static final int PAY_PRODUCT_IS_EFFECTIVE = 107;
    
    /** 支付产品不存在 **/
    public static final int PAY_PRODUCT_IS_NOT_EXIST = 108;
    
    /** 支付方式不存在 **/
    public static final int PAY_TYPE_IS_NOT_EXIST = 108;

    private static final Log LOG = LogFactory.getLog(PayBizException.class);

    public PayBizException() {
    }

    public PayBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }

    public PayBizException(int code, String msg) {
        super(code, msg);
    }

    public PayBizException print() {
        LOG.info("==>BizException, code:" + this.code + ", msg:" + this.msg);
        return this;
    }
}
