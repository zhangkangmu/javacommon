package 基础.day01静态_继承_模板设计模式_抽象类_final.demo17_绘制继承体系对象的内存图;

/**
 * @author 彭智林
 * @date 2019/12/15 14:36
 */
public class Demo1 {
    public static void main(String[] args) {
        /*
            绘制继承体系对象的内存图:
                继承体系内存图原理:
                    1.在初始化子类对象的时候,会优先初始化从父类继承过来的属性
                    2.子类对象空间中,会有一块独立的空间来存储从父类中继承过来的成员(成员变量和成员方法)

         */
        // 创建Zi类对象
        Zi zi = new Zi();

        // 使用Zi类对象调用methodFu();
        zi.methodFu();
        // 使用Zi类对象调用methodZi();
        zi.methodZi();
        // 使用Zi类对象调用method();
        zi.method();
        // 使用Zi类对象调用show();
        zi.show();
    }
}
