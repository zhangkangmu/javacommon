package 基础.day01静态_继承_模板设计模式_抽象类_final.demo11_方法重写;

/**
 * @author 彭智林
 * @date 2019/12/15 11:24
 */
public class Demo {
    public static void main(String[] args) {
        /*
            方法重写:
                概述:子类中出现与父类一模一样的方法时（返回值类型，方法名和参数列表都相同），
                     会出现覆盖效果，也称为重写或者复写。声明不变，重新实现。
                方法重写使用场景: 当父类方法的功能无法满足子类的需求的时候,子类就需要重写该方法
                子类方法中调用父类的方法: super.父类方法名(实参);
                如何标识子类中重写的方法: 使用@Override注解在方法的声明之上标识
                    重写的方法可以使用@Override注解标识,不是重写的方法就不可以使用@Override注解标识


         */
        // 创建Zi类对象
        Zi zi = new Zi();
        // 使用Zi类对象调用run()方法
        zi.run();
        // 使用Zi类对象调用method()方法
        zi.method();
    }
}
