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
* @ClassName：CheckParams   
* @Description：   <p> 参数校验 </p>
* @Author： - Jason 
* @CreatTime：2017年8月30日 下午1:53:30   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class CheckParams implements Serializable {

	private static final long serialVersionUID = 5029944078684863514L;
	/**
	 * 校验参数
	 */
	private Map<String, Serializable> params = new HashMap<String, Serializable>();

	public CheckParams() {
		super();
	}

	/**
	 * @param params
	 */
	public CheckParams(Map<String, Serializable> params) {
		super();
		this.params = params;
	}

	/**
	 * @return the params
	 */
	public Map<String, Serializable> getParams() {
		return params;
	}

	/**
	 * @param params the params to set
	 */
	public void setParams(Map<String, Serializable> params) {
		this.params = params;
	}

}
