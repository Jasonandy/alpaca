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
package cn.ucaner.alpaca.framework.utils.tools.extra;

import java.io.Writer;
import java.util.Map;
import java.util.Properties;

import org.rythmengine.Rythm;
import org.rythmengine.RythmEngine;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.extra   
* @ClassName：RythmUtil   
* @Description：   <p> Rythm模板引擎工具类</p><br>
* 文档：http://rythmengine.org/doc/index
* @Author： -    
* @CreatTime：2018年5月25日 上午10:24:43   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class RythmUtil {

	/**
	 * 新建自定义的Rythm模板引擎
	 * 
	 * @param userConfiguration 配置文件，可以使用Props类
	 * @return {@link RythmEngine}
	 */
	public static RythmEngine newEngine(Properties userConfiguration) {
		return new RythmEngine(userConfiguration);
	}

	/**
	 * 使用{@link RythmEngine}渲染模板
	 * 
	 * @param engine {@link RythmEngine}
	 * @param template 模板内容
	 * @param args 变量值
	 * @return 渲染后的内容
	 */
	public static String render(RythmEngine engine, String template, Object... args) {
		return engine.render(template, args);
	}

	/**
	 * 使用{@link RythmEngine}渲染模板
	 * 
	 * @param engine {@link RythmEngine}
	 * @param writer 写出到的{@link Writer}
	 * @param template 模板内容
	 * @param args 变量值
	 */
	public static void render(RythmEngine engine, Writer writer, String template, Object... args) {
		engine.render(writer, template, args);
	}

	/**
	 * 使用{@link RythmEngine}渲染模板
	 * 
	 * @param engine {@link RythmEngine}
	 * @param writer 写出到的{@link Writer}
	 * @param template 模板内容
	 * @param args 变量值
	 */
	public static void render(RythmEngine engine, Writer writer, String template, Map<String, Object> args) {
		engine.render(writer, template, args);
	}

	/**
	 * 使用全局单例{@link RythmEngine}渲染模板
	 * 
	 * @param template 模板内容
	 * @param args 变量值
	 * @return 渲染后的内容
	 */
	public static String render(String template, Object... args) {
		return Rythm.render(template, args);
	}

	/**
	 * 使用{@link RythmEngine}渲染模板
	 * 
	 * @param engine {@link RythmEngine}
	 * @param template 模板内容
	 * @param args 变量值
	 * @return 渲染后的内容
	 */
	public static String render(RythmEngine engine, String template, Map<String, Object> args) {
		return engine.render(template, args);
	}

	/**
	 * 使用全局单例{@link RythmEngine}渲染模板
	 * 
	 * @param template 模板内容
	 * @param args 变量值
	 * @return 渲染后的内容
	 */
	public static String render(String template, Map<String, Object> args) {
		return Rythm.render(template, args);
	}
}
