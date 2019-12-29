package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo1_线程安全问题;

/**
 * @author 彭智林
 * @date 2019/12/25 9:00
 */
public class MyRunnable implements Runnable {
    int tickets = 100;// 100张火车票  // -3

    @Override
    public void run() {
        // 任务  卖票
        while (true) {
            // 循环结束
            if(tickets < 1){// 窗口1 1 窗口2 1 窗口3 1  窗口4 1
                break;
            }
            try {
                Thread.sleep(100);// 窗口1 睡 窗口2 睡 窗口3 睡 窗口4 睡
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 窗口1 醒了 窗口2 醒了 窗口3 醒了 窗口4 醒了
            System.out.println(Thread.currentThread().getName()+":正在出售第"+tickets+"张票");
            tickets--;
        }
    }
}
