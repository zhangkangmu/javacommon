package com.tensquare.demo04_JUC并发工具类_源码分析.utils;

import java.util.concurrent.CyclicBarrier;

public class Demo1CyclicBarrier {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{
            System.out.println(Thread.currentThread().getName()+"开始执行");});

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Athlete(cyclicBarrier, "运动员" + i),"运动员" + i);
            t.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class Athlete implements Runnable {

        private CyclicBarrier cyclicBarrier;
        private String name;

        public Athlete(CyclicBarrier cyclicBarrier, String name) {
            this.cyclicBarrier = cyclicBarrier;
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + "就位");
            try {
                cyclicBarrier.await();//阻塞线程运行，直到第5个线程到达屏障，所有被阻塞的线程同时执行
                System.out.println(name + "跑到终点。");
            } catch (Exception e) {
            }
        }
    }
}