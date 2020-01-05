package 基础.day09_线程状态_等待与唤醒_Lambda表达式_Stream流.demo2_实现线程的等待唤醒;

/**
 * @author 彭智林
 * @date 2017/12/27 9:42
 */
public class Demo {

    static Object lock = new Object();// 锁对象

    public static void main(String[] args) {
        /*
            等待唤醒:Object类的方法
                void wait() 需要使用锁对象调用,调用之后线程就会进入无限等待
                void notify() 需要使用锁对象调用,唤醒单个等待线程
                             唤醒的是该锁对象调用wait()方法进入无限等待或者计时等待的单个线程
                 void notifyAll() 需要使用锁对象调用,唤醒所有等待线程
                             唤醒的是该锁对象调用wait()方法进入无限等待或者计时等待的所有线程
           特点:
            1.wait()方法和notify(),notifyAll()方法都需要使用锁对象调用
            2.调用wait()方法和notify(),notifyAll()方法的锁对象要一致
            3.线程一定进入无限等待,就不会争夺锁,也不会抢占系统资源(释放锁,不抢cpu)
            4.在同步代码块或者同步方法中调用sleep()方法让线程进入计时等待,是不会释放锁
                例如:synchronized(锁对象){
                    Thread.sleep(); 不会释放锁
                    锁对象.wait();释放锁,不会抢cpu
                }
            5.一个无限等待线程被唤醒了,并获得锁对象,就会从进入无限等待的位置继续往下执行

         */
        // 创建等待线程:
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        System.out.println("等待线程:我准备进入无限等待");
                        // 锁对象.wait();
                        try {
                            lock.wait();// 无限等待,释放锁,不抢cpu
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("等待线程:我被唤醒了,获得锁对象,继续执行...=======================================");
                    }
                }
            }
        }, "等待线程").start();


        // 创建唤醒线程:
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(300);// 为了让等待线程先执行
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock) {
                        System.out.println("唤醒线程:准备唤醒等待线程");
                        // 锁对象.notify();
                        lock.notify();
                    }
                }
            }
        }, "唤醒线程").start();

    }
}
