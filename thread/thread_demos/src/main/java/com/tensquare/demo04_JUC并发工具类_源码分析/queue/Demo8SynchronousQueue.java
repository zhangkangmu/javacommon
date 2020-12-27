package com.tensquare.demo04_JUC并发工具类_源码分析.queue;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class Demo8SynchronousQueue {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();

        new Thread(new Product(queue)).start();
        new Thread(new Customer(queue)).start();
    }

    static class Product implements Runnable {
        SynchronousQueue<Integer> queue;
        Random r = new Random();

        public Product(SynchronousQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                int number = r.nextInt(1000);
                System.out.println("等待1秒后运送" + number);
                try {
                    TimeUnit.SECONDS.sleep(1);

                    queue.put(number);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Customer implements Runnable {
        SynchronousQueue<Integer> queue;

        public Customer(SynchronousQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("收到了:" + queue.take());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}