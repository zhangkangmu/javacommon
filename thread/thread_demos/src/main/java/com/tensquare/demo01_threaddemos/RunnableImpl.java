/**
 * Copyright (c) 2020 itheima.com, All rights reserved.
 *
 * @Author: lvyang
 */
package com.tensquare.demo01_threaddemos;

/**
 * @Description:
 * @Author: lvyang
 * @Created Date: 2020年06月03日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
public class RunnableImpl implements Runnable {

    static int i = 0;

    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在执行....."+i++);
    }

    public static void main(String[] args) {
        //方式一：创建一个类实现runnable
       /* RunnableImpl runnable = new RunnableImpl();
        */
       //方式二：创建匿名内部类实现Runnable接口
        /*Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName()+"正在执行....."+i++);
            }
        };*/

        //方式三：使用lambdas表达式
        for (int j = 0; j < 10; j++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"正在执行....."+i++);
            }).start();
        }
    }
}