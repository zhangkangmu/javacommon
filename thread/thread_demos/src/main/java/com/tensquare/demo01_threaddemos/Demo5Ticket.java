package com.tensquare.demo01_threaddemos;

public class Demo5Ticket {

    public static void main(String[] args) {
        //创建线程任务对象
        Ticket ticket = new Ticket();
        //创建三个窗口对象
        Thread t1 = new Thread(ticket, "窗口1");
        Thread t2 = new Thread(ticket, "窗口2");
        Thread t3 = new Thread(ticket, "窗口3");

        //卖票
        t1.start();
        t2.start();
        t3.start();
    }

    //1.synchronized加锁永远锁的是对象
    //2.synchronized放在静态方法上锁的是当前类的class对象
    //3.synchronized放在非静态方法上锁的是this对象
    static class Ticket implements Runnable {

        Object lock = new Object();
        //ReentrantLock lock = new ReentrantLock();
        private static int ticket = 10;

        public void run() {
            String name = Thread.currentThread().getName();
            int num = 0;
            while (true) {
                if(num%2==0){
                    sell(name);
                }else{
                    sell2(name);
                }

                if (ticket <= 0) {
                    break;
                }
                num++;
            }
        }

        private static synchronized void sell(String name) {
            try {
                Thread.sleep(10);
                if (ticket > 0) {
                    System.out.println(name + "卖票：" + ticket);
                    ticket--;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
            }
        }

        private void sell2(String name) {
            synchronized(lock){
                try {
                    Thread.sleep(10);
                    if (ticket > 0) {
                        System.out.println(name + "卖票：" + ticket);
                        ticket--;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                }
            }
        }
    }


}