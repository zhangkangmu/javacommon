package 基础.day02_static_接口_多态_内部类.demo8_接口中优先级的问题;

/**
 * @author 彭智林
 * @date 2017/12/16 10:54
 */
public class Demo {
    public static void main(String[] args) {
        /*
            接口中优先级的问题:
                如果一个类既继承一个父类,又实现了一个父接口,但是父类和父接口中有同名的默认方法,优先访问的是父类的
            实现类既继承父类,又实现接口的格式:
                public class 类名 extends 父类名 implements 接口名1,接口名2,...{

                }
         */
        // 创建Zi类对象
        Zi zi = new Zi();
        //使用Zi类对象调用method方法
        zi.method();
    }
}
