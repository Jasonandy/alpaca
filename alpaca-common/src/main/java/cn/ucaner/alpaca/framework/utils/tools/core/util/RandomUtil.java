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
package cn.ucaner.alpaca.framework.utils.tools.core.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import cn.ucaner.alpaca.framework.utils.tools.core.exceptions.UtilException;

/**
* @Package：cn.ucaner.tools.core.util   
* @ClassName：RandomUtil   
* @Description：   <p> 随机工具类</p>
* @Author： -  
* @CreatTime：2017-11-3 上午11:34:06   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class RandomUtil {
	
	/** 用于随机选的数字 */
	private static final String BASE_NUMBER = "0123456789";
	/** 用于随机选的字符 */
	private static final String BASE_CHAR = "abcdefghijklmnopqrstuvwxyz";
	/** 用于随机选的字符和数字 */
	private static final String BASE_CHAR_NUMBER = BASE_CHAR + BASE_NUMBER;
	
	/**
	 * 获取随机数生成器对象<br>
	 * ThreadLocalRandom是JDK 7之后提供并发产生随机数，能够解决多个线程发生的竞争争夺。
	 * 
	 * @return {@link ThreadLocalRandom}
	 * @since 3.1.2
	 */
	public static ThreadLocalRandom getRandom() {
		return ThreadLocalRandom.current();
	}
	
	/**
	 * 获取{@link SecureRandom}，类提供加密的强随机数生成器 (RNG)
	 * 
	 * @return {@link SecureRandom}
	 * @since 3.1.2
	 */
	public static SecureRandom getSecureRandom() {
		try {
			return SecureRandom.getInstance("SHA1PRNG");
		} catch (NoSuchAlgorithmException e) {
			throw new UtilException(e);
		}
	}

	/**
	 * 获得指定范围内的随机数
	 * 
	 * @param min 最小数
	 * @param max 最大数
	 * @return 随机数
	 */
	public static int randomInt(int min, int max) {
		return getRandom().nextInt(max - min) + min;
	}

	/**
	 * 获得随机数
	 * 
	 * @return 随机数
	 */
	public static int randomInt() {
		return getRandom().nextInt();
	}

	/**
	 * 获得指定范围内的随机数 [0,limit)
	 * 
	 * @param limit 限制随机数的范围，不包括这个数
	 * @return 随机数
	 */
	public static int randomInt(int limit) {
		return getRandom().nextInt(limit);
	}

	/**
	 * 随机bytes
	 * 
	 * @param length 长度
	 * @return bytes
	 */
	public static byte[] randomBytes(int length) {
		byte[] bytes = new byte[length];
		getRandom().nextBytes(bytes);
		return bytes;
	}

	/**
	 * 随机获得列表中的元素
	 * 
	 * @param <T> 元素类型
	 * @param list 列表
	 * @return 随机元素
	 */
	public static <T> T randomEle(List<T> list) {
		return randomEle(list, list.size());
	}

	/**
	 * 随机获得列表中的元素
	 * 
	 * @param <T> 元素类型
	 * @param list 列表
	 * @param limit 限制列表的前N项
	 * @return 随机元素
	 */
	public static <T> T randomEle(List<T> list, int limit) {
		return list.get(randomInt(limit));
	}

	/**
	 * 随机获得列表中的一定量元素
	 * 
	 * @param <T> 元素类型
	 * @param list 列表
	 * @param count 随机取出的个数
	 * @return 随机元素
	 */
	public static <T> List<T> randomEles(List<T> list, int count) {
		final List<T> result = new ArrayList<T>(count);
		int limit = list.size();
		while (--count > 0) {
			result.add(randomEle(list, limit));
		}

		return result;
	}
	
	/**
	 * 随机获得列表中的一定量的不重复元素，返回Set
	 * 
	 * @param <T> 元素类型
	 * @param collection 列表
	 * @param count 随机取出的个数
	 * @return 随机元素
	 * @throws IllegalArgumentException 需要的长度大于给定集合非重复总数
	 */
	public static <T> Set<T> randomEleSet(Collection<T> collection, int count) {
		ArrayList<T> source = new ArrayList<>(new HashSet<>(collection));
		if(count > source.size()){
			throw new IllegalArgumentException("Count is larger than collection distinct size !");
		}
		
		final HashSet<T> result = new HashSet<T>(count);
		int limit = collection.size();
		while (result.size() < count) {
			result.add(randomEle(source, limit));
		}

		return result;
	}

	/**
	 * 获得一个随机的字符串（只包含数字和字符）
	 * 
	 * @param length 字符串的长度
	 * @return 随机字符串
	 */
	public static String randomString(int length) {
		return randomString(BASE_CHAR_NUMBER, length);
	}

	/**
	 * 获得一个只包含数字的字符串
	 * 
	 * @param length 字符串的长度
	 * @return 随机字符串
	 */
	public static String randomNumbers(int length) {
		return randomString(BASE_NUMBER, length);
	}

	/**
	 * 获得一个随机的字符串
	 * 
	 * @param baseString 随机字符选取的样本
	 * @param length 字符串的长度
	 * @return 随机字符串
	 */
	public static String randomString(String baseString, int length) {
		final StringBuilder sb = new StringBuilder();

		if (length < 1) {
			length = 1;
		}
		int baseLength = baseString.length();
		for (int i = 0; i < length; i++) {
			int number = getRandom().nextInt(baseLength);
			sb.append(baseString.charAt(number));
		}
		return sb.toString();
	}
	
	/**
	 * 随机数字
	 * @return 随机字符
	 * @since 3.1.2
	 */
	public static int randomNumber() {
		return randomChar(BASE_NUMBER);
	}
	
	/**
	 * 随机字母或数字，小写
	 * @return 随机字符
	 * @since 3.1.2
	 */
	public static char randomChar() {
		return randomChar(BASE_CHAR_NUMBER);
	}
	
	/**
	 * 随机字符
	 * @param baseString 随机字符选取的样本
	 * @return 随机字符
	 * @since 3.1.2
	 */
	public static char randomChar(String baseString) {
		return baseString.charAt(getRandom().nextInt(baseString.length()));
	}

	/**
	 * @return 随机UUID
	 */
	public static String randomUUID() {
		return UUID.randomUUID().toString();
	}
}
