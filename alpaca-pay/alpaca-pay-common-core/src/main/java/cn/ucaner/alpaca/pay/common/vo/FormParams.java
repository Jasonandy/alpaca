/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason https://github.com/Jasonandy</p>
 *  </body>
 * </html>
 */
package cn.ucaner.alpaca.pay.common.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**     
* @Package：cn.ucaner.alpaca.pay.common.vo   
* @ClassName：FormParams   
* @Description：   <p> FormParams </p>
* @Author： - Jason   
* @CreatTime：2018年6月12日 下午8:41:28   
* @Modify By：   
* @ModifyTime：  2018年6月12日
* @Modify marker：   
* @version    V1.0
*/
public class FormParams implements Serializable{

	private static final long serialVersionUID = 2411402010202867629L;

	private Map<String, Object> params = new HashMap<String, Object>();

	public FormParams() {
		super();
	}

	public FormParams(Map<String, Object> params) {
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
