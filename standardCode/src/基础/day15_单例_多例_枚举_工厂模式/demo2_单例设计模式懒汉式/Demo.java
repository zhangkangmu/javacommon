package 基础.day15_单例_多例_枚举_工厂模式.demo2_单例设计模式懒汉式;

/**
 * @author 彭智林
 * @date 2020/1/5 9:06
 */
public class Demo {
    public static void main(String[] args) {
        /*
            单例设计模式 --- 懒汉式:
                1.将构造方法私有化,以确保在类的外部不能通过new来创建对象
                2.定义一个本类的成员变量,不需要创建本类对象,使用private static修饰
                3.提供一个公共静态方法,供外界获取本类的唯一对象
                    3.1 如果本类的成员变量为null,那么就直接创建本类对象
                    3.2 如果本类的成员变量不为null,那么就直接返回该成员变量
            饿汉式: 在使用之前就把该类的对象new出来,仅new一次
            懒汉式: 在第一次使用的时候把该类的对象new出来,仅new一次,
         */
        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance());
    }
}
