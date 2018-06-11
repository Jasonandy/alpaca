package cn.ucaner.alpaca.app.reconciliation.vo;

import java.util.ArrayList;
import java.util.List;

import cn.ucaner.alpaca.pay.common.enums.PayWayEnum;
import cn.ucaner.alpaca.pay.common.enums.PublicStatusEnum;

/**
* @Package：cn.ucaner.alpaca.app.reconciliation.vo   
* @ClassName：ReconciliationInterface   
* @Description：   <p> 对账接口实体</p>
* @Author： -    
* @CreatTime：2018年5月12日 下午2:54:19   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
public class ReconciliationInterface {

	/** 接口名称 */
	private String interfaceName;

	/** 接口代码 */
	private String interfaceCode;

	/** 接口描述 */
	private String interfaceDesc;

	/** 是否有效 PublicStatusEnum */
	private String status;

	/** 对账单周期 **/
	private int billDay;

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getInterfaceCode() {
		return interfaceCode;
	}

	public void setInterfaceCode(String interfaceCode) {
		this.interfaceCode = interfaceCode;
	}

	public String getInterfaceDesc() {
		return interfaceDesc;
	}

	public void setInterfaceDesc(String interfaceDesc) {
		this.interfaceDesc = interfaceDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getBillDay() {
		return billDay;
	}

	public void setBillDay(int billDay) {
		this.billDay = billDay;
	}

	public static List<ReconciliationInterface> getInterface() {
		List<ReconciliationInterface> list = new ArrayList<ReconciliationInterface>();

		// 微信支付
		ReconciliationInterface weixin = new ReconciliationInterface();
		weixin.setInterfaceCode(PayWayEnum.WEIXIN.name());
		weixin.setInterfaceName(PayWayEnum.WEIXIN.getDesc());
		weixin.setStatus(PublicStatusEnum.ACTIVE.name());
		weixin.setBillDay(1);
		list.add(weixin);

		// 支付宝
		ReconciliationInterface alipay = new ReconciliationInterface();
		alipay.setInterfaceCode(PayWayEnum.ALIPAY.name());
		alipay.setInterfaceName(PayWayEnum.ALIPAY.getDesc());
		alipay.setStatus(PublicStatusEnum.ACTIVE.name());
		alipay.setBillDay(1);
		list.add(alipay);
		return list;

	}
}
