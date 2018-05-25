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
package cn.ucaner.alpaca.framework.utils.tools.core.io.watch.watchers;

import java.nio.file.Path;
import java.nio.file.WatchEvent;

import cn.ucaner.alpaca.framework.utils.tools.core.io.watch.Watcher;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.io.watch.watchers   
* @ClassName：IgnoreWatcher   
* @Description：   <p> 跳过所有事件处理Watcher </p>
* 用户继承此类后实现需要监听的方法
* @Author： -    
* @CreatTime：2018年5月25日 下午1:12:14   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class IgnoreWatcher implements Watcher {

	@Override
	public void onCreate(WatchEvent<?> event, Path currentPath) {
	}

	@Override
	public void onModify(WatchEvent<?> event, Path currentPath) {
	}

	@Override
	public void onDelete(WatchEvent<?> event, Path currentPath) {
	}

	@Override
	public void onOverflow(WatchEvent<?> event, Path currentPath) {
	}
}
