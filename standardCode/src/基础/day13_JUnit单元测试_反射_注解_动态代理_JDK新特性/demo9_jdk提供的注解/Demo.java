package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo9_jdk提供的注解;

import org.junit.Test;

import java.util.Date;

/**
 * @author 彭智林
 * @date 2020/1/2 12:14
 */
@Deprecated
@SuppressWarnings("all")
public class Demo {
    @Deprecated
    int num;

    /*
        jdk提供的注解:
                @Override:描述方法的重写.
                          功能:判断使用@Override注解的方法是否是一个重写的方法
                          使用位置:只能放在方法声明之上

                @Deprecated:标记过时
                            功能:标记过时
                            使用位置: 构造方法,成员方法,局部变量,成员变量,参数,包,类,接口

                @SuppressWarnings:压制警告.忽略警告
                            功能:忽略警告
                            使用位置:构造方法,成员方法,局部变量,成员变量,参数,类\接口
     */
    @Test
    public void test1(){

//        @SuppressWarnings("all")
        int num1 = 10;

    }


    @Test
//    @SuppressWarnings("All")
    public void show(){

        Date date = new Date();
        String str = date.toLocaleString();// 过时
        method1();// 过时
        System.out.println(num);// 成员变量

    }

    // 定义一个方法,并且标识它过时
    @Deprecated
    public void method1(){

    }


    @Override
    public String toString() {
        return super.toString();
    }
}
