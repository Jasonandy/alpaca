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
package cn.ucaner.alpaca.framework.utils.tools.core.io.file;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.io.file   
* @ClassName：LineSeparator   
* @Description：   <p>  换行符枚举</p>
* 换行符包括：
* <pre>
* Mac系统换行符："\r"
* Linux系统换行符："\n"
* Windows系统换行符："\r\n"
* </pre>
* @Author： -    
* @CreatTime：2018年5月25日 上午11:55:37   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public enum LineSeparator {
	/** Mac系统换行符："\r" */
	MAC("\r"),
	/** Linux系统换行符："\n" */
	LINUX("\n"), 
	/** Windows系统换行符："\r\n" */
	WINDOWS("\r\n");

	private String value;

	private LineSeparator(String lineSeparator) {
		this.value = lineSeparator;
	}

	public String getValue() {
		return this.value;
	}
}
