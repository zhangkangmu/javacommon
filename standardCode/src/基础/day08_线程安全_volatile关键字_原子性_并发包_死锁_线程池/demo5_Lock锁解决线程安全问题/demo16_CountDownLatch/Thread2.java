package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo16_CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author 彭智林
 * @date 2017/12/25 15:52
 */
public class Thread2 extends Thread {

    CountDownLatch cd;

    public Thread2(CountDownLatch cd) {
        this.cd = cd;
    }

    @Override
    public void run() {

        System.out.println("B");
        // 让计算器-1
        cd.countDown();
    }
}
