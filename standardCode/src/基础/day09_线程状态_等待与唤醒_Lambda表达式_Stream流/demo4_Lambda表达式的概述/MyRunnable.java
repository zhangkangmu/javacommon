package 基础.day09_线程状态_等待与唤醒_Lambda表达式_Stream流.demo4_Lambda表达式的概述;

/**
 * @author 彭智林
 * @date 2017/12/27 11:05
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("实现的方法创建线程的任务执行了...");
    }
}
