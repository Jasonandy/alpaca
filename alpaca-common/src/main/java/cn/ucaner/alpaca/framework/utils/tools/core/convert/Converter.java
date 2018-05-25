package cn.ucaner.alpaca.framework.utils.tools.core.convert;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.convert   
* @ClassName：Converter   
* @Description：   <p> 转换器接口，实现类型转换 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午1:24:54   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface Converter<T> {
	
	/**
	 * 转换为指定类型<br>
	 * 如果类型无法确定，将读取默认值的类型做为目标类型
	 * 
	 * @param value 原始值
	 * @param defaultValue 默认值
	 * @return 转换后的值
	 * @throws IllegalArgumentException 无法确定目标类型，且默认值为{@code null}，无法确定类型
	 */
	public T convert(Object value, T defaultValue) throws IllegalArgumentException;

}