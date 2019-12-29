package 基础.day09_线程状态_等待与唤醒_Lambda表达式_Stream流.demo3_等待唤醒案例包子铺卖包子;

/**
 * @author 彭智林
 * @date 2019/12/27 10:14
 */
public class ChiHuoThread extends Thread {
    BaoZi bz;

    public ChiHuoThread(String name, BaoZi bz) {
        super(name);
        this.bz = bz;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (bz) {
                // 判断包子的状态,如果是没有,就进入无限等待
                if (bz.flag == false) {
                    try {
                        bz.wait();// 无限等待 醒了
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 如果是有了,就吃包子,吃完了包子,就唤醒包子铺线程来生产包子
                // 说明一定有包子
                System.out.println(getName() + ":开始吃包子,包子馅儿是:" + bz.xianer + "=======================");
                bz.flag = false;// 包子吃完了
                bz.notify();// 唤醒包子铺线程
            }
        }
    }



}
