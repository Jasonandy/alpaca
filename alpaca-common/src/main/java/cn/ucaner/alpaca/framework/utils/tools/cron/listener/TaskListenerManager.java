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

import java.util.ArrayList;
import java.util.List;

import cn.ucaner.alpaca.framework.utils.tools.core.lang.Console;
import cn.ucaner.alpaca.framework.utils.tools.cron.TaskExecutor;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.cron.listener   
* @ClassName：TaskListenerManager   
* @Description：   <p> 监听调度器，统一管理监听 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午11:42:15   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class TaskListenerManager {
	private List<TaskListener> listeners = new ArrayList<>();
	
	/**
	 * 增加监听器
	 * @param listener {@link TaskListener}
	 * @return this
	 */
	public TaskListenerManager addListener(TaskListener listener){
		synchronized (listeners) {
			this.listeners.add(listener);
		}
		return this;
	}
	
	/**
	 * 移除监听器
	 * @param listener {@link TaskListener}
	 * @return this
	 */
	public TaskListenerManager removeListener(TaskListener listener){
		synchronized (listeners) {
			this.listeners.remove(listener);
		}
		return this;
	}
	
	/**
	 * 通知所有监听任务启动器启动
	 * @param executor {@link TaskExecutor}
	 */
	public void notifyTaskStart(TaskExecutor executor) {
		synchronized (listeners) {
			int size = listeners.size();
			for (int i = 0; i < size; i++) {
				TaskListener listenerl = listeners.get(i);
				listenerl.onStart(executor);
			}
		}
	}
	
	/**
	 * 通知所有监听任务启动器成功结束
	 * @param executor {@link TaskExecutor}
	 */
	public void notifyTaskSucceeded(TaskExecutor executor) {
		synchronized (listeners) {
			int size = listeners.size();
			for (int i = 0; i < size; i++) {
				TaskListener listenerl = listeners.get(i);
				listenerl.onSucceeded(executor);
			}
		}
	}
	
	/**
	 * 通知所有监听任务启动器结束并失败<br>
	 * 无监听将打印堆栈到命令行
	 * @param executor {@link TaskExecutor}
	 * @param exception 失败原因
	 */
	public void notifyTaskFailed(TaskExecutor executor, Throwable exception) {
		synchronized (listeners) {
			int size = listeners.size();
			if(size > 0){
				for (int i = 0; i < size; i++) {
					TaskListener listenerl = listeners.get(i);
					listenerl.onFailed(executor, exception);
				}
			}else{
				Console.log(exception, exception.getMessage());
			}
		}
	}
}
