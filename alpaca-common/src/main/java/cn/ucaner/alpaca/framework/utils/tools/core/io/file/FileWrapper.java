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
package cn.ucaner.alpaca.framework.utils.tools.core.io.file;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import cn.ucaner.alpaca.framework.utils.tools.core.io.FileUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.CharsetUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.io.file   
* @ClassName：FileWrapper   
* @Description：   <p>  文件包装器，扩展文件对象 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午11:56:49   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class FileWrapper {
	protected File file;
	protected Charset charset;
	
	/** 默认编码：UTF-8 */
	public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

	// ------------------------------------------------------- Constructor start
	/**
	 * 构造
	 * @param file 文件
	 * @param charset 编码，使用 {@link CharsetUtil}
	 */
	public FileWrapper(File file, Charset charset) {
		this.file = file;
		this.charset = charset;
	}
	// ------------------------------------------------------- Constructor end

	// ------------------------------------------------------- Setters and Getters start start
	/**
	 * 获得文件
	 * @return 文件
	 */
	public File getFile() {
		return file;
	}

	/**
	 * 设置文件
	 * @param file 文件
	 * @return 自身
	 */
	public FileWrapper setFile(File file) {
		this.file = file;
		return this;
	}

	/**
	 * 获得字符集编码
	 * @return 编码
	 */
	public Charset getCharset() {
		return charset;
	}

	/**
	 * 设置字符集编码
	 * @param charset 编码
	 * @return 自身
	 */
	public FileWrapper setCharset(Charset charset) {
		this.charset = charset;
		return this;
	}
	// ------------------------------------------------------- Setters and Getters start end

	/**
	 * 可读的文件大小
	 * @return 大小
	 */
	public String readableFileSize() {
		return FileUtil.readableFileSize(file.length());
	}
}
