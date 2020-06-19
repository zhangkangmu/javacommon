package com.tensquare.demo01_threaddemos;

public class DeadLockDemo {
    static Object obj1 = new Object();
    static Object obj2 = new Object();

    public static void fun01(){
        System.out.println(Thread.currentThread().getId()+"尝试获取obj1的锁");
        synchronized (obj1){
            System.out.println(Thread.currentThread().getId()+"获取到了ob1的锁");
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fun02();
        }
    }

    public static void fun02(){
        System.out.println(Thread.currentThread().getId()+"尝试获取obj2的锁");
        synchronized (obj2){
            System.out.println(Thread.currentThread().getId()+"获取到了ob2的锁");
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fun01();
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> fun01());
        Thread thread2 = new Thread(() -> fun02());
        thread1.start();
        thread2.start();
    }
}