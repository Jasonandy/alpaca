package cn.ucaner.alpaca.pay.permission.dao;

import java.util.List;

import cn.ucaner.alpaca.pay.permission.entity.PmsOperatorRole;

/**
* @Package：cn.ucaner.alpaca.pay.permission.dao   
* @ClassName：PmsOperatorRoleDao   
* @Description：   <p> 操作员与角色dao</p>
* @Author： -    
* @CreatTime：2018年5月10日 下午10:51:25   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public interface PmsOperatorRoleDao extends PermissionBaseDao<PmsOperatorRole> {

	/**
	 * 根据操作员ID查找该操作员关联的角色.
	 * 
	 * @param operatorId
	 *            .
	 * @return list .
	 */
	List<PmsOperatorRole> listByOperatorId(Long operatorId);

	/**
	 * 根据角色ID查找该操作员关联的操作员.
	 * 
	 * @param roleId
	 * @return
	 */
	List<PmsOperatorRole> listByRoleId(Long roleId);

	/**
	 * 根据操作员ID删除与角色的关联记录.
	 * 
	 * @param operatorId
	 *            .
	 */
	void deleteByOperatorId(Long operatorId);

	/**
	 * 根据角色ID删除操作员与角色的关联关系.
	 * 
	 * @param roleId
	 *            .
	 */
	void deleteByRoleId(Long roleId);

	/**
	 * 根据角色ID和操作员ID删除关联数据(用于更新操作员的角色).
	 * 
	 * @param roleId
	 *            角色ID.
	 * @param operatorId
	 *            操作员ID.
	 */
	void deleteByRoleIdAndOperatorId(Long roleId, Long operatorId);

}
