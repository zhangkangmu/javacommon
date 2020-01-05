package hong.练习的包.day08_同步线程锁.test2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhangyuhong
 * Date:2017/12/25
 */
public class Demo {
    public static void main(String[] args) {

        MyThread mt = new MyThread("子线程");
        mt.start();

        for (int i = 0; i < 10000; i++) {
            mt.num.getAndIncrement();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(mt.num);
    }

}
