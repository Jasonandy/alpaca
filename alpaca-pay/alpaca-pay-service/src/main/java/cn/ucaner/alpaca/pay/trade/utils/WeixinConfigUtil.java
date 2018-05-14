package cn.ucaner.alpaca.pay.trade.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.Properties;

/**
* @Package：cn.ucaner.alpaca.pay.trade.utils   
* @ClassName：WeixinConfigUtil   
* @Description：   <p> 微信属性文件工具类</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午9:54:22   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class WeixinConfigUtil {

    private static final Log LOG = LogFactory.getLog(WeixinConfigUtil.class);

    /**
     * 通过静态代码块读取上传文件的验证格式配置文件,静态代码块只执行一次(单例)
     */
    private static Properties properties = new Properties();

    private WeixinConfigUtil() {

    }

    // 通过类装载器装载进来
    static {
        try {
            // 从类路径下读取属性文件
            properties.load(WeixinConfigUtil.class.getClassLoader()
                    .getResourceAsStream("weixinpay_config.properties"));
        } catch (IOException e) {
            LOG.error(e);
        }
    }

    /**
     * 函数功能说明 ：读取配置项 Administrator 2012-12-14 修改者名字 ： 修改日期 ： 修改内容 ：
     *
     * @参数：
     * @return void
     * @throws
     */
    public static String readConfig(String key) {
        return (String) properties.get(key);
    }

    //app_id
    public static final String appId = (String) properties.get("appId");

    //商户号
    public static final String mch_id = (String) properties.get("mch_id");

    //商户秘钥
    public static final String partnerKey = (String) properties.get("partnerKey");

}
