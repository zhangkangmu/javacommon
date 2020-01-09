package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo15_注解练习;

import org.junit.Test;

/**
 * @author 彭智林
 * @date 2018/1/2 16:07
 */
public class Demo {
    /*
        需求:  自定义@MyTest, 模拟Junit的@Test单元测试.
        分析:
            1.自定义注解
            2.解析注解
     */

    @Test   // 功能: 可以执行main方法一样的执行@Test注解修饰的方法
    public void test1(){
        System.out.println("test1....");
    }

    @MyTest
    public void show1(){
        System.out.println("show1....");
    }

    @MyTest
    public void show2(){
        System.out.println("show2....");
    }
}
