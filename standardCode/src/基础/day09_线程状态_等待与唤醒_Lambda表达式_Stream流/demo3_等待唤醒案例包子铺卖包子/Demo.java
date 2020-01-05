package 基础.day09_线程状态_等待与唤醒_Lambda表达式_Stream流.demo3_等待唤醒案例包子铺卖包子;

/**
 * @author 彭智林
 * @date 2017/12/27 10:01
 */
public class Demo {
    public static void main(String[] args) {
        /*
            等待唤醒案例（包子铺卖包子):
            注意:
                1.一个无限等待线程被唤醒了,并获得锁对象,就会从进入无限等待的位置继续往下执行
                2.一个线程进入无限等待,就不会争夺锁,不会抢cpu(释放锁,不占用cpu)
                3.一旦一个线程释正常的释放锁,该线程还是会继续抢锁
         */
        // 创建一个包子对象
        BaoZi bz = new BaoZi();
        // 创建包子铺线程,传入包子对象
        BaoZiPuThread bzp = new BaoZiPuThread("包子铺",bz);
        // 创建吃货线程,传入包子对象
        ChiHuoThread chiHuo = new ChiHuoThread("吃货线程",bz);
        // 启动包子铺和吃货线程
        bzp.start();
        chiHuo.start();
    }
}
