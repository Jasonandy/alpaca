package cn.ucaner.alpaca.pay.trade.utils.alipay.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
* @Package：cn.ucaner.alpaca.pay.trade.utils.alipay.util   
* @ClassName：AliPayUtil   
* @Description：   <p> AliPayUtil</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:00:19   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class AliPayUtil {

    public static Map<String , String> parseNotifyMsg(Map<String, String[]> requestParams){

        Map<String,String> params = new HashMap<String,String>();

        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }

        return params;
    }

}
