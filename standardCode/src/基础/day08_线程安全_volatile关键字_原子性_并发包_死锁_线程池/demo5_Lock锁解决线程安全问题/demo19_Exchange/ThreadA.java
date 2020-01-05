package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo19_Exchange;

import java.util.concurrent.Exchanger;

/**
 * @author 彭智林
 * @date 2017/12/25 16:42
 */
public class ThreadA extends Thread {

    Exchanger<String> ex;

    public ThreadA(Exchanger<String> ex) {
        this.ex = ex;
    }

    @Override
    public void run() {
        System.out.println("线程A准备把 礼物A 传递给 线程B:");
        try {
           String giftB = ex.exchange("礼物A");// 把"礼物A"给B线程,返回的是B线程传递的礼物
            System.out.println("线程A接收到的礼物为:"+giftB);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
