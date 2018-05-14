package cn.ucaner.alpaca.pay.permission.entity;

/**
* @Package：cn.ucaner.alpaca.pay.permission.entity   
* @ClassName：PmsRole   
* @Description：   <p> 权限管理-角色.. </p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:08:30   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class PmsRole extends PermissionBaseEntity {

	private static final long serialVersionUID = -1850274607153125161L;
	private String roleCode; // 角色编码：例如：admin
	private String roleName; // 角色名称

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	/**
	 * 角色名称
	 * 
	 * @return
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * 角色名称
	 * 
	 * @return
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public PmsRole() {

	}
}
