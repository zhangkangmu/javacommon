package hong.练习的包.day09_线程唤醒.包子铺案例;

/**
 * Created by zhangyuhong
 * Date:2019/12/27
 */
public class BaoZiPu extends Thread {
    private final BaoZi baoZi;

    public BaoZiPu(String baozipu, BaoZi baoZi) {
        super(baozipu);
        this.baoZi = baoZi;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (baoZi) {
                if (baoZi.flag){
                    System.out.println("现在有包子");
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //没有包子的时候
                System.out.println("生产完了包子");
                baoZi.sum=2;
                baoZi.flag=true;
                baoZi.notify();
            }
        }
    }
}
