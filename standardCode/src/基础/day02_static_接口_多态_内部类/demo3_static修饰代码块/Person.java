package 基础.day02_static_接口_多态_内部类.demo3_static修饰代码块;

/**
 * @author 彭智林
 * @date 2019/12/16 9:30
 */
public class Person {
    static {
        System.out.println("Person类中的静态代码块...");
    }

    public Person(){
        System.out.println("Person类 中的构造方法...");
    }
}
