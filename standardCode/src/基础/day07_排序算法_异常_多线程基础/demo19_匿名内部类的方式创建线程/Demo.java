package 基础.day07_排序算法_异常_多线程基础.demo19_匿名内部类的方式创建线程;

/**
 * @author 彭智林
 * @date 2017/12/24 16:27
 */
public class Demo {
    public static void main(String[] args) {
        /*
             匿名内部类的方式创建线程:
                1.创建Thread线程对象,传入Runnable接口的匿名内部类
                2.在匿名内部类中重写run()方法,把线程需要执行的任务放入run()方法中
                3.使用Thread线程对象调用start()方法,启动线程,并执行任务
         */
        // 创建Thread线程对象,传入Runnable接口的匿名内部类
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                // 任务
                for (int i = 0; i < 100; i++) {
                    System.out.println("子线程 中的i循环,第"+i+"次循环");
                }
            }
        });

        // 使用Thread线程对象调用start()方法,启动线程,并执行任务
        t.start();

        for (int j = 0; j < 100; j++) {
            System.out.println("主线程 中的j循环,第"+j+"次循环");
        }



    }
}
