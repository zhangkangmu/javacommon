package com.tensquare.demo04_JUC并发工具类_源码分析.utils;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Demo3Semaphore {

    public static void main(String[] args) {
        Parking parking = new Parking(3);
        for (int i = 0; i < 5; i++) {
            new Car(parking).start();
        }
    }

    static class Parking {
        //信号量
        private Semaphore semaphore;

        Parking(int count) {
            semaphore = new Semaphore(count);
        }

        public void park() {
            try {
                //获取信号量，如果没有可用的许可当前线程就被阻塞
                semaphore.acquire();
                long time = (long) (Math.random() * 10);
                System.out.println(Thread.currentThread().getName() + "进入停车场，停车" + time + "秒...");
                TimeUnit.SECONDS.sleep(time);
                System.out.println(Thread.currentThread().getName() + "开出停车场...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //释放信号量
                semaphore.release();
            }
        }
    }

    static class Car extends Thread {
        Parking parking;

        Car(Parking parking) {
            this.parking = parking;
        }

        @Override
        public void run() {
            //进入停车场
            parking.park();
        }
    }
}