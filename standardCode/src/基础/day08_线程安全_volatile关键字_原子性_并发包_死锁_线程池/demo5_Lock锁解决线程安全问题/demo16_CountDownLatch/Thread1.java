package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo16_CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author 彭智林
 * @date 2019/12/25 15:52
 */
public class Thread1 extends Thread {

    CountDownLatch cd;

    public Thread1(CountDownLatch cd) {
        this.cd = cd;
    }

    @Override
    public void run() {
        System.out.println("A");
        // 进入阻塞状态
        try {
            cd.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("C");
    }
}
