package cn.ucaner.alpaca.framework.utils.tools.core.io.resource;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;
import java.nio.charset.Charset;

import cn.ucaner.alpaca.framework.utils.tools.core.io.IORuntimeException;
import cn.ucaner.alpaca.framework.utils.tools.core.util.CharsetUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.io.resource   
* @ClassName：BytesResource   
* @Description：   <p> 基于byte[]的资源获取器 </p>
* 注意：此对象中getUrl方法始终返回null
* @Author： -    
* @CreatTime：2018年5月25日 下午11:54:55   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class BytesResource implements Resource {

	private byte[] bytes;

	/**
	 * 构造
	 * 
	 * @param bytes 字节数组
	 */
	public BytesResource(byte[] bytes) {
		this.bytes = bytes;
	}

	@Override
	public URL getUrl() {
		return null;
	}

	@Override
	public InputStream getStream() {
		return new ByteArrayInputStream(this.bytes);
	}

	@Override
	public BufferedReader getReader(Charset charset) {
		return new BufferedReader(new StringReader(readStr(charset)));
	}

	@Override
	public String readStr(Charset charset) throws IORuntimeException {
		return StrUtil.str(this.bytes, charset);
	}

	@Override
	public String readUtf8Str() throws IORuntimeException {
		return readStr(CharsetUtil.CHARSET_UTF_8);
	}

	@Override
	public byte[] readBytes() throws IORuntimeException {
		return this.bytes;
	}

}
