package cn.ucaner.alpaca.pay.getway.controller.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.ucaner.alpaca.pay.common.core.utils.StringUtil;


/**
* @Package：cn.ucaner.alpaca.pay.getway.controller.common   
* @ClassName：BaseController   
* @Description：   <p> 支付网关Controller基础类 </p>
* @Author： -    
* @CreatTime：2018年5月11日 下午1:41:09   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public abstract class BaseController {

    private static final Log log = LogFactory.getLog(BaseController.class);
    
    /**
     * 默认字符串
     */
    private static final String DEFALUT_STRING = null;
    
    /**
     * UTF-8编码
     */
	private static final String UTF_8 = "utf-8";

	/**
	 * GBK 编码
	 */
	@SuppressWarnings("unused")
	private static final String GBK = "GBK";

	/**
	 * 获取request
	 * @return
	 */
	protected HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 获取session
	 * 
	 * @return
	 */
	protected HttpSession getSession() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
	}
	
	/**
	 * 获取application
	 * @return
	 */
	protected ServletContext getApplication() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession().getServletContext();
	}

	/**
	 * @Description:获取servletContext
	 * @return ServletContext
	 * @Autor: wubin - binwu@pcitech.com
	 */
	protected ServletContext getServletContext() {
		return ContextLoader.getCurrentWebApplicationContext().getServletContext();
	}


	public String getString(String name) {
		return getString(name, DEFALUT_STRING);
	}

	/**
	 * @Description: getString() 获取k -v 的v
	 * @param name
	 * @param defaultValue
	 * @return String
	 * @Autor: jason - jasonandy@hotmail.com
	 */
	public String getString(String name, String defaultValue) {
		String resultStr = getRequest().getParameter(name);
		if (resultStr == null || "".equals(resultStr) || "null".equals(resultStr) || "undefined".equals(resultStr)) {
			return defaultValue;
		} else {
			return resultStr;
		}
	}
	
	/**
	 * 获取请求中的参数值，如果参数值为null刚转为空字符串""
	 * 
	 * @return
	 */
	public Map<String, Object> getParamMap_NullStr(Map<?, ?> map) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Set<?> keys = map.keySet();
		for (Object key : keys) {
			String value = this.getString(key.toString());
			if (value == null){
				value = "";
			}
			parameters.put(key.toString(), value);
		}
		return parameters;
	}
	

	public int getInt(String name) {
		return getInt(name, 0);
	}

	public int getInt(String name, int defaultValue) {
		String resultStr = getRequest().getParameter(name);
		if (resultStr != null) {
			try {
				return Integer.parseInt(resultStr);
			} catch (Exception e) {
				log.error("参数转换错误:",e);
				return defaultValue;
			}
		}
		return defaultValue;
	}

	public BigDecimal getBigDecimal(String name) {
		return getBigDecimal(name, null);
	}

	public BigDecimal getBigDecimal(String name, BigDecimal defaultValue) {
		String resultStr = getRequest().getParameter(name);
		if (resultStr != null) {
			try {
				return BigDecimal.valueOf(Double.parseDouble(resultStr));
			} catch (Exception e) {
				log.error("参数转换错误:",e);
				return defaultValue;
			}
		}
		return defaultValue;
	}
	
	/**
	 * 根据参数名从HttpRequest中获取String类型的参数值，无值则返回"" .
	 * @param key
	 * @return String .
	 */
	public String getString_UrlDecode_UTF8(String key) {
		try {
			String string = getString(key.toString());
			if (StringUtil.isEmpty(string)){
				return null;
			}else{
				return URLDecoder.decode(this.getString(key), UTF_8);
			}
		} catch (Exception e) {
			log.error("URL解码错误:",e);
			return "";
		}

	}

	/**
	 * @Description: getString_UrlDecode_GBK
	 * @param key
	 * @return String
	 * @Autor: jason - jasonandy@hotmail.com
	 */
	public String getString_UrlDecode_GBK(String key) {
		try {
			String string = getString(key.toString());
			if (StringUtil.isEmpty(string)){
				return null;
			}else{
				return new String(getString(string).getBytes("GBK"), "UTF-8");
			}
		} catch (Exception e) {
			log.error("参数转码错误:",e);
			return "";
		}

	}

	/**
	 * 获取客户端的IP地址
	 */
	public String getIpAddr(HttpServletRequest request) {
		String ipAddress = null;
		ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					log.error("未知主机",e);
				}
				ipAddress = inet.getHostAddress();
			}

		}

		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) {
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}
	
	/**
	 * 获取refererUrl
	 */
	public String getRefererUrl(HttpServletRequest request) {
		return request.getHeader("referer");
	}
	
    public String readRequest(HttpServletRequest request) throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            while ((line = request.getReader().readLine()) != null) {
                sb.append(line);
            }
        } finally {
            request.getReader().close();
        }
        return sb.toString();
    }
    
    /**
     * @Description: write 回写
     * @param response
     * @param s void
     */
    public void write(HttpServletResponse response, String s) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print(s);
        } catch (IOException e) {
            log.error("返回支付结果接收状态到微信支付错误", e);
        } finally {
            out.close();
        }
    }
}
