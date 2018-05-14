package cn.ucaner.alpaca.pay.permission.service;

/**
* @Package：cn.ucaner.alpaca.pay.permission.service   
* @ClassName：PmsMenuRoleService   
* @Description：   <p> 菜单角色service接口</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:13:02   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public interface PmsMenuRoleService {

	/**
	 * 根据角色ID统计关联到此角色的菜单数.
	 * 
	 * @param roleId
	 *            角色ID.
	 * @return count.
	 */
	public int countMenuByRoleId(Long roleId);

	/**
	 * 根据角色id，删除该角色关联的所有菜单权限
	 * 
	 * @param roleId
	 */
	public void deleteByRoleId(Long roleId);

	public void saveRoleMenu(Long roleId, String roleMenuStr);

}
