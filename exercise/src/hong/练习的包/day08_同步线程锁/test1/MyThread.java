package hong.练习的包.day08_同步线程锁.test1;

/**
 * Created by zhangyuhong
 * Date:2017/12/25
 */
public class MyThread extends Thread {
    public MyThread(MyRunable myRunable, String name) {
        super(name);
    }

    @Override
    public void run() {
    }
}

