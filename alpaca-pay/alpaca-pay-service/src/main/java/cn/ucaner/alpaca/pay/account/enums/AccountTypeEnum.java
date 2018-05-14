package cn.ucaner.alpaca.pay.account.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* @Package：cn.ucaner.alpaca.pay.account.enums   
* @ClassName：AccountTypeEnum   
* @Description：   <p> 账户类型</p>
* @Author： - Jason   
* @CreatTime：2018年5月10日 下午10:35:25   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public enum AccountTypeEnum {

	/**
	 * 用户
	 */
	USER("用户"),
	/**
	 * 企业
	 */
	ENTERPRISE("企业");

	/** 描述 */
	private String desc;

	private AccountTypeEnum(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public static AccountTypeEnum getEnum(String enumName) {
		AccountTypeEnum resultEnum = null;
		AccountTypeEnum[] enumAry = AccountTypeEnum.values();
		for (int i = 0; i < enumAry.length; i++) {
			if (enumAry[i].name().equals(enumName)) {
				resultEnum = enumAry[i];
				break;
			}
		}
		return resultEnum;
	}

	public static Map<String, Map<String, Object>> toMap() {
		AccountTypeEnum[] ary = AccountTypeEnum.values();
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
		for (int num = 0; num < ary.length; num++) {
			Map<String, Object> map = new HashMap<String, Object>();
			String key = ary[num].name();
			map.put("desc", ary[num].getDesc());
			enumMap.put(key, map);
		}
		return enumMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List toList() {
		AccountTypeEnum[] ary = AccountTypeEnum.values();
		List list = new ArrayList();
		for (int i = 0; i < ary.length; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("desc", ary[i].getDesc());
			list.add(map);
		}
		return list;
	}

}
