package 基础.day02_static_接口_多态_内部类.demo16_多态的好处和弊端;

/**
 * @author 彭智林
 * @date 2019/12/16 14:33
 */
public class Demo {
    public static void main(String[] args) {
        /*
            多态的好处和弊端:
                好处:如果方法的参数类型为父类类型,就可以传入该类的任意子类对象,提高程序的可扩展性
                弊端: 无法访问子类独有的功能
         */
        // 调用method方法,传入Dog类对象
        Dog dog = new Dog();
        method(dog);

        // 调用method方法,传入Cat类对象
        Cat cat = new Cat();
        method(cat);
    }

    // 传入狗类对象: Animal anl = dog; 父类类型指向子类对象
    // 传入猫类对象: Animal anl = cat; 父类类型指向子类对象
    public static void method(Animal anl){
        anl.eat();
        // anl.lookHome(); // 错误的,无法访问子类独有的方法
        // anl.catchMouse();// 错误的,无法访问子类独有的方法
    }

    /*public static void method(Dog dog){
        dog.eat();
    }

    public static void method(Cat cat){
        cat.eat();
    }*/
}
