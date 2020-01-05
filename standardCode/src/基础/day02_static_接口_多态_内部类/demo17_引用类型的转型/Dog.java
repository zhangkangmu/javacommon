package 基础.day02_static_接口_多态_内部类.demo17_引用类型的转型;

/**
 * @author 彭智林
 * @date 2017/12/16 14:34
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
