package cn.ucaner.alpaca.framework.utils.tools.core.comparator;

import java.io.Serializable;
import java.util.Comparator;

import cn.ucaner.alpaca.framework.utils.tools.core.bean.BeanUtil;
import cn.ucaner.alpaca.framework.utils.tools.core.util.ObjectUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.comparator   
* @ClassName：PropertyComparator   
* @Description：   <p>  Bean属性排序器</p>
* @Author： -    
* @CreatTime：2018年5月25日 下午1:56:37   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class PropertyComparator<T> implements Comparator<T>, Serializable {
	private static final long serialVersionUID = 9157326766723846313L;
	
	private final String property;

	public PropertyComparator(String property) {
		this.property = property;
	}

	@Override
	public int compare(T o1, T o2) {
		if (o1 == o2) {
			return 0;
		} else if (null == o1) {// null 排在后面
			return 1;
		} else if (null == o2) {
			return -1;
		}

		Comparable<?> v1;
		Comparable<?> v2;
		try {
			v1 = (Comparable<?>) BeanUtil.getProperty(o1, property);
			v2 = (Comparable<?>) BeanUtil.getProperty(o1, property);
		} catch (Exception e) {
			throw new ComparatorException(e);
		}

		return compare(o1, o2, v1, v2);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private int compare(T o1, T o2, Comparable fieldValue1, Comparable fieldValue2) {
		int result = ObjectUtil.compare(fieldValue1, fieldValue2);
		if(0 == result && ObjectUtil.notEqual(o1, o2)){
			//避免TreeSet / TreeMap 过滤掉排序字段相同但是对象不相同的情况
			return 1;
		}
		return result;
	}
}
