package 基础.day07_排序算法_异常_多线程基础.demo16.创建线程方式一继承Thread类方式;

/**
 * @author 彭智林
 * @date 2017/12/24 15:51
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        // 任务
        for (int i = 0; i < 100; i++) {
            System.out.println("子线程 中的i循环,第"+i+"次循环");
        }
    }
}
