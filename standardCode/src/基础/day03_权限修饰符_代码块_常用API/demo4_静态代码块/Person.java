package 基础.day03_权限修饰符_代码块_常用API.demo4_静态代码块;

/**
 * @author 彭智林
 * @date 2019/12/18 9:12
 */
public class Person {

    {
        System.out.println("构造代码块...");
    }

    public Person() {
        System.out.println("Person 空参构造方法...");
    }

    static{
        System.out.println("静态代码块...");
    }

}
