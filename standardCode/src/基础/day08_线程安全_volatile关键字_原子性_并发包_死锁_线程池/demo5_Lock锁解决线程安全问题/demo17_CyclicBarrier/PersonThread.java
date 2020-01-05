package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo17_CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @author 彭智林
 * @date 2017/12/25 16:05
 */
public class PersonThread extends Thread {

    CyclicBarrier cb;

    public PersonThread(CyclicBarrier cb) {
        this.cb = cb;
    }

    @Override
    public void run() {
        System.out.println(getName()+":到了会议室");// 屏障
        // 告诉CyclicBarrier我已经到达了屏障
        try {
            cb.await();
            System.out.println(getName()+":会议室结束");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
