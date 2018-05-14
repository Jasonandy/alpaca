package cn.ucaner.alpaca.pay.permission.dao;

import java.util.List;

import cn.ucaner.alpaca.pay.permission.entity.PmsPermission;

/**
* @Package：cn.ucaner.alpaca.pay.permission.dao   
* @ClassName：PmsPermissionDao   
* @Description：   <p> 权限点dao</p>
* @Author： -    
* @CreatTime：2018年5月10日 下午10:51:49   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public interface PmsPermissionDao extends PermissionBaseDao<PmsPermission> {
	/**
	 * 根据实体ID集字符串获取对象列表.
	 * 
	 * @param ids
	 * @return
	 */
	List<PmsPermission> findByIds(String ids);

	/**
	 * 检查权限名称是否已存在
	 * 
	 * @param trim
	 * @return
	 */
	PmsPermission getByPermissionName(String permissionName);

	/**
	 * 检查权限是否已存在
	 * 
	 * @param permission
	 * @return
	 */
	PmsPermission getByPermission(String permission);

	/**
	 * 检查权限名称是否已存在(其他id)
	 * 
	 * @param permissionName
	 * @param id
	 * @return
	 */
	PmsPermission getByPermissionNameNotEqId(String permissionName, Long id);

	/**
	 * 获取叶子菜单下所有的功能权限
	 * 
	 * @param valueOf
	 * @return
	 */
	List<PmsPermission> listAllByMenuId(Long menuId);

}
