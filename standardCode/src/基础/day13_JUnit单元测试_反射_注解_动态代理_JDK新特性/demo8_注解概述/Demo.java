package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo8_注解概述;

import org.junit.Test;

/**
 * @author 彭智林
 * @date 2020/1/2 11:52
 */

public class Demo {

    /*
        注解(annotation),是一种代码级别的说明,和类 接口平级关系.
        - 注解（Annotation）相当于一种标记，在程序中加入注解就等于为程序打上某种标记，
                以后，javac编译器、开发工具和其他程序可以通过反射来了解你的类及各种元素上有无标记，看你的程序有什么标记，就去干相应的事，
                标记可以加在包、类，属性、方法，方法的参数以及局部变量上使用

     */

    @Override  // 注解,用来标识toString方法是重写的
    public String toString() {
        return super.toString();
    }

    @Test // 注解,用来表示test1方法是一个单元测试方法,可以直接执行
    public void test1(){

    }
}
