package cn.ucaner.alpaca.framework.utils.tools.extra.qrcode;

import cn.ucaner.alpaca.framework.utils.tools.core.exceptions.ExceptionUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.extra.qrcode   
* @ClassName：QrCodeException   
* @Description：   <p> Qrcode异常 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午10:32:59   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class QrCodeException extends RuntimeException {
	private static final long serialVersionUID = 8247610319171014183L;

	public QrCodeException(Throwable e) {
		super(ExceptionUtil.getMessage(e), e);
	}

	public QrCodeException(String message) {
		super(message);
	}

	public QrCodeException(String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params));
	}

	public QrCodeException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public QrCodeException(Throwable throwable, String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params), throwable);
	}
}
