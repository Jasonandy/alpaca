package cn.ucaner.alpaca.pay.common.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
* @Package：cn.ucaner.alpaca.pay.common.core.config   
* @ClassName：MqConfig   
* @Description：   <p> MQ</p>
* @Author： - Jason   
* @CreatTime：2018年5月10日 下午10:01:19   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public class MqConfig {
	
	private static final Log LOG = LogFactory.getLog(MqConfig.class);
	
	/** 商户通知队列 **/
	public static String MERCHANT_NOTIFY_QUEUE = "";

	/** 订单通知队列 **/
	public static String ORDER_NOTIFY_QUEUE = "";
	
	private static Properties properties = null;
	
	static{
		if(null == properties){
			properties  = new Properties();
		}
		InputStream proFile = Thread.currentThread().getContextClassLoader().getResourceAsStream("mq_config.properties");
		try {
			properties.load(proFile);
			init(properties);
		} catch (IOException e) {
			LOG.error("=== load and init mq exception:" + e);
		}
	}
	
	/**
	 * @Description: init MQ
	 * @Autor: jason jasonandy@hotmail.com
	 */
	private static void init(Properties properties){
		MERCHANT_NOTIFY_QUEUE = properties.getProperty("tradeQueueName.notify");
		ORDER_NOTIFY_QUEUE = properties.getProperty("orderQueryQueueName.query");
	}
}
