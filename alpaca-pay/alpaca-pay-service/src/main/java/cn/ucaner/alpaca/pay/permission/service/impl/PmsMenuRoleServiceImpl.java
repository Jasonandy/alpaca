package cn.ucaner.alpaca.pay.permission.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;

import cn.ucaner.alpaca.pay.permission.dao.PmsMenuRoleDao;
import cn.ucaner.alpaca.pay.permission.entity.PmsMenuRole;
import cn.ucaner.alpaca.pay.permission.service.PmsMenuRoleService;

/**
* @Package：cn.ucaner.alpaca.pay.permission.service.impl   
* @ClassName：PmsMenuRoleServiceImpl   
* @Description：   <p> 菜单角色service接口实现</p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:16:04   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
@Service("pmsMenuRoleService")
public class PmsMenuRoleServiceImpl implements PmsMenuRoleService {

	@Autowired
	private PmsMenuRoleDao pmsMenuRoleDao;

	/**
	 * 根据角色ID统计关联到此角色的菜单数.
	 * 
	 * @param roleId
	 *            角色ID.
	 * @return count.
	 */
	public int countMenuByRoleId(Long roleId) {
		List<PmsMenuRole> meunList = pmsMenuRoleDao.listByRoleId(roleId);
		if (meunList == null || meunList.isEmpty()) {
			return 0;
		} else {
			return meunList.size();
		}
	}

	/**
	 * 根据角色id，删除该角色关联的所有菜单权限
	 * 
	 * @param roleId
	 */
	public void deleteByRoleId(Long roleId) {
		pmsMenuRoleDao.deleteByRoleId(roleId);
	}

	@Transactional(rollbackFor = Exception.class)
	public void saveRoleMenu(Long roleId, String roleMenuStr){
		// 删除原来的角色与权限关联
		pmsMenuRoleDao.deleteByRoleId(roleId);
		if (!StringUtils.isEmpty(roleMenuStr)) {
			// 创建新的关联
			String[] menuIds = roleMenuStr.split(",");
			for (int i = 0; i < menuIds.length; i++) {
				Long menuId = Long.valueOf(menuIds[i]);
				PmsMenuRole item = new PmsMenuRole();
				item.setMenuId(menuId);
				item.setRoleId(roleId);
				pmsMenuRoleDao.insert(item);
			}
		}
	}
}
