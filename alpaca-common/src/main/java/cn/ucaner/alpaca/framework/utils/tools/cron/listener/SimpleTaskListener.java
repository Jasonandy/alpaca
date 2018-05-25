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
* @ClassName：SimpleTaskListener   
* @Description：   <p> 简单监听实现，不做任何操作 </p>
* 继承此监听后实现需要的方法即可
* @Author： -    
* @CreatTime：2018年5月25日 上午11:43:01   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class SimpleTaskListener implements TaskListener{

	@Override
	public void onStart(TaskExecutor executor) {
	}

	@Override
	public void onSucceeded(TaskExecutor executor) {
		
	}

	@Override
	public void onFailed(TaskExecutor executor, Throwable exception) {

	}

}
