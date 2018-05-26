package cn.ucaner.alpaca.framework.utils.tools.core.lang;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.lang   
* @ClassName：VoidFunc   
* @Description：   <p> 函数对象 </p>
* 接口灵感来自于<a href="http://actframework.org/">ActFramework</a><br>
*  一个函数接口代表一个一个函数，用于包装一个函数为对象<br>
*  在JDK8之前，Java的函数并不能作为参数传递，也不能作为返回值存在，此接口用于将一个函数包装成为一个对象，从而传递对象
* @Author： - wubin   
* @CreatTime：2018年5月25日 下午10:52:32   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface VoidFunc {
	
	/**
	 * 执行函数
	 */
	void call() throws Exception;
}
