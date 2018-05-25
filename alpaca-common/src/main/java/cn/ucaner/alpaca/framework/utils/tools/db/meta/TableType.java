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
package cn.ucaner.alpaca.framework.utils.tools.db.meta;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.db.meta   
* @ClassName：TableType   
* @Description：   <p> 元信息中表的类型 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午2:34:02   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public enum TableType {
	TABLE("TABLE"),//表
	VIEW("VIEW"),//视图
	SYSTEM_TABLE ("SYSTEM TABLE"),
	GLOBAL_TEMPORARY("GLOBAL TEMPORARY"),
	LOCAL_TEMPORARY("LOCAL TEMPORARY"),
	ALIAS("ALIAS"),
	SYNONYM("SYNONYM");
	
	private String value;
	/**
	 * 构造
	 * @param value 值
	 */
	TableType(String value){
		this.value = value;
	}
	/**
	 * 获取值
	 * @return 值
	 */
	public String value(){
		return this.value;
	}
}
