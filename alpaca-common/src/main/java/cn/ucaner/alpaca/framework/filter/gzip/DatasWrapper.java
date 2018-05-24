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
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
* @Package：cn.ucaner.framework.filter.gzip   
* @ClassName：DatasWrapper   
* @Description：   <p> 
* CompressionResponseWrapper类从HttpServletWrapper类继承 重写了getWriter()和getOutputStream()方法
 * 用GZIPServletOutputStream替换了ServletOutputStream对象
* </p>
* @Author： - Jason 
* @CreatTime：2017年8月30日 下午1:50:53   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class DatasWrapper extends HttpServletResponseWrapper {
	
	public static final int OUT_NONE = 0;
	public static final int OUT_WRITER = 1;
	public static final int OUT_STREAM = 2;
	private int outputType = OUT_NONE;
	private ServletOutputStream output = null;
	private PrintWriter writer = null;
	private ByteArrayOutputStream buffer = null;

	public DatasWrapper(HttpServletResponse response) {
		super(response);
		buffer = new ByteArrayOutputStream();
	}

	public PrintWriter getWriter() throws IOException {
		if (outputType == OUT_STREAM) {
			throw new IllegalStateException();
		} else if (outputType == OUT_WRITER) {
			return writer;
		} else {
			outputType = OUT_WRITER;
			writer = new PrintWriter(new OutputStreamWriter(buffer, getCharacterEncoding()));
			return writer;
		}
	}

	public ServletOutputStream getOutputStream() throws IOException {
		if (outputType == OUT_WRITER) {
			throw new IllegalStateException();
		} else if (outputType == OUT_STREAM) {
			return output;
		} else {
			outputType = OUT_STREAM;
			output = new DatasWrappedOutputStream(buffer);
			return output;
		}
	}

	public void flushBuffer() throws IOException {
		if (outputType == OUT_WRITER) {
			writer.flush();
		}
		if (outputType == OUT_STREAM) {
			output.flush();
		}
	}

	public void reset() {
		outputType = OUT_NONE;
		buffer.reset();
	}

	public void finalize() throws Throwable {
		super.finalize();
		output.close();
		writer.close();

	}

	public byte[] getResponseData() throws IOException {
		flushBuffer();
		return buffer.toByteArray();
	}

	class DatasWrappedOutputStream extends ServletOutputStream {
		private ByteArrayOutputStream buffer;

		public DatasWrappedOutputStream(ByteArrayOutputStream buffer) {
			this.buffer = buffer;
		}

		public void write(int b) throws IOException {
			buffer.write(b);
		}

		public byte[] toByteArray() {
			return buffer.toByteArray();
		}
	}
}
