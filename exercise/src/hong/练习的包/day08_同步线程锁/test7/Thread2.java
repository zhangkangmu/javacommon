package hong.练习的包.day08_同步线程锁.test7;

import java.util.concurrent.Exchanger;

/**
 * Created by zhangyuhong
 * Date:2017/12/26
 */
public class Thread2 extends Thread {
    private final Exchanger<String> exchanger;

    public Thread2(String str, Exchanger<String> exchanger) {
        super(str);
        this.exchanger=exchanger;
    }

    @Override
    public void run() {
        try {
            String gift2 = exchanger.exchange("线程2发出去的礼物");
            System.out.println(Thread.currentThread().getName()+"拿到了"+gift2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
