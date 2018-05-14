package cn.ucaner.alpaca.pay.permission.entity;

/**
* @Package：cn.ucaner.alpaca.pay.permission.entity   
* @ClassName：PmsRolePermission   
* @Description：   <p> 权限管理-角色权限关联表</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:08:48   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class PmsRolePermission extends PermissionBaseEntity {

	private static final long serialVersionUID = -9012707031072904356L;
	private Long roleId; // 角色ID
	private Long permissionId;// 权限ID

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
	 * 权限ID
	 * 
	 * @return
	 */
	public Long getPermissionId() {
		return permissionId;
	}

	/**
	 * 权限ID
	 * 
	 * @return
	 */
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public PmsRolePermission() {
		super();
	}

}
