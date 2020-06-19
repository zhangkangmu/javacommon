package com.tensquare.demo01_threaddemos;

//守护线程
public class Demo4Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                    }
                    System.out.println("子线程..." + i);
                }
            }
        });
		
        // 设置线程为守护线程
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(10);
                System.out.println("主线程" + i);
            } catch (Exception e) {

            }
        }

        System.out.println("主线程执行完毕!");
    }
}