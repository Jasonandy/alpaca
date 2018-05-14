package cn.ucaner.alpaca.pay.permission.dao;

import java.util.List;

import cn.ucaner.alpaca.pay.permission.entity.PmsOperator;

/**
* @Package：cn.ucaner.alpaca.pay.permission.dao   
* @ClassName：PmsOperatorDao   
* @Description：   <p> 操作员dao</p>
* @Author： -    
* @CreatTime：2018年5月10日 下午10:50:38   
* @Modify By：   
* @ModifyTime：  2018年5月10日
* @Modify marker：   
* @version    V1.0
 */
public interface PmsOperatorDao extends PermissionBaseDao<PmsOperator> {

	/**
	 * 根据操作员登录名获取操作员信息.
	 * 
	 * @param loginName
	 *            .
	 * @return operator .
	 */
	PmsOperator findByLoginName(String loginName);

	/**
	 * 根据角色ID找到操作员列表.
	 * 
	 * @param roleId
	 * @return
	 */
	List<PmsOperator> listByRoleId(Long roleId);
}
