package cn.ucaner.alpaca.framework.utils.tools.http.test;

import org.junit.Assert;
import org.junit.Test;

import cn.ucaner.alpaca.framework.utils.tools.http.HtmlUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.http.test   
* @ClassName：HtmlUtilTest   
* @Description：   <p> Html单元测试 </p>
* @Author： -    
* @CreatTime：2018年5月26日 下午4:52:20   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class HtmlUtilTest {
	
	@Test
	public void removeHtmlTagTest() {
		//非闭合标签
		String str = "pre<img src=\"xxx/dfdsfds/test.jpg\">";
		String result = HtmlUtil.removeHtmlTag(str, "img");
		Assert.assertEquals("pre", result);
		
		//闭合标签
		str = "pre<img>";
		result = HtmlUtil.removeHtmlTag(str, "img");
		Assert.assertEquals("pre", result);
		
		//闭合标签
		str = "pre<img src=\"xxx/dfdsfds/test.jpg\" />";
		result = HtmlUtil.removeHtmlTag(str, "img");
		Assert.assertEquals("pre", result);
		
		//闭合标签
		str = "pre<img />";
		result = HtmlUtil.removeHtmlTag(str, "img");
		Assert.assertEquals("pre", result);
		
		//包含内容标签
		str = "pre<div class=\"test_div\">dfdsfdsfdsf</div>";
		result = HtmlUtil.removeHtmlTag(str, "div");
		Assert.assertEquals("pre", result);
		
		//带换行
		str = "pre<div class=\"test_div\">\r\n\t\tdfdsfdsfdsf\r\n</div>";
		result = HtmlUtil.removeHtmlTag(str, "div");
		Assert.assertEquals("pre", result);
	}
	
	@Test
	public void unwrapHtmlTagTest() {
		//非闭合标签
		String str = "pre<img src=\"xxx/dfdsfds/test.jpg\">";
		String result = HtmlUtil.unwrapHtmlTag(str, "img");
		Assert.assertEquals("pre", result);
		
		//闭合标签
		str = "pre<img>";
		result = HtmlUtil.unwrapHtmlTag(str, "img");
		Assert.assertEquals("pre", result);
		
		//闭合标签
		str = "pre<img src=\"xxx/dfdsfds/test.jpg\" />";
		result = HtmlUtil.unwrapHtmlTag(str, "img");
		Assert.assertEquals("pre", result);
		
		//闭合标签
		str = "pre<img />";
		result = HtmlUtil.unwrapHtmlTag(str, "img");
		Assert.assertEquals("pre", result);
		
		//包含内容标签
		str = "pre<div class=\"test_div\">abc</div>";
		result = HtmlUtil.unwrapHtmlTag(str, "div");
		Assert.assertEquals("preabc", result);
		
		//带换行
		str = "pre<div class=\"test_div\">\r\n\t\tabc\r\n</div>";
		result = HtmlUtil.unwrapHtmlTag(str, "div");
		Assert.assertEquals("pre\r\n\t\tabc\r\n", result);
	}
}
