package 基础.day09_线程状态_等待与唤醒_Lambda表达式_Stream流.demo3_等待唤醒案例包子铺卖包子;

/**
 * @author 彭智林
 * @date 2017/12/27 10:15
 */
public class BaoZiPuThread extends Thread {

    BaoZi bz;

    public BaoZiPuThread(String name, BaoZi bz) {
        super(name);
        this.bz = bz;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bz) {
                // 判断包子的状态,如果是有了,就进入无限等待
                if (bz.flag == true) {
                    try {
                        bz.wait();// 无限等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 如果是没有,就生产包子,生产完了,就唤醒吃货线程来吃包子
                System.out.println(getName() + ":开始生产包子...");
                bz.xianer = "叉烧";
                bz.flag = true;// 包子包好了
                System.out.println(getName() + ":包子生产完毕,吃货快来吃包子...");
                bz.notify();// 唤醒吃货线程来吃包子

            }// 释放锁
        }
    }


}
