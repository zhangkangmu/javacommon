package 基础.day02_static_接口_多态_内部类.demo20_抽象类的匿名内部类;

/**
 * @author 彭智林
 * @date 2017/12/16 15:56
 */
public class Demo {
    public static void main(String[] args) {
        /*
            匿名内部类:
                本质是一个继承了父类的匿名子类的对象
                本质是一个实现了接口的匿名实现类的对象

            匿名: 没有名字

            案例:Animal类是抽象类,这个抽象类中有一个抽象方法eat(),需要调用eat方法来执行
            思路:
                 1.创建一个子类继承Animal类
                 2.在子类中重写eat方法
                 3.在测试类中创建子类对象
                 4.在测试类中使用子类对象调用eat方法

                 想要调用抽象类Animal类的eat方法,总共需要4步,一步都不能少
                 这里的前3步就是为了得到Animal类的子类对象,而匿名内部类可以一步到位
            匿名内部类的格式:
                new 抽象类名\接口名(){
                    实现抽象方法
                };
         */
        // 在测试类中创建子类对象
        Dog dog = new Dog();
        // 在测试类中使用子类对象调用eat方法
        dog.eat();// Dog类的有名字的对象调用eat()方法

        System.out.println("=========================");
        new Dog().eat();//     Dog类             的匿名对象调用eat()方法
                        // 继承了Animal类的子类   的匿名对象调用eat()方法

        // 以上方式都得创建Animal类的子类 然后再创建子类对象 调用eat方法

        System.out.println("==============================================");
        // 思考:是否可以不创建Animal类的子类,而是直接创建Animal类的子类对象
        // 解决:匿名内部类:就是一个继承了父类的匿名子类的对象
        // 创建Animal类的匿名内部类 其实就是创建Animal类的匿名子类对象
        new Animal(){
            @Override
            public void eat() {
                System.out.println("匿名内部类中的eat方法...");
            }
        }.eat();// Animal类的子类对象

       // int[] arr = new int[]{10,34,56};
       // int[] arr2 = {10,34,56};// 语法糖


    }
}
