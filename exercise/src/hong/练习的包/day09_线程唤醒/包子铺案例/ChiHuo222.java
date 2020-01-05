package hong.练习的包.day09_线程唤醒.包子铺案例;

/**
 * Created by zhangyuhong
 * Date:2017/12/27
 */
public class ChiHuo222 extends Thread {
    private final BaoZi baoZi;

    public ChiHuo222(String person, BaoZi baoZi) {
        super(person);
        this.baoZi = baoZi;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (baoZi) {
                if (!baoZi.flag && baoZi.sum==1) {
                    try {
                        System.out.println(getName() + "：发现现在没有包子");
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (baoZi.sum == 1) {
                    System.out.println(getName() + ":吃了第二个包子");
                    System.out.println(getName() + "吃完了一个包子！");
                    baoZi.sum =(baoZi.sum- 1);
                    baoZi.flag = true;
                    baoZi.notify();
                }
            }
        }
    }
}
