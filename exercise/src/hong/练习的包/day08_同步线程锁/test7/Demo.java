package hong.练习的包.day08_同步线程锁.test7;

import java.util.concurrent.Exchanger;

/**
 * Created by zhangyuhong
 * Date:2017/12/26
 */
public class Demo {
    public static void main(String[] args) {
        Exchanger<String> stringExchanger = new Exchanger<>();
        new Thread1("线程1",stringExchanger).start();
        new Thread2("线程2",stringExchanger).start();
    }
}
