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
package cn.ucaner.alpaca.framework.utils.tools.cron.task;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.cron.task   
* @ClassName：Task   
* @Description：   <p>  定时作业接口，通过实现execute方法执行具体的任务<br> </p>
* @Author： - wubin   
* @CreatTime：2018年5月25日 上午11:50:47   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface Task {
	
	/**
	 * 执行作业
	 */
	public void execute();
}
