package 基础.day15_单例_多例_枚举_工厂模式.demo11_工厂模式的实现;

/**
 * @author 彭智林
 * @date 2018/1/5 11:00
 */
public class Falali implements Car {

    private int speed;

    public Falali(int speed) {
        this.speed = speed;
    }

    @Override
    public void run() {
        System.out.println("法拉利正在以每小时5000公里的速度在奔跑...");
    }
}
