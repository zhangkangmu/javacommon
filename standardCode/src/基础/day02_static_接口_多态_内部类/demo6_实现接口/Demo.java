package 基础.day02_static_接口_多态_内部类.demo6_实现接口;

/**
 * @author 彭智林
 * @date 2017/12/16 10:16
 */
public class Demo {
    public static void main(String[] args) {
        /*
            实现的概述:
                1.类与接口的关系是实现关系,也就是类实现接口
                2.实现接口的类叫做接口的实现类,也有人叫做接口的子类
                3.实现接接口需要使用implements关键字

            实现类如果是普通类:
                必须全部实现接口中的抽象方法
                对于接口中的默认方法可以选择性的重写

             实现类如果是抽象类:
                可以不用重写接口中的抽象方法
                对于接口中的默认方法可以选择性的重写

             类实现接口的格式:
                 public class 类名 implements 接口名{

                 }

             总结:
                1.接口中的常量主要是供接口直接访问的,也可以供实现类使用
                2.接口中的抽象方法主要是实现类重写的
                3.接口中的默认方法主要供实现类重写或者直接调用
                4.接口中的静态方法只能供接口直接调用

         */
        // 使用接口名调用接口中的静态方法
        AInterface.method4();

        // 使用接口名直接访问接口中的常量
        System.out.println(AInterface.NUM1);

        // 创建接口的实现类对象,调用默认方法
        AImps aImps = new AImps();
        aImps.method3();
    }
}
