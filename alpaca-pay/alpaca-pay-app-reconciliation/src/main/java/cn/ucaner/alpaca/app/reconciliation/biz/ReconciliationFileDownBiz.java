package cn.ucaner.alpaca.app.reconciliation.biz;

import java.io.File;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.ucaner.alpaca.pay.common.utils.StringUtil;
import cn.ucaner.alpaca.pay.reconciliation.fileDown.service.ReconciliationFactory;

/**
* @Package：cn.ucaner.alpaca.app.reconciliation.biz   
* @ClassName：ReconciliationFileDownBiz   
* @Description：   <p> 对账文件下载业务逻辑. </p>
* @Author： -    
* @CreatTime：2018年5月12日 下午2:49:26   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
@Component("reconciliationFileDownBiz")
public class ReconciliationFileDownBiz {

	private static final Log LOG = LogFactory.getLog(ReconciliationFileDownBiz.class);
	private static final int DOWNLOAD_TRY_TIMES = 3;// 下载尝试次数

	@Autowired
	private ReconciliationFactory reconciliationFactory;

	/**
	 * 请求下载对账文件 .
	 * 
	 * @param interfaceCode
	 *            支付渠道
	 * @param billDate
	 *            账单日
	 * @return
	 */
	public File downReconciliationFile(String interfaceCode, Date billDate) {

		// 支付渠道编码
		if (StringUtil.isEmpty(interfaceCode)) {
			LOG.info("支付渠道编码为空");
			return null;
		}

		// 对账单下载
		return this.downFile(interfaceCode, billDate);
	}

	/**
	 * 下载文件
	 * 
	 * @param interfaceCode
	 *            接口编码
	 * @param tradeGainCheckFileTime
	 *            业务对账文件的获取时间
	 */
	private File downFile(String interfaceCode, Date billDate) {

		LOG.info("银行渠道编号[" + interfaceCode + "],进入下载业务对账文件操作>>>");

		try {
			File file = null;
			int downloadTrytimes = 0;
			// 默认尝试三次
			while (file == null && downloadTrytimes < DOWNLOAD_TRY_TIMES) {
				try {
					downloadTrytimes++;
					// 使用工厂模式
					file = reconciliationFactory.fileDown(interfaceCode, billDate);
				} catch (Exception e) {
					LOG.error("下载账单文件失败", e);
					Thread.sleep(10000);
				}
			}
			return file;
		} catch (Exception e) {
			LOG.error("下载微信账单文件失败", e);
		}
		return null;
	}
}
