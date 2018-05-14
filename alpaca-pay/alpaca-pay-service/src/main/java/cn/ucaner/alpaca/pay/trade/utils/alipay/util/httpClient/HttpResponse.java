package cn.ucaner.alpaca.pay.trade.utils.alipay.util.httpClient;

import cn.ucaner.alpaca.pay.trade.utils.alipay.config.AlipayConfigUtil;
import org.apache.commons.httpclient.Header;

import java.io.UnsupportedEncodingException;

/**
* @Package：cn.ucaner.alpaca.pay.trade.utils.alipay.util.httpClient   
* @ClassName：HttpResponse   
* @Description：   <p> Http返回对象的封装 </p>
* @Author： - wubin   
* @CreatTime：2018年5月11日 上午10:04:00   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class HttpResponse {

    /**
     * 返回中的Header信息
     */
    private Header[] responseHeaders;

    /**
     * String类型的result
     */
    private String   stringResult;

    /**
     * btye类型的result
     */
    private byte[]   byteResult;

    public Header[] getResponseHeaders() {
        return responseHeaders;
    }

    public void setResponseHeaders(Header[] responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    public byte[] getByteResult() {
        if (byteResult != null) {
            return byteResult;
        }
        if (stringResult != null) {
            return stringResult.getBytes();
        }
        return null;
    }

    public void setByteResult(byte[] byteResult) {
        this.byteResult = byteResult;
    }

    public String getStringResult() throws UnsupportedEncodingException {
        if (stringResult != null) {
            return stringResult;
        }
        if (byteResult != null) {
            return new String(byteResult, AlipayConfigUtil.input_charset);
        }
        return null;
    }

    public void setStringResult(String stringResult) {
        this.stringResult = stringResult;
    }

}
