package hong.练习的包.day08_同步线程锁.test1;


/**
 * Created by zhangyuhong
 * Date:2019/12/25
 */
public class Demo {
    public static void main(String[] args) {
        MyRunable myRunable = new MyRunable();

        new Thread(myRunable,"窗口1").start();
        new Thread(myRunable,"窗口2").start();
        new Thread(myRunable,"窗口3").start();
        new Thread(myRunable,"窗口4").start();
    }
}
