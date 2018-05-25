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
package cn.ucaner.alpaca.framework.utils.tools.cron.listener;

import cn.ucaner.alpaca.framework.utils.tools.cron.TaskExecutor;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.cron.listener   
* @ClassName：TaskListener   
* @Description：   <p> 定时任务监听接口 </p>
* 通过实现此接口，实现对定时任务的各个环节做监听
* @Author： -    
* @CreatTime：2018年5月25日 上午11:42:39   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface TaskListener {
	/**
	 * 定时任务启动时触发
	 * @param executor {@link TaskExecutor}
	 */
	public void onStart(TaskExecutor executor);
	
	/**
	 * 任务成功结束时触发
	 * 
	 * @param executor {@link TaskExecutor}
	 */
	public void onSucceeded(TaskExecutor executor);

	/**
	 * 任务启动失败时触发
	 * 
	 * @param executor {@link TaskExecutor}
	 * @param exception 异常
	 */
	public void onFailed(TaskExecutor executor, Throwable exception);
}
