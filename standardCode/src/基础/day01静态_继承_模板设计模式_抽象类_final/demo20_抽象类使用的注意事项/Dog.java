package 基础.day01静态_继承_模板设计模式_抽象类_final.demo20_抽象类使用的注意事项;

/**
 * @author 彭智林
 * @date 2017/12/15 15:39
 */
public class Dog extends Animal {

    // 定义一个构造方法,可以初始化从父类继承过来的name和age
    public Dog(String name,int age){
        super(name,age);
    }


    public Dog(){

    }


    @Override
    public void eat() {
        System.out.println("狗吃骨头...");
    }
}
