package hong.练习的包.day08_同步线程锁.test5;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by zhangyuhong
 * Date:2017/12/26
 */
public class Demo {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Metting());
        Thread thread1 = new Thread1(cyclicBarrier);
        Thread thread2 = new Thread2(cyclicBarrier);
        Thread thread3 = new Thread3(cyclicBarrier);
        Thread thread4 = new Thread4(cyclicBarrier);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
