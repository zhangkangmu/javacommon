package 基础.day11_属性集_缓冲流_转换流_序列化流.demo17_装饰模式概述;

/**
 * @author 彭智林
 * @date 2017/12/30 15:55
 */
public class LiuDeHua implements Star {// 被增强的类
    @Override
    public void sing() {
        System.out.println("刘德华正在唱忘情水...");
    }

    @Override
    public void dance() {
        System.out.println("刘德华正在跳舞...");
    }
}
