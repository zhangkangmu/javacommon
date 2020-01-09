package 基础.day15_单例_多例_枚举_工厂模式.demo4_获取特定对象的多例模式;

/**
 * @author 彭智林
 * @date 2018/1/5 9:46
 */
public class Person {
    // 将构造方法私有化,以确保在类的外部不能通过new来创建对象
    private Person(){

    }

    // 定义本类类型的成员变量,并创建本类对象,使用public static final修饰
    public static final Person P1 = new Person();
    public static final Person P2 = new Person();
    public static final Person P3 = new Person();


}
