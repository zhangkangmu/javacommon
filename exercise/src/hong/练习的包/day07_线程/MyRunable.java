package hong.练习的包.day07_线程;

/**
 * Created by zhangyuhong
 * Date:2017/12/24
 */
public class MyRunable implements Runnable {
    @Override
    public void run() {
        for (int k = 0; k < 100; k++) {
            System.out.println(Thread.currentThread().getName()+"：--"+k);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
