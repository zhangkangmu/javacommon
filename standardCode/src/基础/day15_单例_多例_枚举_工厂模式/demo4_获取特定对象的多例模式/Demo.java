package 基础.day15_单例_多例_枚举_工厂模式.demo4_获取特定对象的多例模式;

/**
 * @author 彭智林
 * @date 2020/1/5 9:44
 */
public class Demo {
    public static void main(String[] args) {
        /*
            获取特定对象的多例模式:
                1.将构造方法私有化,以确保在类的外部不能通过new来创建对象
                2.定义本类类型的成员变量,并创建本类对象,使用public static final修饰
         */
        System.out.println(Person.P1);
        System.out.println(Person.P2);
        System.out.println(Person.P3);
        System.out.println(Person.P1);
        System.out.println(Person.P2);
        System.out.println(Person.P3);
    }
}
