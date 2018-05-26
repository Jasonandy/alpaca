package cn.ucaner.alpaca.framework.utils.tools.core.io.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

import cn.ucaner.alpaca.framework.utils.tools.core.io.IORuntimeException;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.io.resource   
* @ClassName：Resource   
* @Description：   <p> 资源接口定义 </p>
* 资源可以是文件、URL、ClassPath中的文件亦或者jar包中的文件
* @Author： -    
* @CreatTime：2018年5月25日 下午11:53:56   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public interface Resource {
	/**
	 * 获得解析后的{@link URL}
	 * @return 解析后的{@link URL}
	 */
	URL getUrl();
	
	/**
	 * 获得 {@link InputStream}
	 * @return {@link InputStream}
	 */
	InputStream getStream();
	
	/**
	 * 获得Reader
	 * @param charset 编码
	 * @return {@link BufferedReader}
	 */
	BufferedReader getReader(Charset charset);
	
	/**
	 * 读取资源内容，读取完毕后会关闭流<br>
	 * 关闭流并不影响下一次读取
	 * 
	 * @param charset 编码
	 * @return 读取资源内容
	 * @throws IORuntimeException 包装{@link IOException}
	 */
	String readStr(Charset charset) throws IORuntimeException;
	
	/**
	 * 读取资源内容，读取完毕后会关闭流<br>
	 * 关闭流并不影响下一次读取
	 * 
	 * @return 读取资源内容
	 * @throws IORuntimeException 包装IOException
	 */
	String readUtf8Str() throws IORuntimeException;
	
	/**
	 * 读取资源内容，读取完毕后会关闭流<br>
	 * 关闭流并不影响下一次读取
	 * 
	 * @return 读取资源内容
	 * @throws IORuntimeException 包装IOException
	 */
	byte[] readBytes() throws IORuntimeException;
}
