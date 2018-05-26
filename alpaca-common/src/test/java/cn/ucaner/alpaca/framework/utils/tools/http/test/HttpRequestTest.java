package cn.ucaner.alpaca.framework.utils.tools.http.test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import cn.ucaner.alpaca.framework.utils.tools.core.date.DateUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.date.TimeInterval;
import cn.ucaner.alpaca.framework.utils.tools.core.io.FileUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.lang.Console;
import cn.ucaner.alpaca.framework.utils.tools.core.util.CharsetUtil;
import cn.ucaner.alpaca.framework.utils.tools.http.HttpRequest;
import cn.ucaner.alpaca.framework.utils.tools.http.HttpResponse;
import cn.ucaner.alpaca.framework.utils.tools.http.HttpUtil;
import cn.ucaner.alpaca.framework.utils.tools.http.ssl.SSLSocketFactoryBuilder;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.http.test   
* @ClassName：HttpRequestTest   
* @Description：   <p> {@link HttpRequest}单元测试 </p>
* @Author： -    
* @CreatTime：2018年5月26日 下午4:52:48   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class HttpRequestTest {
	
	final String url = "http://photo.qzone.qq.com/fcgi-bin/fcg_list_album?uin=88888&outstyle=2";

	@Test
	@Ignore
	public void getHttpsTest() {
		String body = HttpRequest.get("https://www.gjifa.com/pc/").execute().body();
		Console.log(body);
	}
	
	@Test
	@Ignore
	public void getWithParamsTest() {
		String url = "http://gc.ditu.aliyun.com/geocoding?ccc=你好";
		
		HttpRequest request = HttpRequest.get(url).setEncodeUrl(true).body("a=乌海");
		String body = request.execute().body();
		Console.log(body);
		
//		String body2 = HttpUtil.get(url);
//		Console.log(body2);
	}

	@Test
	@Ignore
	public void asyncHeadTest() {
		HttpResponse response = HttpRequest.head(url).execute();
		Map<String, List<String>> headers = response.headers();
		Console.log(headers);
		Console.log(response.body());
	}

	@Test
	@Ignore
	public void asyncGetTest() {
		TimeInterval timer = DateUtil.timer();
		HttpResponse body = HttpRequest.get(url).charset("GBK").executeAsync();
		long interval = timer.interval();
		timer.restart();
		Console.log(body.body());
		long interval2 = timer.interval();
		Console.log("Async response spend {}ms, body spend {}ms", interval, interval2);
	}

	@Test
	@Ignore
	public void syncGetTest() {
		TimeInterval timer = DateUtil.timer();
		HttpResponse body = HttpRequest.get(url).charset("GBK").execute();
		long interval = timer.interval();
		timer.restart();
		Console.log(body.body());
		System.out.println(body.body());
		long interval2 = timer.interval();
		Console.log("Async response spend {}ms, body spend {}ms", interval, interval2);
	}

	@Test
	@Ignore
	public void customGetTest() {
		// 自定义构建HTTP GET请求，发送Http GET请求，针对HTTPS安全加密，可以自定义SSL
		HttpRequest request = HttpRequest.get(url)
				// 自定义返回编码
				.charset(CharsetUtil.CHARSET_GBK)
				// 禁用缓存
				.disableCache()
				// 自定义SSL版本
				.setSSLProtocol(SSLSocketFactoryBuilder.TLSv12);
		Console.log(request.execute().body());
	}

	@Test
	@Ignore
	public void uploadTest() {
		File file = FileUtil.file("D:\\face.jpg");

		// 方法一：自定义构建表单
		HttpRequest request = HttpRequest//
				.post("http://localhost:8080/file/upload")//
				.form("file", file)//
				.form("fileType", "图片");
		HttpResponse response = request.execute();
		System.out.println(response.body());
	}

	@Test
	@Ignore
	public void uploadTest2() {
		File file = FileUtil.file("D:\\face.jpg");

		// 方法二：使用统一的表单，Http模块会自动识别参数类型，并完成上传
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("city", "北京");
		paramMap.put("file", file);
		String result = HttpUtil.post("http://wthrcdn.etouch.cn/weather_mini", paramMap);
		System.out.println(result);
	}
}
