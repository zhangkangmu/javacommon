package hong.练习的包.day09_线程唤醒.包子铺案例cyclicBarrier;

/**
 * Created by zhangyuhong
 * Date:2017/12/27
 */
public class BaoziPu extends Thread {
    @Override
    public void run() {
        System.out.println("开始生产面包");
    }
}
