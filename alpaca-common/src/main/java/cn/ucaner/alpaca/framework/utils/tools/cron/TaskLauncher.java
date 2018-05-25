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

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.cron   
* @ClassName：TaskLauncher   
* @Description：   <p> 作业启动器 </p>
* 负责检查<strong>TaskTable</strong>是否有匹配到此时运行的Task<br>
* 检查完毕后启动器结束
* @Author： -    
* @CreatTime：2018年5月25日 上午11:39:33   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class TaskLauncher extends Thread{
	
	private Scheduler scheduler;
	private long millis;
	
	public TaskLauncher(Scheduler scheduler, long millis) {
		this.scheduler = scheduler;
		this.millis = millis;
	}
	
	@Override
	public void run() {
		//匹配秒部分由用户定义决定，始终不匹配年
		scheduler.taskTable.executeTaskIfMatchInternal(millis);
		
		//结束通知
		scheduler.taskLauncherManager.notifyLauncherCompleted(this);
	}
}
