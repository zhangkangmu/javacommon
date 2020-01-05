package hong.练习的包.day09_线程唤醒.包子铺案例;

/**
 * Created by zhangyuhong
 * Date:2017/12/27
 */
public class ChiHuo extends Thread {
    private final BaoZi baoZi;

    public ChiHuo(String person, BaoZi baoZi) {
        super(person);
        this.baoZi = baoZi;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (baoZi) {
                if (!baoZi.flag && baoZi.sum==2) {
                    try {
                        System.out.println(getName() + "：发现现在没有包子");
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                if (baoZi.sum == 2) {
                    System.out.println(getName() + "吃完了一个包子！");
                    baoZi.flag=false;
                    baoZi.sum=baoZi.sum- 1;
                    baoZi.notify();
                }
            }
        }
    }
}
