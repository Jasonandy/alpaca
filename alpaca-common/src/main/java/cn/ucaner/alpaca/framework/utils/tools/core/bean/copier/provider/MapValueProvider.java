package cn.ucaner.alpaca.framework.utils.tools.core.bean.copier.provider;

import java.lang.reflect.Type;
import java.util.Map;

import cn.ucaner.alpaca.framework.utils.tools.core.bean.copier.ValueProvider;
import cn.ucaner.alpaca.framework.utils.tools.core.map.CaseInsensitiveMap;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.bean.copier.provider   
* @ClassName：MapValueProvider   
* @Description：   <p> Map值提供者 </p>
* @Author： -    
* @CreatTime：2018年5月26日 上午10:07:32   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class MapValueProvider implements ValueProvider<String> {

	private Map<?, ?> map;

	/**
	 * 构造
	 * 
	 * @param map Map
	 * @param ignoreCase 是否忽略key的大小写
	 */
	public MapValueProvider(Map<?, ?> map, boolean ignoreCase) {
		if(false == ignoreCase || map instanceof CaseInsensitiveMap) {
			//不忽略大小写或者提供的Map本身为CaseInsensitiveMap则无需转换
			this.map = map;
		}else {
			//转换为大小写不敏感的Map
			this.map = new CaseInsensitiveMap<>(map);
		}
	}

	@Override
	public Object value(String key, Type valueType) {
		return map.get(key);
	}

	@Override
	public boolean containsKey(String key) {
		return map.containsKey(key);
	}

}
