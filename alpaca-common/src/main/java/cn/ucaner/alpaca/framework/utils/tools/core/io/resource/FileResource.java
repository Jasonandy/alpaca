package cn.ucaner.alpaca.framework.utils.tools.core.io.resource;

import java.io.File;

import cn.ucaner.alpaca.framework.utils.tools.core.io.FileUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.URLUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.io.resource   
* @ClassName：FileResource   
* @Description：   <p> 文件资源访问对象 </p>
* @Author： -    
* @CreatTime：2018年5月25日 下午11:53:12   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class FileResource extends UrlResource{

	// ----------------------------------------------------------------------- Constructor start
	/**
	 * 构造
	 * 
	 * @param file 文件
	 */
	public FileResource(File file) {
		super(URLUtil.getURL(file));
	}
	
	/**
	 * 构造
	 * 
	 * @param path 文件绝对路径或相对ClassPath路径，但是这个路径不能指向一个jar包中的文件
	 */
	public FileResource(String path) {
		this(FileUtil.file(path));
	}
	// ----------------------------------------------------------------------- Constructor end

}
