package cn.ucaner.alpaca.pay.reconciliation.fileDown.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
* @Package：cn.ucaner.alpaca.pay.reconciliation.fileDown.service   
* @ClassName：FileDown   
* @Description：   <p> 对账文件下载</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:35:29   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public interface FileDown {

	/**
	 * 对帐文件下载，获得文件输出
	 * 
	 * @param fileDate
	 *            账单日
	 * @param dir
	 *            账单文件存储地址
	 * @return
	 * @throws Exception
	 */
	File fileDown(Date fileDate, String dir) throws IOException, Exception;

}
