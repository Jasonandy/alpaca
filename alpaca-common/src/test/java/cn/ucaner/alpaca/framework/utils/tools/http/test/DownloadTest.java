package cn.ucaner.alpaca.framework.utils.tools.http.test;

import org.junit.Ignore;
import org.junit.Test;

import cn.ucaner.alpaca.framework.utils.tools.core.io.FileUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.io.StreamProgress;
import cn.ucaner.alpaca.framework.utils.tools.core.lang.Console;
import cn.ucaner.alpaca.framework.utils.tools.http.HttpUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.http.test   
* @ClassName：DownloadTest   
* @Description：   <p> 下载单元测试 </p>
* @Author： -    
* @CreatTime：2018年5月26日 下午4:52:04   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class DownloadTest {
	
	@Test
	@Ignore
	public void downloadSizeTest() {
		long size = HttpUtil.downloadFile("https://www.baidu.com/", FileUtil.file("d:/"));
		System.out.println("Download size: " + size);
	}
	
	@Test
	@Ignore
	public void downloadTest1() {
		long size = HttpUtil.downloadFile("http://explorer.bbfriend.com/crossdomain.xml", "d:/");
		System.out.println("Download size: " + size);
	}

	@Test
	@Ignore
	public void downloadTest() {
		// 带进度显示的文件下载
		HttpUtil.downloadFile("http://mirrors.sohu.com/centos/7/isos/x86_64/CentOS-7-x86_64-NetInstall-1708.iso", FileUtil.file("d:/"), new StreamProgress() {

			long time = System.currentTimeMillis();

			@Override
			public void start() {
				Console.log("开始下载。。。。");
			}

			@Override
			public void progress(long progressSize) {
				long speed = progressSize / (System.currentTimeMillis() - time) * 1000;
				Console.log("已下载：{}, 速度：{}/s", FileUtil.readableFileSize(progressSize), FileUtil.readableFileSize(speed));
			}

			@Override
			public void finish() {
				Console.log("下载完成！");
			}
		});
	}
}
