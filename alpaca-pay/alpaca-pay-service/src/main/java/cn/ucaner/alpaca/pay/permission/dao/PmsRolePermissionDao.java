package cn.ucaner.alpaca.pay.permission.dao;

import java.util.List;

import cn.ucaner.alpaca.pay.permission.entity.PmsRolePermission;

/**
* @Package：cn.ucaner.alpaca.pay.permission.dao   
* @ClassName：PmsRolePermissionDao   
* @Description：   <p> 角色权限dao</p>
* @Author： -    
* @CreatTime：2018年5月10日 下午10:52:45   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public interface PmsRolePermissionDao extends PermissionBaseDao<PmsRolePermission> {

	/**
	 * 根据角色ID找到角色关联的权限点.
	 * 
	 * @param roleId
	 *            .
	 * @return rolePermissionList .
	 */
	public List<PmsRolePermission> listByRoleId(final long roleId);

	/**
	 * 根据角色ID字符串获取相应角色-权限关联信息.
	 * 
	 * @param roleIds
	 * @return
	 */
	public List<PmsRolePermission> listByRoleIds(String roleIdsStr);

	public void deleteByRoleIdAndPermissionId(Long roleId, Long permissionId);
	
	public void deleteByRoleId(Long roleId);
}
