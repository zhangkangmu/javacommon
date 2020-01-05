package 基础.day02_static_接口_多态_内部类.demo6_实现接口;

/**
 * @author 彭智林
 * @date 2017/12/16 10:21
 */
public class AImps implements AInterface {
    @Override
    public void method1() {
        System.out.println("实现类实现接口中的抽象方法method1...");
    }

    @Override
    public void method2() {
        System.out.println("实现类实现接口中的抽象方法method2...");
//        method3();
    }

    @Override
    public void method3() {
        System.out.println("实现类重写接口中的默认方法method3..."+NUM1);
    }
}
