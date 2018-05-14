package cn.ucaner.alpaca.pay.permission.shiro.filter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
* @Package：cn.ucner.alpaca.pay.permission.shiro.filter   
* @ClassName：RcFormAuthenticationFilter   
* @Description：   <p> 自定义form表单认证过滤器<br/>
* 目的是：验证码过滤器发现验证码错误，不需要做认证过滤
* </p>
* @Author： -    
* @CreatTime：2018年5月12日 下午12:38:47   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
public class RcFormAuthenticationFilter extends FormAuthenticationFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		if (request.getAttribute(getFailureKeyAttribute()) != null) {
			return true;
		}
		return super.onAccessDenied(request, response, mappedValue);
	}
}
