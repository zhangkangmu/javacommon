package com.tensquare.demo03_lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockDegradationDemo1 {

    public static void main(String[] args) {
        new demo1().fun2();
    }

    static class demo1{
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        public void fun1(){
            reentrantReadWriteLock.writeLock().lock();
            System.out.println("fun1");
            //fun2();
            reentrantReadWriteLock.writeLock().unlock();
        }

        public void fun2(){
            reentrantReadWriteLock.readLock().lock();
            System.out.println("fun2");
            fun1();
            reentrantReadWriteLock.readLock().unlock();
        }
    }
}