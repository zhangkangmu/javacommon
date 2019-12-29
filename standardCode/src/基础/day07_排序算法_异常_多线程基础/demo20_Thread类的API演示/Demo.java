package 基础.day07_排序算法_异常_多线程基础.demo20_Thread类的API演示;

/**
 * @author 彭智林
 * @date 2019/12/24 16:43
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        // 继承的方式创建线程:
        /*// 使用空参构造方法创建线程对象
        MyThread mt1 = new MyThread();// 线程的名称是默认名称:Thread-0
        mt1.start();


        // 使用有参构造方法创建线程对象
        MyThread mt2 = new MyThread("小强线程");// 线程的名称是指定的名称:小强线程
        mt2.start();*/


        /*// 实现Runnable接口的方式创建线程:
        MyRunnable mr = new MyRunnable();
        // 创建线程对象,传入mr任务对象
        Thread t1 = new Thread(mr);// 线程的名称是默认名称:Thread-0
        t1.start();*/

        MyRunnable mr = new MyRunnable();
        // 创建线程对象,传入mr任务对象
        Thread t2 = new Thread(mr,"老王线程");// 线程的名称是指定名称:老王线程
        t2.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+": 中的i循环,第"+i+"次循环");
            // 打印一次,暂定1秒
            Thread.sleep(1000);// 线程进入睡眠就不会抢占资源

           /* try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }

    }
}
