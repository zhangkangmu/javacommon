package 基础.day02_static_接口_多态_内部类.demo13_多态成员访问特点;

/**
 * @author 彭智林
 * @date 2017/12/16 11:53
 */
public class Demo {
    public static void main(String[] args) {
        /*
            多态成员访问特点:
                成员变量:编译看左边,运行看左边
                    编译的时候就是去父类中查找,运行的时候就去父类中查找

                成员方法:
                    非静态方法:编译看左边,运行看右边
                    静态方法: 编译看左边,运行看左边

                结论:
                    只有非静态方法是编译看左边,运行看右边,其他的都是看左边

            注意:"
                父子类中出现一模一样的静态方法不是方法重写,只是长得像方法重写
         */
        // 父类的引用指向子类对象
        Animal anl = new Dog();
        System.out.println("访问num变量:"+anl.num);// 10

        anl.method();// 子类中的method方法...

        anl.show();// 父类中的show方法...

    }
}
