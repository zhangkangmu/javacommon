package 基础.day07_排序算法_异常_多线程基础.demo15_Thread线程类的API;

/**
 * @author 彭智林
 * @date 2019/12/24 15:38
 */
public class Demo {
    public static void main(String[] args) {
        /*
            Thread线程类的API:
                Thread类:表示java中的线程,线程的主要目的是执行任务(代码)
                构造方法：
                    - public Thread():创建一个默认名称的线程对象
                    - public Thread(String name):创建一个指定名称的线程对象

                    - public Thread(Runnable target):创建一个默认名的线程对象,并指定线程需要执行的任务(代码)
                                                    参数target: 线程需要执行的任务(代码)
                    - public Thread(Runnable target,String name):创建一个指定名称的线程对象,并指定线程需要执行的任务(代码)
                                                    参数target: 线程需要执行的任务(代码)

                    Runnable:接口
                        抽象方法: void run(); 线程需要执行的任务就放在run()方法中

                创建线程的方式总共有两种，一种是继承Thread类方式，一种是实现Runnable接口方式

                常用方法：
                    - public String getName():获取当前线程名称。
                    - public void start():启动线程; Java虚拟机调用此线程的run方法。
                    - public void run():此线程要执行的任务在此处定义代码。
                    - public static void sleep(long millis):使当前正在执行的线程以指定的毫秒数暂停（暂时停止执行）。
                    - public static Thread currentThread():返回对当前正在执行的线程对象的引用。
            注意:
                主线程一定会等所有子线程执行完毕,才会结束线程,终止程序
         */

    }
}
