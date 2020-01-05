package 基础.day07_排序算法_异常_多线程基础.demo18_创建线程方式一和方式二的区别;

/**
 * @author 彭智林
 * @date 2017/12/24 16:16
 */
public class Demo {
    public static void main(String[] args) {
        /*
            创建线程方式一和方式二的区别: 实现Runnable接口方式的优势
                1.适合多个相同的程序代码的线程去共享同一个资源。
                2.可以避免java中的单继承的局限性。
                3.增加程序的健壮性，实现解耦操作，代码可以被多个线程共享，代码和线程独立。
                4.线程池只能放入实现Runable或Callable类线程，不能直接放入继承Thread的类。
                  线程池: 可以存储多条线程的池子
            注意:
                线程不能重复启动
         */
        // 创建实现类对象
        MyRunnable mr = new MyRunnable();// 任务

        // 创建线程对象,传入实现类对象
        Thread t1 = new Thread(mr);
        // 调用start()方法启动线程,并执行任务
        t1.start();


        // 创建线程对象,传入实现类对象
        Thread t2 = new Thread(mr);
        // 调用start()方法启动线程,并执行任务
        t2.start();

        System.out.println("========================");
        MyThread mt1 = new MyThread();
        mt1.start();

        MyThread mt2 = new MyThread();
        mt2.start();
    }
}
