package cn.ucaner.alpaca.framework.utils.tools.core.bean.copier.provider;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;

import cn.ucaner.alpaca.framework.utils.tools.core.bean.BeanDesc.PropDesc;
import cn.ucaner.alpaca.framework.utils.tools.core.bean.BeanUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.bean.copier.ValueProvider;
import cn.ucaner.alpaca.framework.utils.tools.core.exceptions.UtilException;
import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.bean.copier.provider   
* @ClassName：BeanValueProvider   
* @Description：   <p> Bean的值提供者 </p>
* @Author： -    
* @CreatTime：2018年5月26日 上午10:07:13   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class BeanValueProvider implements ValueProvider<String> {

	private Object source;
	private boolean ignoreError;
	final Map<String, PropDesc> sourcePdMap;

	/**
	 * 构造
	 * 
	 * @param bean Bean
	 * @param ignoreCase 是否忽略字段大小写
	 * @param ignoreError 是否忽略字段值读取错误
	 */
	public BeanValueProvider(Object bean, boolean ignoreCase, boolean ignoreError) {
		this.source = bean;
		this.ignoreError = ignoreError;
		sourcePdMap = BeanUtil.getBeanDesc(source.getClass()).getPropMap(ignoreCase);
	}

	@Override
	public Object value(String key, Type valueType) {
		PropDesc sourcePd = sourcePdMap.get(key);
		if(null == sourcePd && (Boolean.class == valueType || boolean.class == valueType)) {
			//boolean类型字段字段名支持两种方式
			sourcePd = sourcePdMap.get(StrUtil.upperFirstAndAddPre(key, "is"));
		}
		
		if (null != sourcePd) {
			final Method getter = sourcePd.getGetter();
			if (null != getter) {
				try {
					return getter.invoke(source);
				} catch (Exception e) {
					if (false == ignoreError) {
						throw new UtilException(e, "Inject [{}] error!", key);
					}
				}
			}
		}
		return null;
	}

	@Override
	public boolean containsKey(String key) {
		return sourcePdMap.containsKey(key) || sourcePdMap.containsKey(StrUtil.upperFirstAndAddPre(key, "is"));
	}

}
