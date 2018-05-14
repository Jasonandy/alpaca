package cn.ucaner.alpaca.pay.trade.utils.alipay.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.methods.multipart.FilePartSource;
import org.apache.commons.httpclient.methods.multipart.PartSource;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
* @Package：cn.ucaner.alpaca.pay.trade.utils.alipay.util   
* @ClassName：AlipayCore   
* @Description：   <p> 支付宝接口公用函数类
* 该类是请求、通知返回两个文件所调用的公用函数核心处理文件，不需要修改
* </p>
* @Author： - wubin   
* @CreatTime：2018年5月11日 上午10:03:08   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class AlipayCore {

    /** 私有构造函数 **/
    private AlipayCore(){}

    /** 
     * 除去数组中的空值和签名参数
     * @param sArray 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
    public static Map<String, String> paraFilter(Map<String, String> sArray) {

        Map<String, String> result = new HashMap<String, String>();

        if (sArray == null || sArray.isEmpty()) {
            return result;
        }

        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (value == null || "".equals(value) || "sign".equalsIgnoreCase(key)
                || "sign_type".equalsIgnoreCase(key)) {
                continue;
            }
            result.put(key, value);
        }

        return result;
    }

    /** 
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String createLinkString(Map<String, String> params) {

        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);

            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }

    /**
     * 生成文件摘要
     * @param strFilePath 文件路径
     * @param file_digest_type 摘要算法
     * @return 文件摘要结果
     */
    public static String getAbstract(String strFilePath, String file_digest_type) throws IOException {
        PartSource file = new FilePartSource(new File(strFilePath));
    	if("MD5".equals(file_digest_type)){
    		return DigestUtils.md5Hex(file.createInputStream());
    	}
    	else if("SHA".equals(file_digest_type)) {
    		return DigestUtils.sha256Hex(file.createInputStream());
    	}
    	else {
    		return "";
    	}
    }
}
