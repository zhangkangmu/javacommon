package 基础.day02_static_接口_多态_内部类.demo12_实现多态;

/**
 * @author 彭智林
 * @date 2019/12/16 11:43
 */
public class Demo {
    public static void main(String[] args) {
        /*
            程序中多态: 是指同一方法,对于不同的对象具有不同的实现.
            实现多态的条件:
                1.继承或者实现
                2.父类的引用指向子类对象或者 父接口引用指向实现类对象   重点
                3.方法的重写
            实现多态: 狗,猫对于eat方法表现出不同的实现
            分析:
                Animal类: 父类
                    eat抽象方法
                Dog类: 继承Animal类
                Cat类: 继承Animal类

            结论:
                如果变量的类型是父类类型,那么就可以接收该父类的任意子类对象
                如果参数的类型是父类类型,那么该参数就可以接收该父类类型的一切子类对象

         */
        // 创建Dog类对象,父类类型指向子类对象
        Animal anl = new Dog();
        anl.eat();// 狗吃骨头...

        // 创建Cat类对象,父类类型指向子类对象
        anl = new Cat();
        anl.eat();// 猫吃鱼...

    }

}
