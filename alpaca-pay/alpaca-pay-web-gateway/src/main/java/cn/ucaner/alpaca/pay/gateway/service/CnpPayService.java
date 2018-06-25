package cn.ucaner.alpaca.pay.gateway.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.ucaner.alpaca.pay.common.enums.SecurityRatingEnum;
import cn.ucaner.alpaca.pay.common.utils.StringUtil;
import cn.ucaner.alpaca.pay.gateway.utils.NetworkUtil;
import cn.ucaner.alpaca.pay.trade.exception.TradeBizException;
import cn.ucaner.alpaca.pay.user.entity.RpUserPayConfig;

/**
* @Package：cn.ucaner.alpaca.pay.gateway.service   
* @ClassName：CnpPayService   
* @Description：   <p> CnpPayService</p>
* @Author： -    
* @CreatTime：2018年5月11日 下午1:42:22   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
@Service(value = "cnpPayService")
public class CnpPayService {

    private static final Logger LOG = LoggerFactory.getLogger(CnpPayService.class);

    /**
     *
     * @param rpUserPayConfig
     * @param httpServletRequest
     */
    public void checkIp(RpUserPayConfig rpUserPayConfig, HttpServletRequest httpServletRequest) {
        try {

            if (!SecurityRatingEnum.MD5_IP.name().equals(rpUserPayConfig.getSecurityRating())) {
                return;
            }

            String ip = NetworkUtil.getIpAddress(httpServletRequest);
            if (StringUtil.isEmpty(ip)) {
                throw new TradeBizException(TradeBizException.TRADE_PARAM_ERROR, "获取请求IP错误");
            }

            String merchantServerIp = rpUserPayConfig.getMerchantServerIp();
            if (merchantServerIp.indexOf(ip) < 0) {
                throw new TradeBizException(TradeBizException.TRADE_PARAM_ERROR, "非法IP请求");
            }

        } catch (IOException e) {
            LOG.error("获取请求IP异常:", e);
            throw new TradeBizException(TradeBizException.TRADE_PARAM_ERROR, "获取请求IP异常");
        }
    }

}
