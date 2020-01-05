package 基础.day02_static_接口_多态_内部类.demo7_接口的多实现;

/**
 * @author 彭智林
 * @date 2017/12/16 10:40
 */
public interface BInterface {
    // 常量
    int NUM = 20;
    int NUMB = 200;

    // 抽象方法
    void method();
    void methodB();

    // 默认方法
    default void show(){
        System.out.println("B接口中的默认方法show...");

    }

    default void showB(){
        System.out.println("B接口中的默认方法showB...");
    }

}
