package 基础.day01静态_继承_模板设计模式_抽象类_final.demo19_抽象方法和抽象类的定义和使用;

/**
 * @author 彭智林
 * @date 2017/12/15 15:17
 */
public class Demo {
    public static void main(String[] args) {
        /*
            抽象方法和抽象类的定义和使用:
                抽象方法定义:
                    修饰符 abstract 返回值类型 方法名(形参列表);

                抽象类定义:
                    修饰符 abstract class 类名{
                        类的成员
                    }

             抽象类的使用:
                1.抽象类不能通过其构造方法创建对象
                2.抽象类中的成员主要是给子类继承滴

             抽象方法的使用: 父类中的抽象方法主要是供子类重写的

         */
        Dog dog = new Dog();
        dog.eat();

    }
}
