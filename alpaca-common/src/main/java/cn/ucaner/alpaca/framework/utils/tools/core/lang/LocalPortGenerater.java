package cn.ucaner.alpaca.framework.utils.tools.core.lang;

import java.util.concurrent.atomic.AtomicInteger;

import cn.ucaner.alpaca.framework.utils.tools.core.util.NetUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.lang   
* @ClassName：LocalPortGenerater   
* @Description：   <p> 本地端口生成器 </p>
* 用于生成本地可用（未被占用）的端口号<br>
* 注意：多线程甚至单线程访问时可能会返回同一端口（例如获取了端口但是没有使用）
* @Author： -    
* @CreatTime：2018年5月25日 下午10:51:12   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class LocalPortGenerater {

	/** 备选的本地端口 */
	private final AtomicInteger alternativePort;

	/**
	 * 构造
	 * 
	 * @param beginPort
	 */
	public LocalPortGenerater(int beginPort) {
		alternativePort = new AtomicInteger(beginPort);
	}

	/**
	 * 生成一个本地端口，用于远程端口映射
	 * 
	 * @return 未被使用的本地端口
	 */
	public int generate() {
		int validPort = alternativePort.get();
		// 获取可用端口
		while (false == NetUtil.isUsableLocalPort(validPort)) {
			validPort = alternativePort.incrementAndGet();
		}
		return validPort;
	}
}
