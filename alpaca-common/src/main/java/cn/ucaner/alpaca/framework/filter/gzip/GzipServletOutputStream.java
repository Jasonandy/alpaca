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
package cn.ucaner.alpaca.framework.filter.gzip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;

/**
* @Package：cn.ucaner.framework.filter.gzip   
* @ClassName：GzipServletOutputStream   
* @Description：   <p> GZipServletOutputStream继承自ServletOutputStream
 * 该类的对象用于替换HttpServletResponse.getOutputStream()方法返回的ServletOutputStream对象 其内部使用GZipServletOutputStream的write(int
 * b)方法实现ServletOutputStream类的write(int b)方法 以达到压缩数据的目的</p>
* @Author： - Jason 
* @CreatTime：2017年10月20日 下午3:40:49   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class GzipServletOutputStream extends ServletOutputStream {
	
	private ByteArrayOutputStream buffer;

	public GzipServletOutputStream(ByteArrayOutputStream buffer) {
		this.buffer = buffer;
	}

	public void write(int b) throws IOException {
		buffer.write(b);
	}

	//issue Jdk7 存在问题
	public byte[] toByteArray() {
		return buffer.toByteArray();
	}
}
