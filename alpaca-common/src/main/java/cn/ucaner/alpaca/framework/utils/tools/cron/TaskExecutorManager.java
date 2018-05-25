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

import java.util.ArrayList;
import java.util.List;

import cn.ucaner.alpaca.framework.utils.tools.core.util.ThreadUtil;
import cn.ucaner.alpaca.framework.utils.tools.cron.task.Task;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.cron   
* @ClassName：TaskExecutorManager   
* @Description：   <p> 任务执行管理器 </p>
* 任务执行管理器<br>
* 负责管理任务的启动、停止等
* @Author： -    
* @CreatTime：2018年5月25日 上午11:38:40   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class TaskExecutorManager {

	protected Scheduler scheduler;
	/** 执行器列表 */
	private List<TaskExecutor> executors = new ArrayList<>();
	
	public TaskExecutorManager(Scheduler scheduler) {
		this.scheduler = scheduler;
	}
	
	/**
	 * 启动 TaskExecutor
	 * @param task {@link Task}
	 * @return {@link TaskExecutor}
	 */
	public TaskExecutor spawnExecutor(Task task) {
		final TaskExecutor executor = new TaskExecutor(this.scheduler, task);
		synchronized (this.executors) {
			this.executors.add(executor);
		}
		executor.setDaemon(this.scheduler.daemon);
		executor.start();
		return executor;
	}
	
	/**
	 * 执行器执行完毕调用此方法，将执行器从执行器列表移除
	 * @param executor 执行器 {@link TaskExecutor}
	 * @return this
	 */
	public TaskExecutorManager notifyExecutorCompleted(TaskExecutor executor) {
		synchronized (executors) {
			executors.remove(executor);
		}
		return this;
	}

	/**
	 * 停止所有TaskExecutor
	 * @return this
	 */
	public TaskExecutorManager destroy() {
		synchronized (this.executors) {
			for (TaskExecutor taskExecutor : executors) {
				ThreadUtil.interupt(taskExecutor, true);
			}
		}
		this.executors.clear();
		return this;
	}
}
