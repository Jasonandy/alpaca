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
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.io   
* @ClassName：StreamProgress   
* @Description：   <p> Stream进度条</p>
* @Author： -    
* @CreatTime：2018年6月4日 下午11:21:42   
* @Modify By：   
* @ModifyTime：  2018年6月4日
* @Modify marker：   
* @version    V1.0
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
