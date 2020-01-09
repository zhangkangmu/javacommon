package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo19_方法引用的分类;

import java.util.function.Supplier;

/**
 * @author 彭智林
 * @date 2018/1/2 17:37
 */
public class Car {
    public static Car create(Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void method1(  Car car ) {
        System.out.println( "method1 " + car.toString() );
    }

    public void method2() {
        System.out.println( "method2 " + this.toString() );
    }

    public void method3(  Car another ) {
        System.out.println( "method3 the " + another.toString() );
    }
}
