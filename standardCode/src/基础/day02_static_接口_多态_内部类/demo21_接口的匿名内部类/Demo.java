package 基础.day02_static_接口_多态_内部类.demo21_接口的匿名内部类;

/**
 * @author 彭智林
 * @date 2019/12/16 16:12
 */
public class Demo {
    public static void main(String[] args) {
        /*
             匿名内部类:
                本质是一个继承了父类的匿名子类的对象
                本质是一个实现了接口的匿名实现类的对象

              案例: A接口中有一个抽象方法method(),现在需要调用A接口中的method方法
              思路:
                1.创建一个实现类实现A接口
                2.重写A接口中的抽象方法method()
                3.创建实现类对象
                4.使用实现类对象调用method方法

               想要调用A接口中的method方法,按照传统方式,必须有以上4步,一步都不可少
               前面三步就是为了得到A接口的实现类对象

            现在: 匿名内部类可以表示一个接口的匿名实现类对象,所以,可以直接创建接口的匿名内部类来调用method方法即可
         */
        AInterface a = new AInterface(){
            @Override
            public void method() {
                System.out.println("匿名内部类方式重写method方法....");
            }
        };
        a.method();

        System.out.println("==================");

        AInterface a2 = new AImp();
        a2.method();

        System.out.println("======================");
        AInterface a3 = new AInterface() {
            @Override
            public void method() {
                // 实现
            }
        };
    }
}
