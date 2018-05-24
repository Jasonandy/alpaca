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
package cn.ucaner.alpaca.framework.mvc.entity;

import java.io.Serializable;

/**
* @Package：cn.ucaner.framework.mvc.entity   
* @ClassName：BaseEntity   
* @Description：   <p> BaseEntity 实体基类</p>
* @Author： - Jason 
* @CreatTime：2017年8月30日 下午1:58:42   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 2368417877456900821L;
	
	/**
	 * 主键ID
	 */
	protected String id;

	public BaseEntity() {
		super();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}
}
