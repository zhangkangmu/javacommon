package hong.练习的包.day08_同步线程锁.test7;

import java.util.concurrent.Exchanger;

/**
 * Created by zhangyuhong
 * Date:2019/12/26
 */
public class Thread1 extends Thread {
    private final Exchanger<String> exchanger;

    public Thread1(String str, Exchanger<String> exchanger) {
        super(str);
        this.exchanger=exchanger;
    }

    @Override
    public void run() {
        try {
            String gift1 = exchanger.exchange("线程1发出去的礼物");
            System.out.println(Thread.currentThread().getName()+"拿到了"+gift1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
