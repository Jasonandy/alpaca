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
* @ClassName：RunnableTask   
* @Description：   <p> {@link Runnable} 的 {@link Task}包装 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午11:50:27   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class RunnableTask implements Task{
	
	private Runnable runnable;
	
	public RunnableTask(Runnable runnable) {
		this.runnable = runnable;
	}

	@Override
	public void execute() {
		runnable.run();
	}
}
