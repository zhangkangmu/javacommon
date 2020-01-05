package hong.练习的包.day08_同步线程锁.test2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhangyuhong
 * Date:2017/12/25
 */
public class MyThread extends Thread {
    AtomicInteger num =new AtomicInteger(0);
    public MyThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            num.getAndIncrement();
        }

    }

}
