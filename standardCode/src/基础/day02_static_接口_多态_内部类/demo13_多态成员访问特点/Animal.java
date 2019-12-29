package 基础.day02_static_接口_多态_内部类.demo13_多态成员访问特点;

/**
 * @author 彭智林
 * @date 2019/12/16 11:53
 */
public  class Animal {

    int num = 10;

    public void method(){
        System.out.println("父类中的method方法...");
    }


    public static void show(){
        System.out.println("父类中的show方法...");
    }
}
