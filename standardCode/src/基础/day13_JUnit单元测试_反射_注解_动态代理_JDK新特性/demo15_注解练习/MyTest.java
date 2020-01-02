package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo15_注解练习;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 彭智林
 * @date 2020/1/2 16:08
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTest {
}
