package 基础.day02_static_接口_多态_内部类.demo9_接口的多继承;

/**
 * @author 彭智林
 * @date 2019/12/16 11:00
 */
public interface AInterface {
    // 常量
    int NUM = 10;
    int NUMA = 100;

    // 抽象方法
    void method();
    void methodA();

    // 默认方法
    default void show(){
        System.out.println("A接口中的默认方法show...");
    }

    default void showA(){
        System.out.println("A接口中的默认方法showA...");
    }
}
