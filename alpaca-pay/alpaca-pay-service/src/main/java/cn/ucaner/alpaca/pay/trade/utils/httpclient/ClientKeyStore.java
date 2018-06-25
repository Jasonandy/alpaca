package cn.ucaner.alpaca.pay.trade.utils.httpclient;

import javax.net.ssl.KeyManagerFactory;

/**
* @Package：cn.ucaner.alpaca.pay.trade.utils.httpclient   
* @ClassName：ClientKeyStore   
* @Description：   <p> ClientKeyStore</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午9:58:50   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class ClientKeyStore {
	
	/**
	 * javax.net.ssl.KeyManagerFactory 
	 */
	private KeyManagerFactory keyManagerFactory;
	
	
	ClientKeyStore(KeyManagerFactory keyManagerFactory){
		this.keyManagerFactory = keyManagerFactory;
	}
	
	KeyManagerFactory getKeyManagerFactory(){
		return keyManagerFactory;
	}
}
