package 基础.day15_单例_多例_枚举_工厂模式.demo2_单例设计模式懒汉式;

/**
 * @author 彭智林
 * @date 2018/1/5 9:09
 */
public class Person {// 懒汉式
    // 将构造方法私有化,以确保在类的外部不能通过new来创建对象
    private Person(){

    }

    // 定义一个本类的成员变量,不需要创建本类对象,使用private static修饰
    private static Person p;

    // 提供一个公共静态方法,供外界获取本类的唯一对象
    public static synchronized Person getInstance(){
        if (p == null) {// 线程1通过判断  线程2通过判断
            p = new Person();
        }
        return p;
    }

}
