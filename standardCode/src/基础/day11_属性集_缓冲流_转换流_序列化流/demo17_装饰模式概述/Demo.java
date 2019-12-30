package 基础.day11_属性集_缓冲流_转换流_序列化流.demo17_装饰模式概述;

/**
 * @author 彭智林
 * @date 2019/12/30 15:48
 */
public class Demo {
    public static void main(String[] args) {
        /*
            装饰模式概述:指的是在不改变原类, 不使用继承的基础上，动态地扩展一个对象的功能。
                   简而言之:就是在不改变原理,不适应继承的基础上,增强类中的方法

            实现装饰者模式的2个条件:
                1.在增强的类中需要获取被增强类的引用
                2.增强的类和被增强的类需要实现相同的接口

            案例:
                准备环境:
                    1. 编写一个Star接口, 提供sing 和 dance抽象方法
                    2. 编写一个LiuDeHua类,实现Star接口,重写抽象方法
            需求:在不改变原类的基础上对LiuDeHua类的sing方法进行扩展
                1.创建一个增强的类,实现Star接口,重写方法
                2.在增强的类中定义被增强类的成员变量,通过构造方法获取被增强类的引用
                3.在增强的类中对要增强的方法进行增强
                4.在增强的类中对不需要增强的方法,调用被增强类中的同名方法
         */
        // 创建LiuDeHua类对象
        LiuDeHua liuDeHua = new LiuDeHua();

        // 创建增强类的对象 LiuDeHuaWrapper
        LiuDeHuaWrapper liuDeHuaWrapper = new LiuDeHuaWrapper(liuDeHua);

        // 调用sing()方法
        liuDeHuaWrapper.sing();
        // 调用dance()方法
        liuDeHuaWrapper.dance();
    }
}
