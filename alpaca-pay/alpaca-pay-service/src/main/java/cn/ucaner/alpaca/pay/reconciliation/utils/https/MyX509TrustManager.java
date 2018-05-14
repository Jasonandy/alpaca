package cn.ucaner.alpaca.pay.reconciliation.utils.https;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;



/**
* @Package：cn.ucaner.alpaca.pay.reconciliation.utils.https   
* @ClassName：MyX509TrustManager   
* @Description：   <p> 证书信任管理器（用于https请求） </p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:25:41   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class MyX509TrustManager implements X509TrustManager {

	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
	}

	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
	}

	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}
}