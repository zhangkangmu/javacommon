package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo17_CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @author 彭智林
 * @date 2017/12/25 16:00
 */
public class Demo {
    public static void main(String[] args) {
        /*
            CyclicBarrier:
                构造方法:
                    public CyclicBarrier(int parties, Runnable barrierAction);// 用于在线程到达屏障时，优先执行barrierAction，方便处理更复杂的业务场景
                成员方法:
                    public int await()// 每个线程调用await方法告诉CyclicBarrier我已经到达了屏障，然后当前线程被阻塞
                 使用场景: 使用两个线程读取2个文件中的数据，当两个文件中的数据都读取完毕以后，进行数据的汇总操作。

                例如：公司召集5名员工开会，等5名员工都到了，会议开始。
                 分析:
                    1.5名员工就是5条线程
                    2.开会,其实就是一个开会线程
                    3.当有一个员工到达屏障(到了会议室),调用await()方法,告诉CyclicBarrier我已经到达了
                    4.只有等5名员工都到达屏障,才会执行开会线程

         */
        // 创建CyclicBarrier对象,指定线程数量为5,指定任务为MeetingThread线程对象
        CyclicBarrier cb = new CyclicBarrier(5,new MeetingThread());
        // 创建5条PersonThread线程,并传入CyclicBarrier
        PersonThread t1 = new PersonThread(cb);
        PersonThread t2 = new PersonThread(cb);
        PersonThread t3 = new PersonThread(cb);
        PersonThread t4 = new PersonThread(cb);
        PersonThread t5 = new PersonThread(cb);

        // 启动5条PersonThread线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
