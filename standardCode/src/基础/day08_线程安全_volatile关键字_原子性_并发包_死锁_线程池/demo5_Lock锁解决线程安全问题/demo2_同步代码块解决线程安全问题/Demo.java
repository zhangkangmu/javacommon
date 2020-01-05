package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo2_同步代码块解决线程安全问题;

/**
 * @author 彭智林
 * @date 2017/12/25 8:50
 */
public class Demo {

    public static void main(String[] args) {
        /*
             同步代码块:
                概述:synchronized关键字可以用于方法中的某个区块中，表示只对这个区块的资源实行互斥访问。
                格式:
                    synchronized(锁对象){

                    }

                锁对象:
                    1.同步代码块的锁对象可以是任意对象
                    2.如果多条线程想要实现同步,那么这多条线程的锁对象要一致
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
