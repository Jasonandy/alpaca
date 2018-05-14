package cn.ucaner.alpaca.pay.permission.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.ucaner.alpaca.pay.permission.dao.PmsOperatorDao;
import cn.ucaner.alpaca.pay.permission.entity.PmsOperator;

/**
* @Package：cn.ucaner.alpaca.pay.permission.dao.impl   
* @ClassName：PmsOperatorDaoImpl   
* @Description：   <p> 权限操作员dao实现</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午9:37:03   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
@Repository
public class PmsOperatorDaoImpl extends PermissionBaseDaoImpl<PmsOperator> implements PmsOperatorDao {

	/**
	 * 根据操作员登录名获取操作员信息.
	 * 
	 * @param loginName
	 *            .
	 * @return operator .
	 */

	public PmsOperator findByLoginName(String loginName) {
		return super.getSqlSession().selectOne(getStatement("findByLoginName"), loginName);
	}

	@Override
	public List<PmsOperator> listByRoleId(Long roleId) {
		return super.getSqlSession().selectList(getStatement("listByRoleId"), roleId);
	}

}
