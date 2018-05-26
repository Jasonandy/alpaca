package cn.ucaner.alpaca.framework.utils.tools.core.lang.mutable;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.lang.mutable   
* @ClassName：Mutable   
* @Description：   <p>  提供可变值类型接口 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午10:47:12   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface Mutable<T> {

	/**
	 * 获得原始值
	 * @return 原始值
	 */
	T get();

	/**
	 * 设置值
	 * @param value 值
	 */
	void set(T value);

}