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
package cn.ucaner.alpaca.framework.utils.tools.core.lang;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import cn.ucaner.alpaca.framework.utils.tools.core.exceptions.NotInitedException;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.lang   
* @ClassName：SyncFinisher   
* @Description：   <p> 线程同步结束器</p>
* 在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。<br>
* 不能保证同时开始
* @Author： -    
* @CreatTime：2018年5月25日 下午12:02:37   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class SyncFinisher{
	
	private CountDownLatch countDownLatch;
	
	private Set<Worker> workers = new LinkedHashSet<Worker>();
	
	/**
	 * 增加工作线程
	 * @param worker 工作线程
	 */
	synchronized public void addWorker(Worker worker) {
		workers.add(worker);
	}
	
	/**
	 * 开始工作
	 */
	public void start() {
		countDownLatch = new CountDownLatch(workers.size());
		for (Worker worker : workers) {
			worker.start();
		}
	}
	
	/**
	 * 等待所有Worker工作结束，否则阻塞
	 * @throws InterruptedException 用户中断
	 */
	public void await() throws InterruptedException {
		if(countDownLatch == null) {
			throw new NotInitedException("Please call start() method first!");
		}
		
		countDownLatch.await();
	}
	
	/**
	 * 清空工作线程对象
	 */
	public void clearWorker() {
		workers.clear();
	}
	
	/**
	 * @return 并发数
	 */
	public long count() {
		return countDownLatch.getCount();
	}
	
	/**
	 * 工作者，为一个线程
	 *
	 */
	public abstract class Worker extends Thread {

		@Override
		public void run() {
			try {
				work();
			} finally {
				countDownLatch.countDown();
			}
		}
		
		public abstract void work();
	}
}
