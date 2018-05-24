/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 19941115</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.alpaca.framework.utils.order;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ucaner.alpaca.framework.cache.CacheConstant;
import cn.ucaner.alpaca.framework.cache.redis.RedisLock;
import cn.ucaner.alpaca.framework.cache.redis.RedisService;
import cn.ucaner.alpaca.framework.common.spring.ext.SpringContextHolder;
import cn.ucaner.alpaca.framework.constant.GlobalConstant;

/**
* @Package：cn.ucaner.common.utils   
* @ClassName：OrderNoGenerator   
* @Description：   <p> 订单编号生成器 </p>
* @Author： - Jason 
* @CreatTime：2017年10月24日 上午10:53:44   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class OrderNoGenerator {
	
	private static Logger logger = LoggerFactory.getLogger(OrderNoGenerator.class);
	private static final String COVER_CHAR = "0";
	public static DateFormat YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
	public static DateFormat YYYYMMDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");
	public static DateFormat YYYYMMDDHH = new SimpleDateFormat("yyyyMMddHH");

	/**
	 * 订单日期标志位 判断流水号是否需要从1开始
	 */
	private static long orderDay = Long.valueOf(YYYYMMDD.format(new Date()));

	//private static java.util.concurrent.atomic.AtomicLong serialNum = new AtomicLong(0);

	private static final String ORDERNO_GEN_NUMBER_DATE = "eh.order.number.date";
	private static final String ORDERNO_LOCKED_KEY = "eh.order.lock";
	private static final long ORDERNO_LOCKED_TIME_OUT = 30000;

	/*
	 * 根据服务器的MAC地址生成1-9的编号 private static int serverNo; static { InetAddress address; try { address = InetAddress.getLocalHost(); NetworkInterface ni
	 * = NetworkInterface.getByInetAddress(address); byte[] mac = ni.getHardwareAddress(); String sMAC = null; Formatter formatter = new Formatter();
	 * for (int i = 0; i < mac.length; i++) { sMAC = formatter.format(Locale.getDefault(), "%02X%s", mac[i], ( i < mac.length - 1 ) ? "-" :
	 * "").toString(); } if (StringUtils.isBlank(sMAC)) { sMAC = address.getHostAddress(); } serverNo = ( Math.abs(sMAC.hashCode()) % 9 + 1 ); } catch
	 * (Exception e) {  Auto-generated catch block serverNo = 1; } }
	 * @param orderType
	 *            订单类型
	 * @param tradeType
	 *            交易类型
	 * @param bizType
	 *            业务编号
	 * @return
	 */
	public static String genOrderNo(int orderType, int tradeType, int bizType) {
		if (orderType != 0 && tradeType != 0 && bizType != 0) {
			StringBuffer sb = new StringBuffer();
			// 订单来源
			sb.append(orderType);

			// 交易类型
			if (tradeType < 10) {
				sb.append(COVER_CHAR + tradeType);
			} else {
				sb.append(tradeType);
			}

			// 业务编号
			sb.append(bizType);

			// 服务器编号
			// sb.append(serverNo);

			// 日期
			sb.append(YYYYMMDD.format(new Date()));

			// 流水号 是以7位数000001为起始值
			sb.append(getOrderBaseSerialNum(GlobalConstant.EH_COMMON_ORDER_SERIAL_NUMBER));
			return sb.toString();
		} else {
			return null;
		}
	}

	/**
	 * @param orderCacheKey
	 * @return modify by yuce 将java锁换为全局的redis分布式锁
	 */
	public static String getOrderSerialNum(String orderCacheKey) {
		return getOrderBaseSerialNum(orderCacheKey);
	}

	/**
	 * @param orderCacheKey
	 * @return
	 */
	public static String getOrderBaseSerialNum(String orderCacheKey) {
		RedisService redisService = SpringContextHolder.getBean(RedisService.class);
		long nowDay = Long.valueOf(YYYYMMDD.format(new Date()));
		StringBuffer serialNumSb = new StringBuffer();
		if (nowDay > orderDay) {
			RedisLock redisLock = new RedisLock(redisService.getRedisPool());
			boolean isLock = false;
			String orderNoDate = null;
			try {
				do {
					isLock = redisLock.singleLock(ORDERNO_LOCKED_KEY, ORDERNO_LOCKED_TIME_OUT);
				} while (!isLock);
				if (nowDay > orderDay) {
					orderNoDate = redisService.get(ORDERNO_GEN_NUMBER_DATE);
					// 是否需要更新生产订单的日期和订单编号重新计数
					boolean isUpdateGenOrderConfig = false;
					if (StringUtils.isNotBlank(orderNoDate) && !CacheConstant.CACHE_KEY_NOT_EXIST.equalsIgnoreCase(orderNoDate)) {
						if (Long.valueOf(orderNoDate).longValue() < nowDay) {
							isUpdateGenOrderConfig = true;
						} else if (Long.valueOf(orderNoDate).longValue() == nowDay) {
							orderDay = nowDay;
						}
					} else {
						isUpdateGenOrderConfig = true;
					}

					if (isUpdateGenOrderConfig) {
						orderDay = nowDay;
						redisService.set(ORDERNO_GEN_NUMBER_DATE, nowDay);
						redisService.set(orderCacheKey, 0);
					}
				}
			} finally {
				redisLock.singleUnlock(ORDERNO_LOCKED_KEY);
			}
		}

		// redis生产 订单流水号
		String serialNum = redisService.incr(orderCacheKey).toString();
		logger.info("订单流水号生成,time:{},redis incr:{}", YYYYMMDDHHMMSS.format(new Date()), serialNum);
		int len = 7;
		if (GlobalConstant.EH_MEDICARE_ORDER_SERIAL_NUMBER.equals(orderCacheKey)) {
			len = 6;
		}
		if (serialNum.length() < len) {
			int length = serialNum.length();
			for (int i = 0; i < len - length; i++) {
				serialNumSb.append(COVER_CHAR);
			}
		}
		serialNumSb.append(serialNum);
		return serialNumSb.toString();
	}
}
