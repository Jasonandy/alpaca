package cn.ucaner.alpaca.common.annotation;

import java.lang.annotation.*;

/**
* @Package：cn.ucaner.alpaca.common.annotation   
* @ClassName：BaseService   
* @Description：   <p> 初始化继承BaseService的service</p>
* @Author： -    
* @CreatTime：2018年5月24日 下午2:22:09   
* @Modify By：   
* @ModifyTime：  2018年5月24日
* @Modify marker：   
* @version    V1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BaseService {
}
