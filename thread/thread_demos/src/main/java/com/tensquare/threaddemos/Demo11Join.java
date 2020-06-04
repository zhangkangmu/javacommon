package com.tensquare.threaddemos;
/*
作用是让其他线程变为等待。thread.Join把指定的线程加入到当前线程，
可以将两个交替执行的线程合并为顺序执行的线程。比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。
就是让他有顺序执行而已,不然就互相抢夺资源,乱序了

//Thread.yield();  running-->ready
Thread.yield()方法的作用：暂停当前正在执行的线程，并执行其他线程。（可能没有效果）
yield()让当前正在运行的线程回到可运行状态，以允许具有相同优先级的其他线程获得运行的机会。
因此，使用yield()的目的是让具有相同优先级的线程之间能够适当的轮换执行。但是，实际中无法保证yield()达到让步的目的，
因为，让步的线程可能被线程调度程序再次选中。
*/
public class Demo11Join {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    String name = Thread.currentThread().getName();
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(name+"执行"+i);
                }
            }
        }, "线程1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //thread1.join(); //线程1执行完后再执行后面的
                    thread1.join(500);  //等待500ms后,线程1还没执行完  就一起执行,开始无限了
                } catch (InterruptedException e) {  //被interrupt中断后走到后面的异常,释放锁
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; i++) {
                    String name = Thread.currentThread().getName();
                    System.out.println(name+"执行"+i);
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "线程2");
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; i++) {
                    String name = Thread.currentThread().getName();
                    System.out.println(name+"执行"+i);
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "线程3");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread3.join();
        } catch (Exception e) {

        }
        for (int i = 0; i < 5; i++) {
            System.out.println("main ---i:" + i);
        }
    }

}