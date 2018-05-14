package cn.ucaner.alpaca.pay.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.ucaner.alpaca.pay.controller.common.ConstantClass;
import cn.ucaner.alpaca.pay.user.entity.RpUserInfo;


/**
* @Package：cn.ucaner.alpaca.pay.controller.filter   
* @ClassName：UserFilter   
* @Description：   <p> 粗粒度权限控制拦截过滤器 </p>
* @Author： -    
* @CreatTime：2018年5月12日 下午2:23:48   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
public class UserFilter implements Filter {
    
    private static final Log LOG = LogFactory.getLog(UserFilter.class);

    public void destroy() {
        // Do nothing because of X and Y.
    }

    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String uri = request.getServletPath(); // 请求路径
        LOG.info("=== uri=" + uri);
        
        // 获取登录的用户
        RpUserInfo rpUserInfo = (RpUserInfo)request.getSession().getAttribute(ConstantClass.USER);
        // 如果未登录,重定向到登录界面
        if (uri.contains("merchant") && rpUserInfo == null) {
            HttpServletResponse response = (HttpServletResponse) res;
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            chain.doFilter(req, res);
        }
    }

    public void init(FilterConfig arg0) throws ServletException {
        // Do nothing because of X and Y.
    }

}
