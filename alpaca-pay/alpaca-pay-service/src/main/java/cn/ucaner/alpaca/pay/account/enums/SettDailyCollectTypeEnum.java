package cn.ucaner.alpaca.pay.account.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @Package：cn.ucaner.alpaca.pay.account.enums   
* @ClassName：SettDailyCollectTypeEnum   
* @Description：   <p> 结算日汇总类型 </p>
* @Author： - Jason   
* @CreatTime：2018年5月10日 下午10:36:17   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public enum SettDailyCollectTypeEnum {

	/**
	 * 存入/减少汇总
	 */
	ALL("存入/减少汇总"),

	/**
	 * 临时汇总
	 */
	TEMP("临时汇总"),
	/**
	 * 未结算遗留汇总(例如：小数点后两位部分)
	 */
	LEAVE("遗留汇总");

	/** 描述 */
	private String desc;

	private SettDailyCollectTypeEnum(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static SettDailyCollectTypeEnum getEnum(String enumName) {
		SettDailyCollectTypeEnum resultEnum = null;
		SettDailyCollectTypeEnum[] enumAry = SettDailyCollectTypeEnum.values();
		for (int i = 0; i < enumAry.length; i++) {
			if (enumAry[i].name().equals(enumName)) {
				resultEnum = enumAry[i];
				break;
			}
		}
		return resultEnum;
	}

	public static Map<String, Map<String, Object>> toMap() {
		SettDailyCollectTypeEnum[] ary = SettDailyCollectTypeEnum.values();
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
		SettDailyCollectTypeEnum[] ary = SettDailyCollectTypeEnum.values();
		List list = new ArrayList();
		for (int i = 0; i < ary.length; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("desc", ary[i].getDesc());
			list.add(map);
		}
		return list;
	}
}
