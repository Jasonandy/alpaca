package cn.ucaner.alpaca.framework.utils.tools.core.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedElement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cn.ucaner.alpaca.framework.utils.tools.core.collection.CollUtil;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.annotation   
* @ClassName：CombinationAnnotationElement   
* @Description：   <p> 组合注解 对JDK的原生注解机制做一个增强，支持类似Spring的组合注解。</p>
* 核心实现使用了递归获取指定元素上的注解以及注解的注解，以实现复合注解的获取。
* @Author： -    
* @CreatTime：2018年5月27日 下午3:06:35   
* @Modify By：   
* @ModifyTime：  2018年5月27日
* @Modify marker：   
* @version    V1.0
 */
public class CombinationAnnotationElement implements AnnotatedElement {

	/** 元注解 */
	private static final Set<Class<? extends Annotation>> META_ANNOTATIONS = CollUtil.newHashSet(
			Target.class, //Target通过ElementType来指定注解可使用范围的枚举集合 METHOD TYPE ANNOTATION_TYPE PACKAGE PARAMETER etc.
			Retention.class, //Reteniton的作用是定义被它所注解的注解保留多久，一共有三种策略，定义在RetentionPolicy枚举中 SOURCE,CLASS,RUNTIME
			Inherited.class, //@Inherited阐述了某个被标注的类型是被继承的
			Documented.class, //Documented 注解表明这个注解应该被 javadoc工具记录. 默认情况下,javadoc是不包括注解的
			SuppressWarnings.class, //SuppressWarnings用于抑制编译器产生警告信息。
			Override.class, //@Override是伪代码,表示重写(当然不写也可以)
			Deprecated.class//Deprecated这个方法或类不再建议使用
	);

	/** 注解类型与注解对象对应表 */
	private Map<Class<? extends Annotation>, Annotation> annotationMap;
	
	/** 直接注解类型与注解对象对应表 */
	private Map<Class<? extends Annotation>, Annotation> declaredAnnotationMap;

	/**
	 * 构造
	 * 
	 * @param element 需要解析注解的元素：可以是Class、Method、Field、Constructor、ReflectPermission
	 */
	public CombinationAnnotationElement(AnnotatedElement element) {
		init(element);
	}

	@Override
	public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
		return annotationMap.containsKey(annotationClass);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
		Annotation annotation = annotationMap.get(annotationClass);
		return (annotation == null) ? null : (T) annotation;
	}

	@Override
	public Annotation[] getAnnotations() {
		final Collection<Annotation> annotations = this.annotationMap.values();
		return annotations.toArray(new Annotation[annotations.size()]);
	}

	@Override
	public Annotation[] getDeclaredAnnotations() {
		final Collection<Annotation> annotations = this.declaredAnnotationMap.values();
		return annotations.toArray(new Annotation[annotations.size()]);
	}
	
	/**
	 * 初始化
	 * @param element 元素
	 */
	private void init(AnnotatedElement element) {
		Annotation[] declaredAnnotations = element.getDeclaredAnnotations();
		this.declaredAnnotationMap = new HashMap<>();
		parseDeclared(declaredAnnotations);
		
		Annotation[] annotations = element.getAnnotations();
		if(declaredAnnotations == annotations) {
			this.annotationMap = this.declaredAnnotationMap;
		}else {
			this.annotationMap = new HashMap<>();
			parse(annotations);
		}
	}

	/**
	 * 进行递归解析注解，直到全部都是元注解为止
	 * @param annotations Class, Method, Field等
	 */
	private void parseDeclared(Annotation[] annotations) {
		Class<? extends Annotation> annotationType;
		// 直接注解
		for (Annotation annotation : annotations) {
			annotationType = annotation.annotationType();
			if (false == META_ANNOTATIONS.contains(annotationType)) {
				declaredAnnotationMap.put(annotationType, annotation);
				parseDeclared(annotationType.getDeclaredAnnotations());
			}
		}
	}
	
	/**
	 * 进行递归解析注解，直到全部都是元注解为止
	 * @param element Class, Method, Field等
	 */
	private void parse(Annotation[] annotations) {
		Class<? extends Annotation> annotationType;
		for (Annotation annotation : annotations) {
			annotationType = annotation.annotationType();
			if (false == META_ANNOTATIONS.contains(annotationType)) {
				annotationMap.put(annotationType, annotation);
				parse(annotationType.getAnnotations());
			}
		}
	}
}