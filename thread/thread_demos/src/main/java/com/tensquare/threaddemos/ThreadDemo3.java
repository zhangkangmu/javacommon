/**
 * Copyright (c) 2020 itheima.com, All rights reserved.
 *
 * @Author: lvyang
 */
package com.tensquare.threaddemos;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description:
 * @Author: lvyang
 * @Created Date: 2020年06月03日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
public class ThreadDemo3 {

    static int i = 0;

    public static void main(String[] args) {
       /* CountDownLatch countDownLatch = new CountDownLatch(10);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 10; j++) {
                    System.out.println(++i);
                    countDownLatch.countDown();
                }
            }
        };
        new Thread(runnable).start();
        *//*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*//*
        *//*while (Thread.activeCount()>2){

        }*//*
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束后："+i);*/
        //1.创建一个匿名内部类实现Callable接口，泛型表示返回类型
        Callable<String> callable = new Callable<String>(){
            @Override
            public String call() throws Exception {
                while (i<10){
                    System.out.println(Thread.currentThread().getName()+"正在执行。。"+(++i));
                }
                return "ok";
            }
        };
        //2.创建一个FutureTask,将上面创建好的Callable实例传入进来
        FutureTask<String> stringFutureTask = new FutureTask<>(callable);
        //3.放到线程中执行
        Thread thread = new Thread(stringFutureTask);
        thread.start();
        //4.通过FutureTask异步的拿到响应结果
        while (thread.getState()==Thread.State.RUNNABLE){

        }
        System.out.println("最终结果："+i);
        /*try {
            if("ok".equals(stringFutureTask.get())){
                System.out.println("最终结果："+i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
    }
}