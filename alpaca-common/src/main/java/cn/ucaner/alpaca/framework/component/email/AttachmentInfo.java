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
package cn.ucaner.alpaca.framework.component.email;

import java.io.Serializable;

/**
* @Package：cn.ucaner.common.email   
* @ClassName：AttachmentInfo   
* @Description：   <p> 邮件附件 </p>
* @Author： - Jason 
* @CreatTime：2017年8月30日 下午2:18:30   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class AttachmentInfo implements Serializable {
	
	private static final long serialVersionUID = -638346101635261172L;
	/**
	 * 附件名称
	 */
	private String attachmentName;
	/**
	 * 附件地址
	 */
	private String attachmentPath;

	public AttachmentInfo() {

	}

	public AttachmentInfo(String attachmentName, String attachmentPath) {
		this.attachmentName = attachmentName;
		this.attachmentPath = attachmentPath;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getAttachmentPath() {
		return attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}

}
