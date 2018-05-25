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
package cn.ucaner.alpaca.framework.utils.tools.script;

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.script   
* @ClassName：ScriptUtil   
* @Description：   <p> 脚本工具类 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:10:36   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public final class ScriptUtil {
	
	/**
	 * 获得 {@link ScriptEngine} 实例
	 * @param name 脚本名称
	 * @return {@link ScriptEngine} 实例
	 */
	public static ScriptEngine getScript(String name){
		return new ScriptEngineManager().getEngineByName(name);
	}
	
	/**
	 * 获得 Javascript引擎 {@link JavaScriptEngine}
	 * @return {@link JavaScriptEngine}
	 */
	public static JavaScriptEngine getJavaScriptEngine(){
		return new JavaScriptEngine();
	}
	
	/**
	 * 编译脚本
	 * @param engine 引擎
	 * @param script 脚本内容
	 * @return {@link CompiledScript}
	 * @throws ScriptException 脚本异常
	 */
	public static CompiledScript compile(ScriptEngine engine, String script) throws ScriptException{
		if(engine instanceof Compilable){
			Compilable compEngine = (Compilable)engine;
			return compEngine.compile(script);
		}
		return null;
	}
}
