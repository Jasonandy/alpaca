/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 19941115</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.alpaca.framework.utils.sequence;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
* @Package：cn.ucaner.common.utils.sequence   
* @ClassName：GenerateSequenceUtil   
* @Description：   <p> 根据时间生成唯一序列ID<br>
*                 时间精确到秒,ID最大值为99999且循环使用</p>
* @Author： - Jason 
* @CreatTime：2017年10月26日 上午10:44:23   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class GenerateSequenceUtil {
	
	/**
	 * 
	 */
	private static final FieldPosition HELPER_POSITION = new FieldPosition(0);
	
	/** 时间：精确到秒 */
	private final static Format dateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
	
	private final static NumberFormat numberFormat = new DecimalFormat("00000");
	
	private static int seq = 0;
	 
    private static final int MAX = 99999;
	
	public static synchronized String generateSequenceNo() {
		 
        Calendar rightNow = Calendar.getInstance();
       
        StringBuffer sb = new StringBuffer();
 
        dateFormat.format(rightNow.getTime(), sb, HELPER_POSITION);
 
        numberFormat.format(seq, sb, HELPER_POSITION);
 
        if (seq == MAX) {
            seq = 0;
        } else {
            seq++;
        }
 
        return sb.toString();
    }
}
