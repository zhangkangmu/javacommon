/**
 * Copyright (c) 2020 itheima.com, All rights reserved.
 *
 * @Author: lvyang
 */
package com.tensquare.demo04_JUC并发工具类_源码分析.utils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: lvyang
 * @Created Date: 2020年06月05日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(0);
        //一个等待的线程
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"线程开始等待");
                countDownLatch.await();
                System.out.println(Thread.currentThread().getName()+"线程等待结束，继续执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        //唤醒的线程
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName()+"执行完毕，count-1，当前值:"+countDownLatch.getCount());
            }).start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}