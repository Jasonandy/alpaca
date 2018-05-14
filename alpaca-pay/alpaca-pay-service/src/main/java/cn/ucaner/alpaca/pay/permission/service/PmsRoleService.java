package cn.ucaner.alpaca.pay.permission.service;

import java.util.List;

import cn.ucaner.alpaca.pay.common.core.page.PageBean;
import cn.ucaner.alpaca.pay.common.core.page.PageParam;
import cn.ucaner.alpaca.pay.permission.entity.PmsRole;

/**
* @Package：cn.ucaner.alpaca.pay.permission.service   
* @ClassName：PmsRoleService   
* @Description：   <p> 角色service接口</p>
* @Author： -    
* @CreatTime：2018年5月10日 下午10:54:45   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public interface PmsRoleService {

	/**
	 * 创建pmsRole
	 */
	void saveData(PmsRole pmsRole);

	/**
	 * 修改pmsRole
	 */
	void updateData(PmsRole pmsRole);

	/**
	 * 根据id获取数据pmsRole
	 * 
	 * @param id
	 * @return
	 */
	PmsRole getDataById(Long id);

	/**
	 * 分页查询pmsRole
	 * 
	 * @param pageParam
	 * @param ActivityVo
	 *            PmsRole
	 * @return
	 */
	PageBean listPage(PageParam pageParam, PmsRole pmsRole);

	/**
	 * 获取所有角色列表，以供添加操作员时选择.
	 * 
	 * @return roleList .
	 */
	public List<PmsRole> listAllRole();

	/**
	 * 判断此权限是否关联有角色
	 * 
	 * @param permissionId
	 * @return
	 */
	List<PmsRole> listByPermissionId(Long permissionId);

	/**
	 * 根据角色名或者角色编号查询角色
	 * 
	 * @param roleName
	 * @param roleCode
	 * @return
	 */
	PmsRole getByRoleNameOrRoleCode(String roleName, String roleCode);

	/**
	 * 删除
	 * 
	 * @param roleId
	 */
	void delete(Long roleId);

}
