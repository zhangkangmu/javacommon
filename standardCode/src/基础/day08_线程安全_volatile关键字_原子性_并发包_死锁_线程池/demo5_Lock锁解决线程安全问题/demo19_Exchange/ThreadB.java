package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo19_Exchange;

import java.util.concurrent.Exchanger;

/**
 * @author 彭智林
 * @date 2019/12/25 16:42
 */
public class ThreadB extends Thread {

    Exchanger<String> ex;

    public ThreadB(Exchanger<String> ex) {
        this.ex = ex;
    }

    @Override
    public void run() {
        System.out.println("线程B准备把 礼物B 传递给 线程A:");
        try {
           String giftA = ex.exchange("礼物B");// 把"礼物B"给A线程,返回的是A线程传递的礼物
            System.out.println("线程B接收到的礼物为:"+giftA);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
