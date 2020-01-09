package 基础.day15_单例_多例_枚举_工厂模式.demo3_获取通用对象的多例模式;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author 彭智林
 * @date 2018/1/5 9:26
 */
public class Person {
    // 将构造方法私有化,以确保在类的外部不能通过new来创建对象
    private Person() {

    }

    // 定义一个单列集合成员变量,并创建该集合对象,使用private static final
    private static final ArrayList<Person> LIST = new ArrayList<>();

    // 定义一个int类型的成员变量,用来表示该类可以创建多少个对象
    private static final int COUNT = 3;

    // 在静态代码块中,创建固定个数该类的对象,并添加到集合中
    static {
        for (int i = 0; i < COUNT; i++) {
            Person p = new Person();
            LIST.add(p);
        }
    }

    // 提供公共的静态方法,供外界随机获取一个该类的对象
    public static Person getInstance(){
        Random r = new Random();
        int index = r.nextInt(COUNT);// [0,index)
        return LIST.get(index);
    }

}
