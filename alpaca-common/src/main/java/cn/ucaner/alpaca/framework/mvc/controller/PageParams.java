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
package cn.ucaner.alpaca.framework.mvc.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
* @Package：cn.ucaner.framework.mvc.controller   
* @ClassName：PageParams   
* @Description：   <p> PageParams</p>
* @Author： - Jason 
* @CreatTime：2017年8月30日 下午1:54:48   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class PageParams implements Serializable {

	private static final long serialVersionUID = -5819554419875365914L;

	private Map<String, Object> params = new HashMap<String, Object>();

	public PageParams() {
		super();
	}

	public PageParams(Map<String, Object> params) {
		super();
		this.params = params;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
}
