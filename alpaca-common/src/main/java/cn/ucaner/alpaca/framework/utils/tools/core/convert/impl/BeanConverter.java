package cn.ucaner.alpaca.framework.utils.tools.core.convert.impl;

import java.util.Map;

import cn.ucaner.alpaca.framework.utils.tools.core.bean.BeanUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.bean.copier.BeanCopier;
import cn.ucaner.alpaca.framework.utils.tools.core.bean.copier.CopyOptions;
import cn.ucaner.alpaca.framework.utils.tools.core.bean.copier.ValueProvider;
import cn.ucaner.alpaca.framework.utils.tools.core.convert.AbstractConverter;
import cn.ucaner.alpaca.framework.utils.tools.core.util.ReflectUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.convert.impl   
* @ClassName：BeanConverter   
* @Description：   <p> Bean转换器</p>
* <pre>
* Map =》 Bean
* Bean =》 Bean
* ValueProvider =》 Bean
* </pre>
* @Author： -    
* @CreatTime：2018年5月26日 上午10:30:59   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public class BeanConverter<T> extends AbstractConverter<T> {

	private Class<T> beanClass;
	private CopyOptions copyOptions;

	/**
	 * 构造，默认转换选项，注入失败的字段忽略
	 * 
	 * @param beanClass 转换成的目标Bean类
	 */
	public BeanConverter(Class<T> beanClass) {
		this(beanClass, CopyOptions.create().setIgnoreError(true));
		this.beanClass = beanClass;
	}
	
	/**
	 * 构造
	 * 
	 * @param beanClass 转换成的目标Bean类
	 * @param copyOptions Bean转换选项参数
	 */
	public BeanConverter(Class<T> beanClass, CopyOptions copyOptions) {
		this.beanClass = beanClass;
		this.copyOptions = copyOptions;
	}

	@Override
	protected T convertInternal(Object value) {
		if(value instanceof Map || value instanceof ValueProvider || BeanUtil.isBean(value.getClass())) {
			//限定被转换对象类型
			return BeanCopier.create(value, ReflectUtil.newInstanceIfPossible(this.beanClass), copyOptions).copy();
		}
		return null;
	}

	@Override
	public Class<T> getTargetType() {
		return this.beanClass;
	}
}
