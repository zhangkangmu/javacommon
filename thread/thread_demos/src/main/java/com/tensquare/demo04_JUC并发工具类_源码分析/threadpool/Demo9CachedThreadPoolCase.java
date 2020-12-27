package com.tensquare.demo04_JUC并发工具类_源码分析.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo9CachedThreadPoolCase {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            exec.execute(new Demo());
            Thread.sleep(1);
        }
        exec.shutdown();
    }

    static class Demo implements Runnable {
        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            try {
                //修改睡眠时间，模拟线程执行需要花费的时间
                Thread.sleep(100);

                System.out.println(name + "执行完了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}