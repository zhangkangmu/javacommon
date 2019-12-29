package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo3_同步方法解决线程安全问题;

/**
 * @author 彭智林
 * @date 2019/12/25 9:00
 */
public class MyRunnable implements Runnable {
    int tickets = 100;

    @Override
    public  void run() {
        // 任务  卖票
        while (true) {
            // 循环结束
            if (sellTickets()) break;
        }
    }

    private synchronized boolean sellTickets() {
        if(tickets < 1){
            return true;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":正在出售第"+tickets+"张票");
        tickets--;
        return false;
    }
}
