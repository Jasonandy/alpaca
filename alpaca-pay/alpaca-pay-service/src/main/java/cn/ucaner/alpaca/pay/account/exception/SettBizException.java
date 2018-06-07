package cn.ucaner.alpaca.pay.account.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.ucaner.alpaca.pay.common.exception.BizException;

/**
* @Package：cn.ucaner.alpaca.pay.account.exception   
* @ClassName：SettBizException   
* @Description：   <p> 结算服务业务异常类,异常代码8位数字组成,前4位固定1001打头,后4位自定义 </p>
* @Author： - Jason   
* @CreatTime：2018年5月10日 下午10:38:03   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public class SettBizException extends BizException {

	private static final long serialVersionUID = 1L;
	private static final Log LOG = LogFactory.getLog(SettBizException.class);

	public static final SettBizException SETT_STATUS_ERROR = new SettBizException(10010001, "结算状态错误");

	public SettBizException() {
	}

	public SettBizException(int code, String msgFormat, Object... args) {
		super(code, msgFormat, args);
	}

	public SettBizException(int code, String msg) {
		super(code, msg);
	}

	/**
	 * 实例化异常
	 * 
	 * @param msgFormat
	 * @param args
	 * @return
	 */
	public SettBizException newInstance(String msgFormat, Object... args) {
		return new SettBizException(this.code, msgFormat, args);
	}

	public SettBizException print() {
		LOG.info("==>BizException, code:" + this.code + ", msg:" + this.msg);
		return this;
	}
}
