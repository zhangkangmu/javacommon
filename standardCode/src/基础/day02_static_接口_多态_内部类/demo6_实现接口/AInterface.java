package 基础.day02_static_接口_多态_内部类.demo6_实现接口;

/**
 * @author 彭智林
 * @date 2019/12/16 10:02
 */
public interface AInterface {

    // 常量(jdk7及以前): 使用public static final修饰,可以省略
    public static final int NUM1 = 100;// 标准格式
    int NUM2 = 200;// 省略格式

    //  抽象方法(jdk7及以前):使用public abstract修饰,可以省略
    public abstract void method1();// 标准格式
    void method2();// 省略格式

    // 默认方法(jdk8):使用public default修饰,不可以省略default,可以省略public
    default void method3(){
        System.out.println("A接口中的默认方法method3...");
    }

    // 静态方法(jdk8):使用public static修饰,不可以省略省略static,可以省略public
    public static void method4(){
        System.out.println("A接口中的静态方法method4...");
    }


}
