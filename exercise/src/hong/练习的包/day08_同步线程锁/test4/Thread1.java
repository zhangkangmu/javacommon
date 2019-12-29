package hong.练习的包.day08_同步线程锁.test4;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhangyuhong
 * Date:2019/12/25
 */
public class Thread1 extends Thread {
    private CountDownLatch cd;

    public Thread1(CountDownLatch countDownLatch) {
        this.cd = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Thread1-A");
        try {
            cd.await();
            System.out.println("Thread1-B");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
