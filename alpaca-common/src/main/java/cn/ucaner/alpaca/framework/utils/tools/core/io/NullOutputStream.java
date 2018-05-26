package cn.ucaner.alpaca.framework.utils.tools.core.io;

import java.io.IOException;
import java.io.OutputStream;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.io   
* @ClassName：NullOutputStream   
* @Description：   <p> 此OutputStream写出数据到<b>/dev/null</b>，既忽略所有数据</p>
* @Author： -    
* @CreatTime：2018年5月25日 下午11:42:14   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class NullOutputStream extends OutputStream {

	/**
	 * 单例
	 */
	public static final NullOutputStream NULL_OUTPUT_STREAM = new NullOutputStream();

	/**
	 * 什么也不做，写出到<code>/dev/null</code>.
	 * 
	 * @param b 写出的数据
	 * @param off 开始位置
	 * @param len 长度
	 */
	@Override
	public void write(byte[] b, int off, int len) {
		// to /dev/null
	}

	/**
	 * 什么也不做，写出到 <code>/dev/null</code>.
	 * 
	 * @param b 写出的数据
	 */
	@Override
	public void write(int b) {
		// to /dev/null
	}

	/**
	 * 什么也不做，写出到 <code>/dev/null</code>.
	 * 
	 * @param b 写出的数据
	 * @throws IOException 不抛出
	 */
	@Override
	public void write(byte[] b) throws IOException {
		// to /dev/null
	}

}
