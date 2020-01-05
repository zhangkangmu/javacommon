package 基础.day01静态_继承_模板设计模式_抽象类_final.demo21_模板设计思想案例;

/**
 * @author 彭智林
 * @date 2017/12/15 16:10
 */
public class Demo {
    public static void main(String[] args) {

        // 创建老司机对象
        OldDriver oldDriver = new OldDriver();
        // 让老司机对象调用开车的方法
        oldDriver.driveCar();

        System.out.println("======================================");

        // 创建新司机对象
        NewDriver newDriver = new NewDriver();
        // 让新司机对象调用开车的方法
        newDriver.driveCar();
    }
}
