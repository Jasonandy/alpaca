package cn.ucaner.alpaca.pay.common.core.entity;

import com.alibaba.fastjson.JSONObject;

/**
* @Package：cn.ucaner.alpaca.pay.common.core.entity   
* @ClassName：ApiCommonResultVo   
* @Description：   <p> api请求正常返回结果,该实体作为API请求时,按照规范返回的实体. code 为返回码 msg 为返回描述 data 为返回的具体结果 Created</p>
* @Author： - Jason   
* @CreatTime：2018年5月10日 下午9:59:45   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public class ApiCommonResultVo {

	public ApiCommonResultVo(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		if (data != null) {
			this.data = data;
		}
	}

	public ApiCommonResultVo(Object data) {
		this.code = 0;
		this.msg = "";
		if (data != null) {
			this.data = data;
		}
	}

	/**
	 * 返回码
	 */
	private int code;

	/**
	 * 返回描述
	 */
	private String msg = "";

	/**
	 * 返回数据
	 */
	private Object data = new Object();

	public void setCode(int code) {
		this.code = code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public Object getData() {
		return data;
	}

	public static void main(String[] args) {
		System.out.println(JSONObject.toJSONString(new ApiCommonResultVo(-1, "", null)));
	}
}
