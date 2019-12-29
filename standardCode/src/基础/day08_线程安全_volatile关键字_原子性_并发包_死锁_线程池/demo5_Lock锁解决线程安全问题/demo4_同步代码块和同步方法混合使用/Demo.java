package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo4_同步代码块和同步方法混合使用;

/**
 * @author 彭智林
 * @date 2019/12/25 9:59
 */
public class Demo {
    public static void main(String[] args) {
        /*
            案例:一条线程使用同步方法,一条线程使用同步代码块,实现这2条线程同步
         */
       /* // 线程1:使用同步方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 任务
                Demo.wc();
            }
        },"张三").start();

        // 线程2:使用同步代码块
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 任务
                synchronized (Demo.class) {
                    System.out.println(Thread.currentThread().getName()+":打开厕所门...");
                    System.out.println(Thread.currentThread().getName()+":关闭厕所门...");
                    System.out.println(Thread.currentThread().getName()+":脱裤子...");
                    System.out.println(Thread.currentThread().getName()+":蹲下...");
                    System.out.println(Thread.currentThread().getName()+":用力...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":擦屁股...");
                    System.out.println(Thread.currentThread().getName()+":穿裤子...");
                    System.out.println(Thread.currentThread().getName()+":冲厕所...");
                    System.out.println(Thread.currentThread().getName()+":打开厕所门...");
                    System.out.println(Thread.currentThread().getName()+":洗手,开开心心走了...");
                }
            }
        },"李四").start();*/

        // 线程1:使用同步方法
        Demo demo = new Demo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 任务
               demo.wc2();
            }
        },"张三").start();

        // 线程2:使用同步代码块
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 任务
                synchronized (demo) {
                    System.out.println(Thread.currentThread().getName()+":打开厕所门...");
                    System.out.println(Thread.currentThread().getName()+":关闭厕所门...");
                    System.out.println(Thread.currentThread().getName()+":脱裤子...");
                    System.out.println(Thread.currentThread().getName()+":蹲下...");
                    System.out.println(Thread.currentThread().getName()+":用力...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":擦屁股...");
                    System.out.println(Thread.currentThread().getName()+":穿裤子...");
                    System.out.println(Thread.currentThread().getName()+":冲厕所...");
                    System.out.println(Thread.currentThread().getName()+":打开厕所门...");
                    System.out.println(Thread.currentThread().getName()+":洗手,开开心心走了...");
                }
            }
        },"李四").start();
    }

    public  synchronized void wc2(){// 非静态同步方法  锁对象:this
        System.out.println(Thread.currentThread().getName()+":打开厕所门...");
        System.out.println(Thread.currentThread().getName()+":关闭厕所门...");
        System.out.println(Thread.currentThread().getName()+":脱裤子...");
        System.out.println(Thread.currentThread().getName()+":蹲下...");
        System.out.println(Thread.currentThread().getName()+":用力...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":擦屁股...");
        System.out.println(Thread.currentThread().getName()+":穿裤子...");
        System.out.println(Thread.currentThread().getName()+":冲厕所...");
        System.out.println(Thread.currentThread().getName()+":打开厕所门...");
        System.out.println(Thread.currentThread().getName()+":洗手,开开心心走了...");
    }

    public  static synchronized void wc(){// 静态同步方法  锁对象:Demo.class
        System.out.println(Thread.currentThread().getName()+":打开厕所门...");
        System.out.println(Thread.currentThread().getName()+":关闭厕所门...");
        System.out.println(Thread.currentThread().getName()+":脱裤子...");
        System.out.println(Thread.currentThread().getName()+":蹲下...");
        System.out.println(Thread.currentThread().getName()+":用力...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":擦屁股...");
        System.out.println(Thread.currentThread().getName()+":穿裤子...");
        System.out.println(Thread.currentThread().getName()+":冲厕所...");
        System.out.println(Thread.currentThread().getName()+":打开厕所门...");
        System.out.println(Thread.currentThread().getName()+":洗手,开开心心走了...");
    }
}
