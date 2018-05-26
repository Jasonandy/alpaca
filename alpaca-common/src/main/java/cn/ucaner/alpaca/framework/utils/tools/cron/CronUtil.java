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

import cn.ucaner.alpaca.framework.utils.tools.core.exceptions.UtilException;
import cn.ucaner.alpaca.framework.utils.tools.core.io.resource.NoResourceException;
import cn.ucaner.alpaca.framework.utils.tools.cron.pattern.CronPattern;
import cn.ucaner.alpaca.framework.utils.tools.cron.task.Task;
import cn.ucaner.alpaca.framework.utils.tools.setting.Setting;
import cn.ucaner.alpaca.framework.utils.tools.setting.SettingRuntimeException;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.cron   
* @ClassName：CronUtil   
* @Description：   <p> 定时任务工具类 </p>
* 定时任务工具类<br>
* 此工具持有一个全局{@link Scheduler}，所有定时任务在同一个调度器中执行
* @Author： -    
* @CreatTime：2018年5月25日 上午11:41:19   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public final class CronUtil {
//	private final static Log log = StaticLog.get();
	
	/** Crontab配置文件 */
	public final static String CRONTAB_CONFIG_PATH = "config/cron.setting";
	
	private final static Scheduler scheduler = new Scheduler();
	private static Setting crontabSetting;

	private CronUtil() {
	}

	/**
	 * 自定义定时任务配置文件
	 * @param cronSetting 定时任务配置文件 
	 */
	public static void setCronSetting(Setting cronSetting) {
		crontabSetting = cronSetting;
	}
	
	/**
	 * 自定义定时任务配置文件路径
	 * @param cronSettingPath 定时任务配置文件路径（相对绝对都可）
	 */
	public static void setCronSetting(String cronSettingPath) {
		try {
			crontabSetting = new Setting(cronSettingPath, Setting.DEFAULT_CHARSET, false);
		} catch (SettingRuntimeException | NoResourceException e) {
			// ignore setting file parse error and no config error
		}
	}
	
	/**
	 * 设置是否支持秒匹配，默认不使用
	 * @param isMatchSecond <code>true</code>支持，<code>false</code>不支持
	 */
	public static void setMatchSecond(boolean isMatchSecond) {
		scheduler.setMatchSecond(isMatchSecond);
	}
	
	/**
	 * 设置是否支持年匹配，默认不使用
	 * @param isMatchYear <code>true</code>支持，<code>false</code>不支持
	 */
	public static String schedule(String schedulingPattern, Task task) {
		return scheduler.schedule(schedulingPattern, task);
	}
	
	/**
	 * 加入定时任务
	 * @param schedulingPattern 定时任务执行时间的crontab表达式
	 * @param task 任务
	 * @return 定时任务ID
	 */
	public static String schedule(String id, String schedulingPattern, Task task) {
		scheduler.schedule(id, schedulingPattern, task);
		return id;
	}
	
	/**
	 * 加入定时任务
	 * @param schedulingPattern 定时任务执行时间的crontab表达式
	 * @param task 任务
	 * @return 定时任务ID
	 */
	public static String schedule(String schedulingPattern, Runnable task) {
		return scheduler.schedule(schedulingPattern, task);
	}
	
	/**
	 * 批量加入配置文件中的定时任务
	 * @param cronSetting 定时任务设置文件
	 */
	public static void schedule(Setting cronSetting) {
		scheduler.schedule(cronSetting);
	}
	
	/**
	 * 移除任务
	 * @param schedulerId 任务ID
	 */
	public static void remove(String schedulerId) {
		scheduler.deschedule(schedulerId);
	}
	
	/**
	 * 移除Task
	 * 
	 * @param id Task的ID
	 * @param pattern {@link CronPattern}
	 * @since 4.0.10
	 */
	public static void updatePattern(String id, CronPattern pattern) {
		scheduler.updatePattern(id, pattern);
	}

	/**
	 * @return 获得Scheduler对象
	 */
	public static Scheduler getScheduler() {
		return scheduler;
	}
	
	/**
	 * 开始
	 */
	synchronized public static void start() {
		if(null == crontabSetting) {
			setCronSetting(CRONTAB_CONFIG_PATH);
		}
		if(scheduler.isStarted()) {
			throw new UtilException("Scheduler has been started, please stop it first!");
		}
		
		schedule(crontabSetting);
		scheduler.start();
	}
	
	/**
	 * 重新启动定时任务<br>
	 * 重新启动定时任务会清除动态加载的任务
	 */
	synchronized public static void restart(){
		if(null != crontabSetting){
			crontabSetting.load();
		}
		if(scheduler.isStarted()){
			scheduler.stop();
		}
		
		schedule(crontabSetting);
		scheduler.start();
	}
	
	/**
	 * 停止
	 */
	synchronized public static void stop() {
		scheduler.stop();
	}
	
}

