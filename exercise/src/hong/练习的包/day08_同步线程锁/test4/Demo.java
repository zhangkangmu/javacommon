package hong.练习的包.day08_同步线程锁.test4;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhangyuhong
 * Date:2017/12/25
 */
public class Demo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread1 thread1 = new Thread1(countDownLatch);
        Thread2 thread2 = new Thread2(countDownLatch);
        Thread3 thread3 = new Thread3(countDownLatch);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
