package cn.ucaner.alpaca.pay.permission.dao;

import java.util.List;

import cn.ucaner.alpaca.pay.permission.entity.PmsMenuRole;

/**
* @Package：cn.ucaner.alpaca.pay.permission.dao   
* @ClassName：PmsMenuRoleDao   
* @Description：   <p> 菜单角色关联表</p>
* @Author： -    
* @CreatTime：2018年5月10日 下午10:48:53   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public interface PmsMenuRoleDao extends PermissionBaseDao<PmsMenuRole> {

	/**
	 * 根据角色ID删除菜单与角色的关联记录.
	 * 
	 * @param roleId
	 */
	void deleteByRoleId(Long roleId);

	/**
	 * 根据角色ID统计关联到此角色的菜单数.
	 * 
	 * @param roleId
	 *            角色ID.
	 * @return count.
	 */
	List<PmsMenuRole> listByRoleId(Long roleId);
}