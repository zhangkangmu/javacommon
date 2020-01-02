package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo10_自定义注解;

/**
 * @author 彭智林
 * @date 2020/1/2 12:30
 */
public @interface MyAnnotation2 {// 含有属性的注解
    // 定义属性
    int a1();

    // String 类型
    String a2();

    // Class 类型
    Class a3();

    // 枚举类型
    Gender a4();

    // 注解类型
    MyAnnotation1 a5();

    // 以上类型的一维数组类型
    int[] a6();
    String[] a7();
    Class[] a8();
    Gender[] a9();
    MyAnnotation1[] a10();

}
