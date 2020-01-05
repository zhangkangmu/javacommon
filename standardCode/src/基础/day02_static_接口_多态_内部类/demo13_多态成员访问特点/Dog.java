package 基础.day02_static_接口_多态_内部类.demo13_多态成员访问特点;

/**
 * @author 彭智林
 * @date 2017/12/16 11:54
 */
public class Dog extends Animal {
    int num = 20;

//    @Override
    public void method(){
        System.out.println("子类中的method方法...");
    }

    public static void show(){
        System.out.println("子类中的show方法...");
    }

}
