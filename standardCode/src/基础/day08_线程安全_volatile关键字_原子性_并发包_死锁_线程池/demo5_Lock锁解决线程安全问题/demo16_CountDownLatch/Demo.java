package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo16_CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author 彭智林
 * @date 2019/12/25 15:46
 */
public class Demo {
    public static void main(String[] args) {
        /*
            CountDownLatch:
                概述:CountDownLatch允许一个或多个线程等待其他线程完成操作。
                 CountDownLatch是通过一个计数器来实现的，每当一个线程完成了自己的任务后，
                 可以调用countDown()方法让计数器-1，当计数器到达0时，
                 使用CountDownLatch对象await()方法的线程阻塞状态解除，继续执行。
                构造方法:
                    public CountDownLatch(int count)// 初始化一个指定计数器的CountDownLatch对象
                成员方法:
                    public void await();// 让当前线程等待
                    public void countDown()	// 计数器进行减1

               案例:线程1要执行打印：A和C，线程2要执行打印：B，
               但线程1在打印A后，要线程2打印B之后才能打印C，
               所以：线程1在打印A后，必须等待线程2打印完B之后才能继续执行。
               分析:
                 1.线程1打印完A后,需要使用CountDownLatch对象调用await()方法进入阻塞状态(等待)
                 2.线程2打印完B后,需要使用CountDownLatch对象调用countDown()方法,让计算器-1
                 3.线程1和线程2中使用的CountDownLatch对象要一致
                 4.CountDownLatch对象的计数器的值应该指定为1
         */
        // 创建CountDownLatch对象,指定计算器的值为1
        CountDownLatch cd = new CountDownLatch(1);
        // 创建线程1对象,传入CountDownLatch对象
        Thread1 t1 = new Thread1(cd);
        // 创建线程2对象,传入CountDownLatch对象
        Thread2 t2 = new Thread2(cd);
        // 启动线程
        t1.start();
        // 启动线程2
        t2.start();

    }
}
