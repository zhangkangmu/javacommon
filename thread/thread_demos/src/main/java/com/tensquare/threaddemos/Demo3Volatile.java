package com.tensquare.threaddemos;

import java.util.concurrent.atomic.AtomicInteger;

//原子性
public class Demo3Volatile {

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo demo = new VolatileDemo();

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(demo);
            t.start();
        }

        while (Thread.activeCount()>2){
        }
        System.out.println(demo.count);
    }

    static class VolatileDemo implements Runnable {
        //public volatile int count;
        public AtomicInteger count = new AtomicInteger(0);

        public void run() {
            addCount();
        }

        public void addCount() {
            for (int i = 0; i < 100000; i++) {
                count.incrementAndGet();
            }
        }
    }
}