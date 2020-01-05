package 基础.day07_排序算法_异常_多线程基础.demo12_异常经典面试题;

/**
 * @author 彭智林
 * @date 2017/12/24 12:27
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(method1());// 30
        System.out.println(method2());// 20
    }

    public static int method1(){
        int num = 10;
        try {
            System.out.println(1/0);
        } catch (Exception e) {
            num = 20;
            return num;// catch中的return会做3件事:1.记录需要返回的值,2.执行finally中的代码,因为finally中有return,直接返回finally中的值
        } finally {
            num = 30;
            return num;
        }
    }

    public static int method2(){
        int num = 10;
        try {
            System.out.println(1/0);// 出现异常
        } catch (Exception e) {
            num = 20;
            return num; // catch中的return会做3件事:1.记录需要返回的值,2.执行finally中的代码,3.执行完后回到catch中将记录的值返回,结束方法
        } finally {
            num = 30;
        }
        return num;
    }
}
