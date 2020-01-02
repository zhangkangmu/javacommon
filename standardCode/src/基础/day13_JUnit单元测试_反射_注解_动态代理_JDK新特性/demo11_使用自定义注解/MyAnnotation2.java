package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo11_使用自定义注解;

/**
 * @author 彭智林
 * @date 2020/1/2 14:50
 */
public @interface MyAnnotation2 {// 有属性的主键
    // 属性
    int num();
    String str();
    double d();

}
