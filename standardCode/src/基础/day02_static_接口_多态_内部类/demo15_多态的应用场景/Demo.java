package 基础.day02_static_接口_多态_内部类.demo15_多态的应用场景;

/**
 * @author 彭智林
 * @date 2017/12/16 12:11
 */
public class Demo {
    public static void main(String[] args) {
        /*
            多态的应用场景:
                变量多态
                    变量的类型为父类类型,那么就可以接收该父类的任意子类对象
                    变量的类型为父接口类型,那么就可以接收该父接口的任意实现类对象
                形参多态---->使用的非常多
                    形参类型为父类类型,那么就可以接收该父类的任意子类对象
                    形参类型为父接口类型,那么就可以接收该父接口的任意实现类对象
                返回值多态---->使用的非常多
                    返回值类型为父类类型,那么就可以返回该父类的任意子类对象
                    返回值类型为父接口类型,那么就可以返回该父接口的任意实现类对象
         */
        // 变量多态
        Animal anl = new Dog();
        anl = new Cat();

        // 调用method方法,传入Dog类对象
        Dog dog = new Dog();
        method(dog);

        // 调用method方法,传入Cat类对象
        Cat cat = new Cat();
        method(cat);

    }

    // 返回值多态
    public static Animal show(){
//        return new Dog();
        return new Cat();
    }


    // 形参多态
    public static void method(Animal anl){
        anl.eat();
    }


    public static void method(Dog dog){
        dog.eat();
    }

    public static void method(Cat cat){
        cat.eat();
    }
}
