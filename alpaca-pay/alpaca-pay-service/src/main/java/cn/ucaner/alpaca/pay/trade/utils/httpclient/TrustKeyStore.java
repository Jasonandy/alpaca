package cn.ucaner.alpaca.pay.trade.utils.httpclient;

import javax.net.ssl.TrustManagerFactory;

/**
* @Package：cn.ucaner.alpaca.pay.trade.utils.httpclient   
* @ClassName：TrustKeyStore   
* @Description：   <p> TrustKeyStore</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午9:56:09   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class TrustKeyStore {
	private TrustManagerFactory trustManagerFactory;
	
	TrustKeyStore(TrustManagerFactory trustManagerFactory){
		this.trustManagerFactory = trustManagerFactory;
	}
	
	TrustManagerFactory getTrustManagerFactory(){
		return trustManagerFactory;
	}
}
