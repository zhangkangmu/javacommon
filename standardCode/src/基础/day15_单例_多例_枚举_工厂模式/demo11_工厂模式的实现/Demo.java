package 基础.day15_单例_多例_枚举_工厂模式.demo11_工厂模式的实现;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 彭智林
 * @date 2020/1/5 10:59
 */
public class Demo {
    public static void main(String[] args) {
        /*
            工厂模式的实现: 把创建复杂对象的过程,封装到一个工厂类中
                1. 编写一个Car接口, 提供run方法
                2. 编写一个Falali类实现Car接口,重写run方法
                3. 编写一个Benchi类实现Car接口
                4. 提供一个CarFactory(汽车工厂),用于生产汽车对象
                5. 定义CarFactoryTest测试汽车工厂
             也就是说，当要创建的类可能含有多个参数的时候，为了统一管理这些类，就用了工厂设计模式
         */
        // 前端:
        Falali fll = (Falali) CarFactory.getCar("Falali");
        Benchi bc = (Benchi) CarFactory.getCar("Benchi");
        fll.run();
        bc.run();
    }
}
