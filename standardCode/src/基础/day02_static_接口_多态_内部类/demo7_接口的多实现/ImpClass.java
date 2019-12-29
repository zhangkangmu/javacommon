package 基础.day02_static_接口_多态_内部类.demo7_接口的多实现;

/**
 * @author 彭智林
 * @date 2019/12/16 10:40
 */
public class ImpClass implements AInterface, BInterface {

    @Override
    public void show() {
        //  直接访问多个父接口中的同名常量
        // System.out.println(NUM);// 编译失败
        System.out.println(AInterface.NUM);
        System.out.println(BInterface.NUM);
        // 直接访问多个父接口中的不同名常量
        System.out.println(NUMA);
        System.out.println(NUMB);
    }

    @Override
    public void method() {

    }

    @Override
    public void methodB() {

    }

    @Override
    public void methodA() {

    }
}
