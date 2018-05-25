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

import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.cron   
* @ClassName：CronException   
* @Description：   <p> 定时任务异常 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午11:40:30   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class CronException extends RuntimeException{
	private static final long serialVersionUID = 8247610319171014183L;

	public CronException(Throwable e) {
		super(e.getMessage(), e);
	}
	
	public CronException(String message) {
		super(message);
	}
	
	public CronException(String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params));
	}
	
	public CronException(Throwable throwable, String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params), throwable);
	}
}
