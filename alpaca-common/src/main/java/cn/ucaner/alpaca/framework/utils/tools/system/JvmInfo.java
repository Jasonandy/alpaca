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

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.system   
* @ClassName：JvmInfo   
* @Description：   <p> Java Virtual Machine Implementation的信息。</p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:05:12   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class JvmInfo {

	private final String JAVA_VM_NAME = SystemUtil.get("java.vm.name", false);
	private final String JAVA_VM_VERSION = SystemUtil.get("java.vm.version", false);
	private final String JAVA_VM_VENDOR = SystemUtil.get("java.vm.vendor", false);
	private final String JAVA_VM_INFO = SystemUtil.get("java.vm.info", false);

	/**
	 * 取得当前JVM impl.的名称（取自系统属性：<code>java.vm.name</code>）。
	 * 
	 * <p>
	 * 例如Sun JDK 1.4.2：<code>"Java HotSpot(TM) Client VM"</code>
	 * </p>
	 * 
	 * @return 属性值，如果不能取得（因为Java安全限制）或值不存在，则返回<code>null</code>。
	 * 
	 */
	public final String getName() {
		return JAVA_VM_NAME;
	}

	/**
	 * 取得当前JVM impl.的版本（取自系统属性：<code>java.vm.version</code>）。
	 * 
	 * <p>
	 * 例如Sun JDK 1.4.2：<code>"1.4.2-b28"</code>
	 * </p>
	 * 
	 * @return 属性值，如果不能取得（因为Java安全限制）或值不存在，则返回<code>null</code>。
	 * 
	 */
	public final String getVersion() {
		return JAVA_VM_VERSION;
	}

	/**
	 * 取得当前JVM impl.的厂商（取自系统属性：<code>java.vm.vendor</code>）。
	 * 
	 * <p>
	 * 例如Sun JDK 1.4.2：<code>"Sun Microsystems Inc."</code>
	 * </p>
	 * 
	 * @return 属性值，如果不能取得（因为Java安全限制）或值不存在，则返回<code>null</code>。
	 * 
	 */
	public final String getVendor() {
		return JAVA_VM_VENDOR;
	}

	/**
	 * 取得当前JVM impl.的信息（取自系统属性：<code>java.vm.info</code>）。
	 * 
	 * <p>
	 * 例如Sun JDK 1.4.2：<code>"mixed mode"</code>
	 * </p>
	 * 
	 * @return 属性值，如果不能取得（因为Java安全限制）或值不存在，则返回<code>null</code>。
	 * 
	 */
	public final String getInfo() {
		return JAVA_VM_INFO;
	}

	/**
	 * 将Java Virutal Machine Implementation的信息转换成字符串。
	 * 
	 * @return JVM impl.的字符串表示
	 */
	@Override
	public final String toString() {
		StringBuilder builder = new StringBuilder();

		SystemUtil.append(builder, "JavaVM Name:    ", getName());
		SystemUtil.append(builder, "JavaVM Version: ", getVersion());
		SystemUtil.append(builder, "JavaVM Vendor:  ", getVendor());
		SystemUtil.append(builder, "JavaVM Info:    ", getInfo());

		return builder.toString();
	}

}
