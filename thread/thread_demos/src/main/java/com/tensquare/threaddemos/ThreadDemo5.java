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
public class ThreadDemo5 {

    static Boolean flag=true;

    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                while (flag) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "线程正在运行");
                }
                System.out.println("终止线程");
            }
        };
        new Thread(task).start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = false;
        System.out.println("flag变为"+flag);
    }
}