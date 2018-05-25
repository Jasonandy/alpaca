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
package cn.ucaner.alpaca.framework.utils.tools.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import cn.ucaner.alpaca.framework.utils.tools.core.io.IORuntimeException;
import cn.ucaner.alpaca.framework.utils.tools.core.io.IoUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.util   
* @ClassName：RuntimeUtil   
* @Description：   <p> 系统运行时工具类，用于执行系统命令的工具 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午11:14:26   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class RuntimeUtil {
	
	/**
	 * 执行系统命令，使用系统默认编码
	 * 
	 * @param cmds 命令列表，每个元素代表一条命令
	 * @return 执行结果
	 * @throws IORuntimeException IO异常
	 */
	public static String execForStr(String... cmds) throws IORuntimeException {
		return execForStr(CharsetUtil.systemCharset(), cmds);
	}

	/**
	 * 执行系统命令，使用系统默认编码
	 * 
	 * @param charset 编码
	 * @param cmds 命令列表，每个元素代表一条命令
	 * @return 执行结果
	 * @throws IORuntimeException IO异常
	 * @since 3.1.2
	 */
	public static String execForStr(Charset charset, String... cmds) throws IORuntimeException {
		return getResult(exec(cmds), charset);
	}

	/**
	 * 执行系统命令，使用系统默认编码
	 * 
	 * @param cmds 命令列表，每个元素代表一条命令
	 * @return 执行结果，按行区分
	 * @throws IORuntimeException IO异常
	 */
	public static List<String> execForLines(String... cmds) throws IORuntimeException {
		return execForLines(CharsetUtil.systemCharset(), cmds);
	}

	/**
	 * 执行系统命令，使用系统默认编码
	 * 
	 * @param charset 编码
	 * @param cmds 命令列表，每个元素代表一条命令
	 * @return 执行结果，按行区分
	 * @throws IORuntimeException IO异常
	 * @since 3.1.2
	 */
	public static List<String> execForLines(Charset charset, String... cmds) throws IORuntimeException {
		return getResultLines(exec(cmds), charset);
	}

	/**
	 * 执行命令<br>
	 * 命令带参数时参数可作为其中一个参数，也可以将命令和参数组合为一个字符串传入
	 * 
	 * @param cmds 命令
	 * @return {@link Process}
	 */
	public static Process exec(String... cmds) {
		if (ArrayUtil.isEmpty(cmds)) {
			throw new NullPointerException("Command is empty !");
		}

		// 单条命令的情况
		if (1 == cmds.length) {
			final String cmd = cmds[0];
			if (StrUtil.isBlank(cmd)) {
				throw new NullPointerException("Command is empty !");
			}
			cmds = StrUtil.splitToArray(cmd, StrUtil.C_SPACE);
		}

		Process process;
		try {
			process = new ProcessBuilder(cmds).redirectErrorStream(true).start();
		} catch (IOException e) {
			throw new IORuntimeException(e);
		}
		return process;
	}

	// -------------------------------------------------------------------------------------------------- result
	/**
	 * 获取命令执行结果，使用系统默认编码，获取后销毁进程
	 * 
	 * @param process {@link Process} 进程
	 * @return 命令执行结果列表
	 */
	public static List<String> getResultLines(Process process) {
		return getResultLines(process, CharsetUtil.systemCharset());
	}

	/**
	 * 获取命令执行结果，使用系统默认编码，获取后销毁进程
	 * 
	 * @param process {@link Process} 进程
	 * @param charset 编码
	 * @return 命令执行结果列表
	 * @since 3.1.2
	 */
	public static List<String> getResultLines(Process process, Charset charset) {
		InputStream in = null;
		try {
			in = process.getInputStream();
			return IoUtil.readLines(in, charset, new ArrayList<String>());
		} finally {
			IoUtil.close(in);
		}
	}

	/**
	 * 获取命令执行结果，使用系统默认编码，，获取后销毁进程
	 * 
	 * @param process {@link Process} 进程
	 * @return 命令执行结果列表
	 * @since 3.1.2
	 */
	public static String getResult(Process process) {
		return getResult(process, CharsetUtil.systemCharset());
	}

	/**
	 * 获取命令执行结果，获取后销毁进程
	 * 
	 * @param process {@link Process} 进程
	 * @param charset 编码
	 * @return 命令执行结果列表
	 * @since 3.1.2
	 */
	public static String getResult(Process process, Charset charset) {
		InputStream in = null;
		try {
			in = process.getInputStream();
			return IoUtil.read(in, charset);
		} finally {
			IoUtil.close(in);
			destroy(process);
		}
	}
	
	/**
	 * 销毁进程
	 * @param process 进程
	 * @since 3.1.2
	 */
	public static void destroy(Process process) {
		if(null != process) {
			process.destroy();
		}
	}
	
	public static void main(String[] args) {
		execForStr("ls");
	}
}
