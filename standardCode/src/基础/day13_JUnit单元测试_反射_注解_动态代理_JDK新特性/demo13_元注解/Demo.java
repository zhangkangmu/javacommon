package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo13_元注解;

import org.junit.Test;

/**
 * @author 彭智林
 * @date 2018/1/2 15:14
 */
@MyAnnotation1
public class Demo {

    /*
        元注解:
            概述:定义在注解上的注解
            作用:用来修饰注解的
            分类:
                @Target:定义该注解作用在什么上面(位置),默认注解可以在任何位置.
                       @Target注解中属性的值为:ElementType枚举类型的枚举值
                       ElementType枚举类型的枚举值:
                            TYPE                类\接口
                            FIELD               属性\成员变量
                            METHOD              方法
                            PARAMETER           参数
                            CONSTRUCTOR         构造方法
                            LOCAL_VARIABLE      局部变量
                            ....
                      枚举值的访问方式: 枚举类型.枚举值
                @Retention:定义该注解保留到那个代码阶段,
                    @Retention注解中属性的值为: RetentionPolicy枚举类型
                        RetentionPolicy枚举类型的枚举值:
                            SOURCE:只在源码上保留(默认),编译后就没有了。
                            CLASS:在源码和字节码上保留,但运行时不会被加载到内存。
                            RUNTIME:注解会出现在“源码”、“class文件”、“运行时内存”。
     */
    @MyAnnotation1
    int num;

    @MyAnnotation1
    public void show() {
        @MyAnnotation1
        int n = 100;
    }



    @Override
    public String toString() {
        return super.toString();
    }

    @Test
    public void test1() {

    }
}
