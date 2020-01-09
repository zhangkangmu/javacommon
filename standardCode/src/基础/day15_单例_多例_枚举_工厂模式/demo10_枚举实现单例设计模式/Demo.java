package 基础.day15_单例_多例_枚举_工厂模式.demo10_枚举实现单例设计模式;

/**
 * @author 彭智林
 * @date 2018/1/5 10:33
 */
public class Demo {
    public static void main(String[] args) {
        Singleton inst = Singleton.INSTANCE;
        inst.method();
    }
}
