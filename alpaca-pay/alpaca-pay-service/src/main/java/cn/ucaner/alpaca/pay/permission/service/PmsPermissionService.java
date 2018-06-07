package cn.ucaner.alpaca.pay.permission.service;

import java.util.List;

import cn.ucaner.alpaca.pay.common.page.PageBean;
import cn.ucaner.alpaca.pay.common.page.PageParam;
import cn.ucaner.alpaca.pay.permission.entity.PmsPermission;

/**
* @Package：cn.ucaner.alpaca.pay.permission.service   
* @ClassName：PmsPermissionService   
* @Description：   <p> 权限service接口</p>
* @Author： -   
* @CreatTime：2018年5月10日 下午10:55:24   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public interface PmsPermissionService {

	/**
	 * 创建pmsPermission
	 */
	void saveData(PmsPermission pmsPermission);

	/**
	 * 修改pmsPermission
	 */
	void updateData(PmsPermission pmsPermission);

	/**
	 * 根据id获取数据pmsPermission
	 * 
	 * @param id
	 * @return
	 */
	PmsPermission getDataById(Long id);

	/**
	 * 分页查询pmsPermission
	 * 
	 * @param pageParam
	 * @param ActivityVo
	 *            PmsPermission
	 * @return
	 */
	PageBean listPage(PageParam pageParam, PmsPermission pmsPermission);

	/**
	 * 检查权限名称是否已存在
	 * 
	 * @param permissionName
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
	 * 删除
	 * 
	 * @param permissionId
	 */
	void delete(Long permissionId);

	/**
	 * 根据角色查找角色对应的功能权限ID集
	 * 
	 * @param roleId
	 * @return
	 */
	String getPermissionIdsByRoleId(Long roleId);
	
	/**
	 * 查询所有的权限
	 */
	List<PmsPermission> listAll();

}
