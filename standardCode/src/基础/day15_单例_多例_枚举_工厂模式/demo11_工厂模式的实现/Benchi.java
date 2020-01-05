package 基础.day15_单例_多例_枚举_工厂模式.demo11_工厂模式的实现;

/**
 * @author 彭智林
 * @date 2020/1/5 11:02
 */
public class Benchi implements Car {

    private int speed;

    public Benchi(int speed) {
        this.speed = speed;
    }

    @Override
    public void run() {
        System.out.println("奔驰正在以每秒100公里的速度在奔跑...");
    }
}
