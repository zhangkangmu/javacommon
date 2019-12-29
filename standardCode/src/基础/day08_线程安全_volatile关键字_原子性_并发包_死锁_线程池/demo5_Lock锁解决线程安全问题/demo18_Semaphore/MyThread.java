package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo18_Semaphore;

/**
 * @author 彭智林
 * @date 2019/12/25 16:27
 */
public class MyThread extends Thread {

    ClassRoom cr;

    public MyThread(ClassRoom cr) {
        this.cr = cr;
    }

    @Override
    public void run() {
        // 调用ClassRoom类中的into方法
        cr.into();
    }
}
