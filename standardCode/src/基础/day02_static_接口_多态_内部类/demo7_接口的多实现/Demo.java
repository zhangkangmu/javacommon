package 基础.day02_static_接口_多态_内部类.demo7_接口的多实现;

/**
 * @author 彭智林
 * @date 2017/12/16 10:38
 */
public class Demo {
    public static void main(String[] args) {
        /*
            接口的多实现:一个类实现多个接口
                格式:
                    public class 类名 implements 接口名1,接口名2,接口名3,...{

                   }
                多实现接口中成员的使用:
                    常量:推荐直接使用接口名访问
                         如果多个父接口中有同名的常量,那么实现类无法直接使用
                         如果多个父接口中有不同名的常量,那么实现类可以直接使用

                    抽象方法:
                        同名:只需要重写一次
                        不同名:分别重写

                    默认方法:
                        不同名:可以重写,也可以不重写直接实现
                        同名: 必须重写

                    静态方法: 由于静态方法只能供接口之间调用,所以跟实现类无关


         */
        // 创建实现类对象
        ImpClass impClass = new ImpClass();
        // 使用实现类对象访问多个父接口中的同名常量
       //  System.out.println(impClass.NUM);// 编译失败
        // 访问多个父接口中的不同名常量
        System.out.println(impClass.NUMA);
        System.out.println(impClass.NUMB);

        System.out.println("======================");
        // 使用实现类对象调用多个父接口中不同名的默认方法
        impClass.showA();
        impClass.showB();

        // 使用实现类对象调用多个父接口中同名的默认方法
        impClass.show();
    }
}
