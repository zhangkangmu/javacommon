package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo13_元注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 彭智林
 * @date 2020/1/2 15:17
 */
@Target(value={ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
public @interface MyAnnotation1 {
}
