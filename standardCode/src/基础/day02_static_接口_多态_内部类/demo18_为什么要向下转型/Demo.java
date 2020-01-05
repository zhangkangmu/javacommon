package 基础.day02_static_接口_多态_内部类.demo18_为什么要向下转型;

/**
 * @author 彭智林
 * @date 2017/12/16 14:59
 */
public class Demo {
    public static void main(String[] args) {
        /*
            为什么要向上转型: 为了实现多态
            为什么要向下转型: 多态方式调用方法,首先会检查父类中是否有该方法,如果没有,就编译报错
                            也就是说多态的情况下不能访问子类独有的方法,所以,如果在多态的情况下
                            想要调用子类独有的方法,那么就必须向下转型

            如何避免向下转型带来的类型转换异常: 转型之前先判断一下父类类型的变量指向的对象,是否是需要转型的类型
                    if(变量名 instanceof 数据类型){

                    }
                 判断前面的变量名指向的对象的类型是否是后面的数据类型:
                        如果是,就返回true
                        如果不是,就返回false

            总结:
                如果以后需要向下转型,建议先判断,再转型
         */
        // 调用method方法,传入Dog类对象
        Dog dog = new Dog();
        method(dog);

        System.out.println("=================");
        // 调用method方法,传入Cat类对象
        Cat cat = new Cat();
        method(cat);
    }

    public static void method(Animal anl){
        anl.eat();
        // 判断anl指向的对象是否是Dog类型,如果是,就把anl向下转型为Dog类型
        if (anl instanceof Dog) {
            Dog dog = (Dog)anl;
            dog.lookHome();
        }

        // 判断anl指向的对象是否是Cat类型,如果是,把anl向下转型为Cat类型
        if (anl instanceof Cat) {
            Cat cat = (Cat)anl;
            cat.catchMouse();
        }
    }
}
