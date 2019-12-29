package 基础.day02_static_接口_多态_内部类.demo16_多态的好处和弊端;

/**
 * @author 彭智林
 * @date 2019/12/16 14:34
 */
public class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗吃骨头...");
    }

    // 狗独有的功能:看家
    public void lookHome(){
        System.out.println("狗正在看家...");
    }
}
