package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo10_volatile原子性测试;

/**
 * @author 彭智林
 * @date 2019/12/25 11:49
 */
public class MyThread extends Thread {

    volatile int a = 0;// 共享变量

    @Override
    public void run() {
        // a变量自增3万次
        for (int i = 0; i < 100000; i++) {
            a++;
        }
        System.out.println("子线程 操作完毕...");
    }
}
