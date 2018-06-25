package cn.ucaner.alpaca.pay.trade.utils.httpclient;

import java.io.IOException;
import java.io.InputStream;

/**
* @Package：cn.ucaner.alpaca.pay.trade.utils.httpclient   
* @ClassName：HttpResponseCallBack   
* @Description：   <p> HttpResponseCallBack</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午9:57:48   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public interface HttpResponseCallBack {

	/**
	 * @Description: processResponse 
	 * @param responseBody
	 * @throws IOException 
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
	public void processResponse(InputStream responseBody) throws IOException;
}
