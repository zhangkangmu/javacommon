package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo5_Lock锁解决线程安全问题.Demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 彭智林
 * @date 2017/12/25 9:00
 */
public class MyRunnable implements Runnable {
    int tickets = 100;// 0

    Lock lock = new ReentrantLock();


    @Override
    public  void run() {
        // 任务  卖票
        while (true) {
            // 加锁
            lock.lock();
            if(tickets < 1){//
                lock.unlock();
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":正在出售第"+tickets+"张票");
            tickets--;
            // 释放锁
            lock.unlock();
        }
    }


}
