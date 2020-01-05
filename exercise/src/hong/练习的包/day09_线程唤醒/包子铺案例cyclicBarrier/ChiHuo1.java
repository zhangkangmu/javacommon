package hong.练习的包.day09_线程唤醒.包子铺案例cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by zhangyuhong
 * Date:2017/12/27
 */
public class ChiHuo1 extends Thread {
    private final CyclicBarrier cyclicBarrier;

    public ChiHuo1(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier=cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
