package cn.ucaner.alpaca.framework.utils.tools.http.test;

import org.junit.Ignore;
import org.junit.Test;

import cn.ucaner.alpaca.framework.utils.tools.core.lang.Console;
import cn.ucaner.alpaca.framework.utils.tools.http.HttpRequest;
import cn.ucaner.alpaca.framework.utils.tools.http.HttpUtil;
import cn.ucaner.alpaca.framework.utils.tools.json.JSONUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.http.test   
* @ClassName：RestTest   
* @Description：   <p> RestTest </p>
* @Author： -    
* @CreatTime：2018年5月26日 下午4:54:05   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class RestTest {
	
	@Test
	@Ignore
	public void postTest() {
		HttpRequest request = HttpRequest.post("http://localhost:8090/rest/restTest/")
				.body(JSONUtil.createObj().put("aaa", "aaaValue").put("键2", "值2"));
		Console.log(request.execute().body());
	}
	
	@Test
	@Ignore
	public void postTest2() {
		String result = HttpUtil.post("http://localhost:8090/rest/restTest/", JSONUtil.createObj().put("aaa", "aaaValue").put("键2", "值2").toString());
		Console.log(result);
	}
	
	@Test
	@Ignore
	public void postTest3() {
		HttpRequest request = HttpRequest.post("http://211.162.39.204:8181/jeesite-simple/a/open/bizGwbnService/test")
				.body(JSONUtil.createObj().put("aaa", "aaaValue").put("键2", "值2"));
		Console.log(request.execute().body());
	}
}
