/**
 * Copyright (c) 2020 itheima.com, All rights reserved.
 *
 * @Author: lvyang
 */
package com.tensquare.threaddemos;

/**
 * @Description:
 * @Author: lvyang
 * @Created Date: 2020年06月03日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
public class ThreadExDemo {

    static class ThreadEx extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"正在执行.....");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new ThreadEx().start();
        }
    }
}