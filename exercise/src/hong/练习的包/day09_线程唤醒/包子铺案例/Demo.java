package hong.练习的包.day09_线程唤醒.包子铺案例;

/**
 * Created by zhangyuhong
 * Date:2019/12/27
 */
public class Demo {
    public static void main(String[] args) {
        //包子铺生产完包子后，一人吃一个包子，然后重新生产包子
        BaoZi baoZi = new BaoZi();
        BaoZiPu baoZiPu = new BaoZiPu("包子铺", baoZi);
        ChiHuo chiHuo1 = new ChiHuo("吃货", baoZi);
        ChiHuo222 chiHuo2 = new ChiHuo222("吃货222", baoZi);
        baoZiPu.start();
        chiHuo1.start();
        chiHuo2.start();
    }
}
