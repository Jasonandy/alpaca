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
package cn.ucaner.alpaca.framework.utils.tools.log.dialect.slf4j;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.slf4j.LoggerFactory;
import org.slf4j.helpers.NOPLoggerFactory;

import cn.ucaner.alpaca.framework.utils.tools.log.Log;
import cn.ucaner.alpaca.framework.utils.tools.log.LogFactory;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.log.dialect.slf4j   
* @ClassName：Slf4jLogFactory   
* @Description：   <p> <a href="http://www.slf4j.org/">SLF4J</a> log. </p>
* <br>同样无缝支持 <a href="http://logback.qos.ch/">LogBack</a>
* @Author： - wubin   
* @CreatTime：2018年5月25日 上午10:45:28   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class Slf4jLogFactory extends LogFactory {
	
	public Slf4jLogFactory() {
		this(false);
	}

	/**
	 * 构造
	 * 
	 * @param failIfNOP 如果未找到桥接包是否报错
	 */
	public Slf4jLogFactory(boolean failIfNOP) {
		super("Slf4j");
		checkLogExist(org.slf4j.LoggerFactory.class);
		if(false == failIfNOP){
			return;
		}

		// SFL4J writes it error messages to System.err. Capture them so that the user does not see such a message on
		// the console during automatic detection.
		final StringBuilder buf = new StringBuilder();
		final PrintStream err = System.err;
		try {
			System.setErr(new PrintStream(new OutputStream(){
				@Override
				public void write(int b) {
					buf.append((char) b);
				}
			}, true, "US-ASCII"));
		} catch (UnsupportedEncodingException e) {
			throw new Error(e);
		}

		try {
			if (LoggerFactory.getILoggerFactory() instanceof NOPLoggerFactory) {
				throw new NoClassDefFoundError(buf.toString());
			} else {
				err.print(buf);
				err.flush();
			}
		} finally {
			System.setErr(err);
		}
	}

	@Override
	public Log createLog(String name) {
		return new Slf4jLog(name);
	}

	@Override
	public Log createLog(Class<?> clazz) {
		return new Slf4jLog(clazz);
	}

}
