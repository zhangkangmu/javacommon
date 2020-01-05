package 基础.day02_static_接口_多态_内部类.demo3_static修饰代码块;

/**
 * @author 彭智林
 * @date 2017/12/16 9:18
 */
public class Demo {

    static{
        for (int i = 0; i < 3; i++) {
            System.out.println("静态代码块执行了...");
        }
    }


    public static void main(String[] args) {
        /*
            static修饰代码块:
                格式:
                    static{

                    }
               概述: 被static修饰的代码块叫做静态代码块

               静态代码块的位置: 类中方法外

               静态代码块执行:
                   静态代码块是随着类的加载而执行,并且只会执行一次,优先于构造方法和main方法
         */
        System.out.println("main方法...");
        Person p1 = new Person();
        Person p2 = new Person();

    }


}
