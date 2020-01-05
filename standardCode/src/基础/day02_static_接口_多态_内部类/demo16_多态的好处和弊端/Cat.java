package 基础.day02_static_接口_多态_内部类.demo16_多态的好处和弊端;

/**
 * @author 彭智林
 * @date 2017/12/16 14:36
 */
public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼...");
    }

    // 猫独有的功能: 抓老鼠
    public void catchMouse(){
        System.out.println("猫抓老鼠...");
    }
}
