package hong.练习的包.day09_线程唤醒.包子铺案例cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by zhangyuhong
 * Date:2017/12/27
 */
public class Demo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new BaoziPu());
        ChiHuo1 chiHuo1 = new ChiHuo1(cyclicBarrier);

    }
}
