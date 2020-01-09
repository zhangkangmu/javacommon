package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo11_使用自定义注解;

/**
 * @author 彭智林
 * @date 2018/1/2 14:49
 */
@MyAnnotation1
public class Demo {

    @MyAnnotation1
    int num1;

    /*
        使用注解:
            1.使用位置: 要使用的主键可以写在哪些位置
              目前自定义的注解可以使用在任意位置
            2.如果注解不带有属性,直接使用注解即可
            3.如果注解一旦有属性了,使用注解的时候,属性必须有值
                格式: @注解名(属性名=属性值,属性名=属性值,...)
     */
    @MyAnnotation1
    public void show(){
        @MyAnnotation1
        int n = 100;// 局部变量
    }

    @MyAnnotation2(num=100,str="itcast",d=3.12)
    public void show2(){
        @MyAnnotation2(num=10,str="itheima",d=3.14)
        int n = 100;
    }

}
