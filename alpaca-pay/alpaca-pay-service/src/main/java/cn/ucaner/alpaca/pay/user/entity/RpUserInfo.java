package cn.ucaner.alpaca.pay.user.entity;

import java.io.Serializable;

import cn.ucaner.alpaca.pay.common.core.entity.BaseEntity;
import cn.ucaner.alpaca.pay.common.core.enums.PublicStatusEnum;

/**
* @Package：cn.ucaner.alpaca.pay.user.entity   
* @ClassName：RpUserInfo   
* @Description：   <p> 用户信息</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午9:45:12   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class RpUserInfo extends BaseEntity implements Serializable {

    private String userNo;

    private String userName;

    private String accountNo;

    private static final long serialVersionUID = 1L;
    
    private String mobile;
    
    private String password;
    /** 支付密码 */
	private String payPwd;

    public String getPayPwd() {
		return payPwd;
	}

	public void setPayPwd(String payPwd) {
		this.payPwd = payPwd;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }
    
    public String getStatusDesc() {
        return PublicStatusEnum.getEnum(this.getStatus()).getDesc();
    }

}