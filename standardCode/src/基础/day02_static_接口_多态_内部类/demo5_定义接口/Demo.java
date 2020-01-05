package 基础.day02_static_接口_多态_内部类.demo5_定义接口;

/**
 * @author 彭智林
 * @date 2017/12/16 10:01
 */
public class Demo {
    public static void main(String[] args) {
        /*
            定义接口的格式:
                 public interface 接口名{

                 }

            接口中的成员:
                常量(jdk7及以前): 使用public static final修饰,可以省略
                抽象方法(jdk7及以前):使用public abstract修饰,可以省略
                默认方法(jdk8):使用public default修饰,不可以省略default,可以省略public
                静态方法(jdk8):使用public static修饰,不可以省略省略static,可以省略public
                了解jdk9接口中可以定义私有的静态方法和私有非静态方法
         */
        System.out.println(AInterface.NUM1);
        System.out.println(AInterface.NUM2);

    }
}
