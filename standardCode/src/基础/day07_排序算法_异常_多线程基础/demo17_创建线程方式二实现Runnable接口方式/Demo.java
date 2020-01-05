package 基础.day07_排序算法_异常_多线程基础.demo17_创建线程方式二实现Runnable接口方式;

/**
 * @author 彭智林
 * @date 2017/12/24 16:09
 */
public class Demo {
    public static void main(String[] args) {
        /*
            创建线程方式二实现Runnable接口方式:
                1.创建Runnable接口的实现类
                2.在实现类中,重写run()方法,把线程需要执行的代码放入run()方法中
                3.创建实现类对象
                4.创建线程对象,传入实现类对象
                5.使用线程对象调用start()方法,启动线程,并执行任务
         */
        // 创建实现类对象
        MyRunnable mr = new MyRunnable();
        // 创建线程对象,传入实现类对象
        Thread t = new Thread(mr);
        // 使用线程对象调用start()方法,启动线程,并执行任务
        t.start();


        for (int j = 0; j < 100; j++) {
            System.out.println("主线程 中的j循环,第"+j+"次循环");
        }
    }
}
