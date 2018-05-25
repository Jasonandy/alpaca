package cn.ucaner.alpaca.framework.utils.tools.core.date;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.date   
* @ClassName：Season   
* @Description：   <p> 季度枚举 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午1:18:18   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public enum Season {

	/** 春季（第一季度） */
	SPRING(1),
	/** 夏季（第二季度） */
	SUMMER(2),
	/** 秋季（第三季度） */
	ANTUMN(3),
	/** 冬季（第四季度） */
	WINTER(4);
	
	// ---------------------------------------------------------------
	private int value;

	private Season(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	/**
	 * 将 季度int转换为Season枚举对象<br>
	 * 
	 * @see #SPRING
	 * @see #SUMMER
	 * @see #ANTUMN
	 * @see #WINTER
	 * 
	 * @param intValue 季度int表示
	 * @return {@link Season}
	 */
	public static Season of(int intValue) {
		switch (intValue) {
			case 1:
				return SPRING;
			case 2:
				return SUMMER;
			case 3:
				return ANTUMN;
			case 4:
				return WINTER;
			default:
				return null;
		}
	}
}
