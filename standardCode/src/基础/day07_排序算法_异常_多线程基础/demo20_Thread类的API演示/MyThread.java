package 基础.day07_排序算法_异常_多线程基础.demo20_Thread类的API演示;

/**
 * @author 彭智林
 * @date 2017/12/24 16:43
 */
public class MyThread extends Thread{

    public MyThread() {
        super();
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        // 任务
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+" 中的i循环,第"+i+"次循环");
        }
    }
}
