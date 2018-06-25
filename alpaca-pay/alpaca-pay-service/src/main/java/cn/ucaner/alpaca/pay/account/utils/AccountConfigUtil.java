package cn.ucaner.alpaca.pay.account.utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
* @Package：cn.ucaner.alpaca.pay.account.utils   
* @ClassName：AccountConfigUtil   
* @Description：   <p> AccountConfigUtil</p>
* @Author： - Jason   
* @CreatTime：2018年5月10日 下午10:41:48   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public class AccountConfigUtil {

    private static final Log LOG = LogFactory.getLog(AccountConfigUtil.class);

    /**
     * 通过静态代码块读取上传文件的验证格式配置文件,静态代码块只执行一次(单例)
     */
    private static Properties properties = new Properties();

    private AccountConfigUtil() {

    }

    /**
     * 通过类装载器装载进来
     */
    static {
        try {
        	/**
        	 * 从类路径下读取属性文件
        	 */
            properties.load(AccountConfigUtil.class.getClassLoader().getResourceAsStream("account_config.properties"));
        } catch (IOException e) {
            LOG.error(e);
        }
    }

    /**
     * @Description: 读取配置项 
     * @param key    
     * @return String
     * @Autor: Jason - jasonandy@hotmail.com
     */
    public static String readConfig(String key) {
        return (String) properties.get(key);
    }
}
