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
import java.util.Iterator;
import java.util.List;

import cn.ucaner.alpaca.framework.utils.tools.core.io.watch.Watcher;
import cn.ucaner.alpaca.framework.utils.tools.core.lang.Chain;
import cn.ucaner.alpaca.framework.utils.tools.core.util.CollectionUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.io.watch.watchers   
* @ClassName：WatcherChain   
* @Description：   <p> 观察者链 用于加入多个观察者 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午1:12:40   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class WatcherChain implements Watcher, Chain<Watcher, WatcherChain>{

	/** 观察者列表 */
	final private List<Watcher> chain;
	
	/**
	 * 创建观察者链{@link WatcherChain}
	 * @param watchers  观察者列表
	 * @return {@link WatcherChain}
	 */
	public static WatcherChain create(Watcher... watchers) {
		return new WatcherChain(watchers);
	}
	
	/**
	 * 构造
	 * @param watchers 观察者列表
	 */
	public WatcherChain(Watcher... watchers) {
		chain = CollectionUtil.newArrayList(watchers);
	}
	
	@Override
	public void onCreate(WatchEvent<?> event, Path currentPath) {
		for (Watcher watcher : chain) {
			watcher.onCreate(event, currentPath);
		}
	}

	@Override
	public void onModify(WatchEvent<?> event, Path currentPath) {
		for (Watcher watcher : chain) {
			watcher.onModify(event, currentPath);
		}
	}

	@Override
	public void onDelete(WatchEvent<?> event, Path currentPath) {
		for (Watcher watcher : chain) {
			watcher.onDelete(event, currentPath);
		}
	}

	@Override
	public void onOverflow(WatchEvent<?> event, Path currentPath) {
		for (Watcher watcher : chain) {
			watcher.onOverflow(event, currentPath);
		}
	}

	@Override
	public Iterator<Watcher> iterator() {
		return this.chain.iterator();
	}

	@Override
	public WatcherChain addChain(Watcher element) {
		this.chain.add(element);
		return this;
	}

}
