package hong.练习的包.day08_同步线程锁.test1;


import org.omg.CORBA.TIMEOUT;

/**
 * Created by zhangyuhong
 * Date:2017/12/24
 */
public class MyRunable implements Runnable {
     int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (sellTickets()) break;
        }
    }

    private synchronized boolean sellTickets() {
        if (ticket < 1) {
            return true;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "卖出第：" + ticket + "张票");
        ticket--;
        return false;
    }




   /* @Override
    public void run() {
        while (true) {
            synchronized (MyRunable.class) {
                if (ticket < 1) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "卖出第：" + ticket + "张票");
                ticket--;
            }
        }
    }*/
}
