package hong.练习的包.day09_线程练习;

/**
 * Created by zhangyuhong
 * Date:2017/12/28
 */
public class MyRunnable implements Runnable {

     int num=0;
    @Override
    public void run() {
        try {
            synchronized (this){
                num++;
                System.out.println(Thread.currentThread().getName()+"：正在过山洞，是第"+num+"个人走过的");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"走完了");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
