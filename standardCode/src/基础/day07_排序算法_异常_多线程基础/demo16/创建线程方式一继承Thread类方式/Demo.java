package 基础.day07_排序算法_异常_多线程基础.demo16.创建线程方式一继承Thread类方式;

/**
 * @author 彭智林
 * @date 2019/12/24 15:48
 */
public class Demo {
    public static void main(String[] args) {
        /*
            创建线程方式一继承Thread类方式:
                1.创建一个子类继承Thread类
                2.在子类中重写run()方法,把线程需要执行的任务(代码)放入该方法中
                3.创建该子类线程对象
                4.使用线程对象,调用start()方法启动线程,并执行任务

              java中线程的调度方式是抢占式
         */
        // 创建子类线程对象
        MyThread mt = new MyThread();
        // 使用线程对象,调用start()方法启动线程,并执行任务
        mt.start();

        for (int j = 0; j < 100; j++) {
            System.out.println("主线程 中的j循环,第"+j+"次循环");

        }

    }
}
