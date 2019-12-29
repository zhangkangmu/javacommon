package 基础.day07_排序算法_异常_多线程基础.demo18_创建线程方式一和方式二的区别;

/**
 * @author 彭智林
 * @date 2019/12/24 16:17
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("子线程 中的i循环,第"+i+"次循环");
        }
    }
}
