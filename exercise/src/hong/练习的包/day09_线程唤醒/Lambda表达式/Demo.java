package hong.练习的包.day09_线程唤醒.Lambda表达式;

/**
 * Created by zhangyuhong
 * Date:2019/12/27
 */
public class Demo {
    public static void main(String[] args) {
        new Thread(()->{});

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }
}
