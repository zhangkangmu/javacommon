package 基础.day02_static_接口_多态_内部类.demo2_static修饰成员方法;

/**
 * @author 彭智林
 * @date 2019/12/16 9:07
 */
public class People {

    int age = 10;// 非静态成员变量
    static String country;// 静态成员变量

    /**
     * 静态方法
     */
    public static void method() {
        System.out.println("method方法...");
    }

    public static void method1() {
        int age = 20;
        System.out.println("method1方法..." + age);
        // 下一行代码是错误的,静态方法中不能出现this关键字
        //System.out.println("method1方法..."+this.age);
    }

    public static void method2() {
        // 访问静态方法method3
        method3();
        // 访问非静态方法method4
        // method4();// 错误的,因为静态方法中不能直接访问非静态成员方法
    }

    public static void method3() {
        // 访问静态成员变量
        System.out.println(country);
        // 访问非静态成员变量
        // System.out.println(age);// 错误的,因为静态方法中不能直接访问非静态成员变量
    }

    /**
     * 非静态方法
     */
    public void method4() {
        // 访问静态成员变量
        System.out.println(country);
        // 访问静态成员方法
        method3();

        // 访问非静态成员变量
        System.out.println(age);
        // 访问非静态成员方法
        method5();
    }

    public void method5() {
        System.out.println("method5方法...");
    }

}
