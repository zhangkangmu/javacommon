package 基础.day01静态_继承_模板设计模式_抽象类_final.demo1_面向对象复习;

/**
 * @author 彭智林
 * @date 2017/12/15 9:13
 */
public class Demo1 {
    public static void main(String[] args) {
        /*
            定义一个类:
                修饰符  class  类名{
                    成员变量
                    成员方法
                    构造方法

                    内部类
                    代码块
                }
         */
        // 创建Person类的对象
        Person p1 = new Person();
        Person p2 = new Person("张三丰");
        Person p3 = new Person("张无忌", 18);
        Person p4 = new Person("张无忌", 18);

        p2.show();
        p3.show();

        

    }

}
