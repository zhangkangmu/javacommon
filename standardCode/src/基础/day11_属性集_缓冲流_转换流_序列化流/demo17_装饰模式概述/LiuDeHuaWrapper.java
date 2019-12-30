package 基础.day11_属性集_缓冲流_转换流_序列化流.demo17_装饰模式概述;

/**
 * @author 彭智林
 * @date 2019/12/30 16:03
 */
public class LiuDeHuaWrapper implements Star {// 增强的类
    // 定义被增强类的成员变量
    LiuDeHua liuDeHua;

    public LiuDeHuaWrapper(LiuDeHua liuDeHua) {
        this.liuDeHua = liuDeHua;
    }

    @Override
    public void sing() {
        // 在增强的类中对要增强的方法进行增强
        System.out.println("刘德华在鸟巢的舞台上唱忘情水...");
    }

    @Override
    public void dance() {
        // 在增强的类中不需要增强的方法,调用被增强类中的同名方法
        liuDeHua.dance();
    }
}
