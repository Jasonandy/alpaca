package cn.ucaner.alpaca.pay.permission.entity;

/**
* @Package：cn.ucaner.alpaca.pay.permission.entity   
* @ClassName：PmsOperatorRole   
* @Description：   <p>  权限管理-角色,操作员关联表.. </p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:09:31   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class PmsOperatorRole extends PermissionBaseEntity {

	private static final long serialVersionUID = 174356028197753020L;
	private Long roleId;// 角色ID
	private Long operatorId;// /操作员ID

	/**
	 * 角色ID
	 * 
	 * @return
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * 角色ID
	 * 
	 * @return
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * 操作员ID
	 * 
	 * @return
	 */
	public Long getOperatorId() {
		return operatorId;
	}

	/**
	 * 操作员ID
	 * 
	 * @return
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public PmsOperatorRole() {

	}

}
