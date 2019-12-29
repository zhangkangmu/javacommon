package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo5_Lock锁解决线程安全问题.Demo;

/**
 * @author 彭智林
 * @date 2019/12/25 8:50
 */
public class Demo {
    public static void main(String[] args) {
        /*
            Lock锁:
                概述:java.util.concurrent.locks.Lock机制提供了比synchronized代码块和synchronized方法更广泛的锁定操作,
                    同步代码块/同步方法具有的功能Lock都有,除此之外更强大
            Lock锁也称同步锁，加锁与释放锁方法化了，如下：
                    - public void lock():加同步锁。
                    - public void unlock():释放同步锁。
            由于Lock锁进行加锁和释放锁是调用方法,所以需要创建Lock锁对象,而Lock是一个接口,所以
            只能创建其实现类对象来调用方法加锁和释放锁
            Lock锁的实现类: ReentrantLock
                ReentrantLock类:
                    public ReentrantLock();
         */

        // 创建实现类对象
        MyRunnable mr = new MyRunnable();

        // 创建Thread线程对象,传入实现类对象,使用线程对象调用start()方法,启动线程,执行任务
        new Thread(mr,"窗口1").start();
        new Thread(mr,"窗口2").start();
        new Thread(mr,"窗口3").start();
        new Thread(mr,"窗口4").start();
    }
}
