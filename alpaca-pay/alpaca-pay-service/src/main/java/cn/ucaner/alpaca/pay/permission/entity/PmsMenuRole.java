package cn.ucaner.alpaca.pay.permission.entity;


/**
* @Package：cn.ucaner.alpaca.pay.permission.entity   
* @ClassName：PmsMenuRole   
* @Description：   <p> 权限管理-角色权限关联表.</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:10:31   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class PmsMenuRole extends PermissionBaseEntity {

	private static final long serialVersionUID = -9012707031072904356L;

	/** 角色ID **/
	private Long roleId;

	/** 菜单ID **/
	private Long menuId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
}
