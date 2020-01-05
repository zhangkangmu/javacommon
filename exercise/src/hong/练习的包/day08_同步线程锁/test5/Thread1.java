package hong.练习的包.day08_同步线程锁.test5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by zhangyuhong
 * Date:2017/12/25
 */
public class Thread1 extends Thread {


    private  CyclicBarrier cb;

    public Thread1(CyclicBarrier cyclicBarrier) {
        this.cb=cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("Thread1到达");
        try {
            cb.await();
            System.out.println("thread1走了");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
