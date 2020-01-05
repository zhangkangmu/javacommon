package 基础.day02_static_接口_多态_内部类.demo19_成员内部类;

/**
 * @author 彭智林
 * @date 2017/12/16 15:37
 */
public class Demo {
    public static void main(String[] args) {
        /*
            内部类:将一个类A定义在另一个类B里面，里面的那个类A就称为内部类，B则称为外部类。
            成员内部类的格式:
                public class 外部类名{
                     public class 内部类名{

                    }
                }

            成员内部类的访问特点:
                - 内部类可以直接访问外部类的成员，包括私有成员。
                - 外部类要访问内部类的成员，必须要建立内部类的对象。

            成员内部类的创建方式:
                外部类名.内部类名 对象名 = new 外部类名().new 内部类名();

         */
        // 测试
        // 创建外部类对象,调用外部类的方法methodW2
        Body body = new Body();
        body.methodW2();

        System.out.println("=======================");

        // 创建内部类对象,调用内部类的methodN方法
        Body.Heart heart = new Body().new Heart();
        heart.methodN();

        System.out.println("=======================");
        heart.methodN3();// 300  200  100
    }
}
