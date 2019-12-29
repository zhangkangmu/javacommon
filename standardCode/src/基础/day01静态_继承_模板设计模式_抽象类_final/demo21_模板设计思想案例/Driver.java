package 基础.day01静态_继承_模板设计模式_抽象类_final.demo21_模板设计思想案例;

/**
 * @author 彭智林
 * @date 2019/12/15 16:10
 */
public abstract class Driver {
    /**
     * 开车
     */
    public void driveCar(){
        System.out.println("开门...");
        System.out.println("点火...");
        // 姿势  不能确定 根据模板设计思想,不能确定的就定义成抽象方法,让子类重写
        ziShi();
        System.out.println("刹车...");
        System.out.println("熄火...");
    }

    /**
     * 姿势
     */
    public abstract void ziShi();

}
