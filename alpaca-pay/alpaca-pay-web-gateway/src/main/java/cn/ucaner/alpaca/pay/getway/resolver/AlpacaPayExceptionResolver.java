package cn.ucaner.alpaca.pay.getway.resolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import cn.ucaner.alpaca.pay.common.exception.BizException;
import cn.ucaner.alpaca.pay.getway.utils.JsonUtils;

/**
* @Package：cn.ucaner.alpaca.pay.getway.resolver   
* @ClassName：AlpacaPayExceptionResolver   
* @Description：   <p> AlpacaPayExceptionResolver</p>
* @Author： -    
* @CreatTime：2018年5月11日 下午1:43:12   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class AlpacaPayExceptionResolver implements HandlerExceptionResolver {

    private static final Logger LOG = LoggerFactory.getLogger(AlpacaPayExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        if (BizException.class.isAssignableFrom(ex.getClass())) {//如果是业务异常类
            BizException bizException = (BizException) ex;

            try {
                response.setContentType("text/text;charset=UTF-8");
                JsonUtils.responseJson(response, bizException.getMsg());

                Map<String, Object> map = new HashMap<String, Object>();
                map.put("errorMsg", bizException.getMsg());//将错误信息传递给view
                return new ModelAndView("exception/exception",map);
            } catch (IOException e) {
                LOG.error("系统异常:", e);

            }
        }
        return null;
    }
}
