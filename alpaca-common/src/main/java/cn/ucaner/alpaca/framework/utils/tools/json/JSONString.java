package cn.ucaner.alpaca.framework.utils.tools.json;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.json   
* @ClassName：JSONString   
* @Description：   <p> <code>JSONString</code> </p>
* 接口定义了一个<code>toJSONString()</code><br>
* 实现此接口的类可以通过实现<code>toJSONString()</code>方法来改变转JSON字符串的方式。
* @Author： -    
* @CreatTime：2018年5月25日 上午10:56:47   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface JSONString {

	/**
	 * 自定义转JSON字符串的方法
	 * 
	 * @return JSON字符串
	 */
	public String toJSONString();
}
