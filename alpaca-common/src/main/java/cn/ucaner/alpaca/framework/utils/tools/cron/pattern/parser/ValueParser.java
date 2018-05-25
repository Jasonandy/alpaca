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
package cn.ucaner.alpaca.framework.utils.tools.cron.pattern.parser;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.cron.pattern.parser   
* @ClassName：ValueParser   
* @Description：   <p> 值处理接口</p>
* 值处理用于限定表达式中相应位置的值范围，并转换表达式值为int值
* @Author： -    
* @CreatTime：2018年5月25日 上午11:46:33   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface ValueParser {

	/**
	 * 处理String值并转为int<br>
	 * 转换包括：
	 * <ol>
	 * <li>数字字符串转为数字</li>
	 * <li>别名转为对应的数字（如月份和星期）</li>
	 * </ol>
	 * 
	 * @param value String值
	 * @return int
	 */
	public int parse(String value);

	/**
	 * 返回最小值
	 * 
	 * @return 最小值
	 */
	public int getMin();

	/**
	 * 返回最大值
	 * 
	 * @return 最大值
	 */
	public int getMax();
}
