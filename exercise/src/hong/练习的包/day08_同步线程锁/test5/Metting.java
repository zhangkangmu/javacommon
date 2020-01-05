package hong.练习的包.day08_同步线程锁.test5;

/**
 * Created by zhangyuhong
 * Date:2017/12/26
 */
public class Metting extends Thread {
    @Override
    public void run() {
        System.out.println("现在开始开会");
    }
}
