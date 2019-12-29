package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo19_Exchange;

import java.util.concurrent.Exchanger;

/**
 * @author 彭智林
 * @date 2019/12/25 16:37
 */
public class Demo {
    public static void main(String[] args) {
        /*
            Exchanger<E>:
                概述:Exchanger（交换者）是一个用于线程间协作的工具类。Exchanger用于进行线程间的数据交换。
                这两个线程通过exchange方法交换数据，如果第一个线程先执行exchange()方法，
                它会一直等待第二个线程也执行exchange方法，当两个线程都到达同步点时，
                这两个线程就可以交换数据，将本线程生产出来的数据传递给对方。

                构造方法:
                    public Exchanger()
                成员方法:
                    public V exchange(V x)// 交换数据的方法  把参数的数据传递给另一条线程,返回另一条线程传递过来的数据

                案例:
                    线程A传递"礼物A"给线程B
                    线程B传递"礼物B"给出线程A
                分析:
                    1.创建线程A类,重写run方法,在run()方法中调用Exchanger类的exchange()方法,把礼物传递给线程B
                    2.创建线程B类,重写run方法,在run()方法中调用Exchanger类的exchange()方法,把礼物传递给线程A
                    3.线程A和线程B中的Exchanger对象是一致的
         */
        // 创建Exchanger对象
        Exchanger<String> ex = new Exchanger<>();
        // 创建线程A,传入Exchanger对象,启动线程
        new ThreadA(ex).start();
        // 创建线程B,传入Exchanger对象,启动线程
        new ThreadB(ex).start();
    }
}
