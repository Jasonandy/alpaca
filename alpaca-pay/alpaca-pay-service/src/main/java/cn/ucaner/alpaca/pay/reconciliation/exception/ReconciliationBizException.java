package cn.ucaner.alpaca.pay.reconciliation.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.ucaner.alpaca.pay.common.exception.BizException;

/**
* @Package：cn.ucaner.alpaca.pay.reconciliation.exception   
* @ClassName：ReconciliationBizException   
* @Description：   <p> 对账业务 .</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:37:53   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class ReconciliationBizException extends BizException {

	private static final long serialVersionUID = 1L;

	/** 根据银行订单号查询的支付记录不存在 **/
	public static final int TRADE_ORDER_NO_EXCIT = 20020001;

	private static final Log LOG = LogFactory.getLog(ReconciliationBizException.class);

	public ReconciliationBizException() {
	}

	public ReconciliationBizException(int code, String msgFormat, Object... args) {
		super(code, msgFormat, args);
	}

	public ReconciliationBizException(int code, String msg) {
		super(code, msg);
	}

	public ReconciliationBizException print() {
		LOG.info("==>BizException, code:" + this.code + ", msg:" + this.msg);
		return this;
	}
}
