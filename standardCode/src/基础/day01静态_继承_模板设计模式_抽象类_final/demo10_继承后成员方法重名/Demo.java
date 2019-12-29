package 基础.day01静态_继承_模板设计模式_抽象类_final.demo10_继承后成员方法重名;

/**
 * @author 彭智林
 * @date 2019/12/15 11:17
 */
public class Demo {
    public static void main(String[] args) {
        /*
            继承后成员方法重名的访问规则: 优先访问子类自己的方法
         */
        // 创建Zi类对象
        Zi zi = new Zi();
        // 使用Zi类对象调用method()方法
        zi.method();// Zi 类中的method方法执行了....

    }
}
