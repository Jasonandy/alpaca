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
package cn.ucaner.alpaca.framework.utils.tools.cron;

import cn.ucaner.alpaca.framework.utils.tools.cron.task.Task;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.cron   
* @ClassName：TaskExecutor   
* @Description：   <p> 作业执行器</p>
*  执行具体的作业，执行完毕销毁
* @Author： - wubin   
* @CreatTime：2018年5月25日 上午11:39:04   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class TaskExecutor extends Thread{
	
	private Scheduler scheduler;
	private Task task;
	
	/**
	 * 获得任务对象
	 * @return 任务对象
	 */
	public Task getTask() {
		return task;
	}

	public TaskExecutor(Scheduler scheduler, Task task) {
		this.scheduler = scheduler;
		this.task = task;
	}
	
	@Override
	public void run() {
		try {
			scheduler.listenerManager.notifyTaskStart(this);
			task.execute();
			scheduler.listenerManager.notifyTaskSucceeded(this);
		} catch (Exception e) {
			scheduler.listenerManager.notifyTaskFailed(this, e);
		}finally{
			scheduler.taskExecutorManager.notifyExecutorCompleted(this);
		}
	}
}
