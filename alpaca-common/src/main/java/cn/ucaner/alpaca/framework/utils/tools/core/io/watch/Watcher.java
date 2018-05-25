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
package cn.ucaner.alpaca.framework.utils.tools.core.io.watch;

import java.nio.file.Path;
import java.nio.file.WatchEvent;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.io.watch   
* @ClassName：Watcher   
* @Description：   <p> 观察者（监视器 )</p>
* @Author： -    
* @CreatTime：2018年5月25日 下午1:11:28   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface Watcher {
	/**
	 * 文件创建时执行的方法
	 * @param event 事件
	 * @param currentPath 事件发生的当前Path路径
	 */
	public void onCreate(WatchEvent<?> event, Path currentPath);
	
	/**
	 * 文件修改时执行的方法<br>
	 * 文件修改可能触发多次
	 * @param event 事件
	 * @param currentPath 事件发生的当前Path路径
	 */
	public void onModify(WatchEvent<?> event, Path currentPath);
	
	/**
	 * 文件删除时执行的方法
	 * @param event 事件
	 * @param currentPath 事件发生的当前Path路径
	 */
	public void onDelete(WatchEvent<?> event, Path currentPath);
	
	/**
	 * 事件丢失或出错时执行的方法
	 * @param event 事件
	 * @param currentPath 事件发生的当前Path路径
	 */
	public void onOverflow(WatchEvent<?> event, Path currentPath);
}
