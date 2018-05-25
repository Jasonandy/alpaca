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
package cn.ucaner.alpaca.framework.utils.tools.system;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.system   
* @ClassName：HostInfo   
* @Description：   <p> 代表当前主机的信息。 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:06:27   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class HostInfo{

	private final String HOST_NAME;
	private final String HOST_ADDRESS;

	public HostInfo() {
		String hostName;
		String hostAddress;

		try {
			InetAddress localhost = InetAddress.getLocalHost();

			hostName = localhost.getHostName();
			hostAddress = localhost.getHostAddress();
		} catch (UnknownHostException e) {
			hostName = "localhost";
			hostAddress = "127.0.0.1";
		}

		HOST_NAME = hostName;
		HOST_ADDRESS = hostAddress;
	}

	/**
	 * 取得当前主机的名称。
	 * 
	 * <p>
	 * 例如：<code>"webserver1"</code>
	 * </p>
	 * 
	 * @return 主机名
	 */
	public final String getName() {
		return HOST_NAME;
	}

	/**
	 * 取得当前主机的地址。
	 * 
	 * <p>
	 * 例如：<code>"192.168.0.1"</code>
	 * </p>
	 * 
	 * @return 主机地址
	 */
	public final String getAddress() {
		return HOST_ADDRESS;
	}

	/**
	 * 将当前主机的信息转换成字符串。
	 * 
	 * @return 主机信息的字符串表示
	 */
	@Override
	public final String toString() {
		StringBuilder builder = new StringBuilder();

		SystemUtil.append(builder, "Host Name:    ", getName());
		SystemUtil.append(builder, "Host Address: ", getAddress());

		return builder.toString();
	}

}
