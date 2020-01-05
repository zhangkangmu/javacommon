package 基础.day03_权限修饰符_代码块_常用API.demo12_Math类;

/**
 * @author 彭智林
 * @date 2017/12/18 14:31
 */
public class Demo {
    public static void main(String[] args) {
        /*
            Math类:
                1.包:java.lang  不需要导包
                2.概述: Math类主要提供一些关于数学运算的静态方法.
                3.成员方法:
                    public static int abs(int a) 获取参数a的绝对值：
                    public static double ceil(double a) 向上取整  例如:3.14 向上取整4.0
                    public static double floor(double a) 向下取整 例如:3.14 向下取整3.0
                    public static double pow(double a, double b)  获取a的b次幂
                    public static long round(double a) 四舍五入取整 例如:3.14 取整3  3.56 取整4
                    public static int max(int a, int b)  返回两个 int 值中较大的一个。
                    public static int min(int a, int b)  返回两个 int 值中较小的一个。
         */
        System.out.println("10的绝对值:"+Math.abs(10));// 10
        System.out.println("-10的绝对值:"+Math.abs(-10));// 10

        System.out.println("3.14向上取整:"+Math.ceil(3.14));// 4.0
        System.out.println("3.54向上取整:"+Math.ceil(3.54));// 4.0
        System.out.println("-3.54向上取整:"+Math.ceil(-3.54));// -3.0

        System.out.println("==================================");
        System.out.println("3.14向下取整:"+Math.floor(3.14));// 3.0
        System.out.println("3.54向下取整:"+Math.floor(3.54));// 3.0
        System.out.println("-3.54向下取整:"+Math.floor(-3.54));// -4.0

        System.out.println("==================================");
        System.out.println("2的3次幂:"+Math.pow(2,3));// 8.0

        System.out.println("==================================");
        System.out.println("3.14四舍五入取整:"+Math.round(3.14));// 3
        System.out.println("3.54四舍五入取整:"+Math.round(3.54));// 4
        System.out.println("-3.54四舍五入取整:"+Math.round(-3.54));// -4


        System.out.println("==================================");
        System.out.println("获取10和20之间的最大值:"+Math.max(10,20));// 20
        System.out.println("获取10和20之间的最小值:"+Math.min(10,20));// 10

    }
}
