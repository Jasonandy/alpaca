package cn.ucaner.alpaca.pay.common.core.entity;

import java.io.Serializable;
import java.util.Date;

import cn.ucaner.alpaca.pay.common.core.utils.StringUtil;

/**
* @Package：cn.ucaner.alpaca.pay.common.core.entity   
* @ClassName：BaseEntity   
* @Description：   <p> 基类.</p>
* @Author： - Jason   
* @CreatTime：2018年5月10日 下午9:59:09   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public class BaseEntity implements Serializable{

	private static final long serialVersionUID = -3310926795268673876L;
	
	private String id = StringUtil.get32UUID();// 主键ID.
	private Integer version = 0;// 版本号默认为0
	private String status;// 状态 PublicStatusEnum
	private String creater;// 创建人.
	private Date createTime = new Date();// 创建时间.
	private String editor;// 修改人.
	private Date editTime;// 修改时间.
	private String remark;// 描述

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
