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
import java.util.Date;

/**
* @Package：cn.ucaner.common.email   
* @ClassName：CallBackInfo   
* @Description：   <p> 邮件回调信息 </p>
* @Author： - Jason 
* @CreatTime：2017年8月30日 下午2:18:17   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class CallBackInfo implements Serializable {
	
	private static final long serialVersionUID = 5401971939678483405L;
	/**
	 * 发送状态
	 */
	private boolean status;
	/**
	 * 邮件发送时间
	 */
	private Date sentDate;
	/**
	 * 尝试次数,暂时无用
	 */
	@Deprecated
	private Integer attempts;

	public CallBackInfo() {

	}

	public CallBackInfo(boolean status, Date sentDate, Integer attempts) {
		this.status = status;
		this.sentDate = sentDate;
		this.attempts = attempts;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	@Deprecated
	public Integer getAttempts() {
		return attempts;
	}

	@Deprecated
	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}

}
