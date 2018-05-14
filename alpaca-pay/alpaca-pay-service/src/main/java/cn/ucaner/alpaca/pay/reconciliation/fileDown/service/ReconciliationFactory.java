package cn.ucaner.alpaca.pay.reconciliation.fileDown.service;

import java.io.File;
import java.util.Date;

/**
* @Package：cn.ucaner.alpaca.pay.reconciliation.fileDown.service   
* @ClassName：ReconciliationFactory   
* @Description：   <p> 该接口是用来对外开放的银行相关业务接口</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:35:12   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public interface ReconciliationFactory {

	/**
	 * 对账文件下载
	 * 
	 * @param payInterface
	 * @param fileDate
	 * @return
	 */
	File fileDown(String payInterface, Date billDate) throws Exception;

}
