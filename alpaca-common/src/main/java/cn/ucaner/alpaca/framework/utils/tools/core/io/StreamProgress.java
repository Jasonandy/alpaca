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
package cn.ucaner.alpaca.framework.utils.tools.core.io;

/**
 * Stream进度条
 * @author Looly
 *
 */
public interface StreamProgress {
	
	/**
	 * 开始
	 */
	public void start();
	
	/**
	 * 进行中
	 * @param progressSize 已经进行的大小
	 */
	public void progress(long progressSize);
	
	/**
	 * 结束
	 */
	public void finish();
}
