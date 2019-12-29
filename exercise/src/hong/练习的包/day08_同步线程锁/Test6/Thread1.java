package hong.练习的包.day08_同步线程锁.Test6;

import java.util.concurrent.Semaphore;

/**
 * Created by zhangyuhong
 * Date:2019/12/25
 *
 */
public class Thread1 extends Thread {


    private  Semaphore sp;

    public Thread1(Semaphore ap,String name) {
        super(name);
        this.sp =ap;
    }

    @Override
    public void run() {
        try {
            sp.acquire();
            System.out.println(Thread.currentThread().getName()+"进入线程："+System.currentTimeMillis());

            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        sp.release();
    }
}
