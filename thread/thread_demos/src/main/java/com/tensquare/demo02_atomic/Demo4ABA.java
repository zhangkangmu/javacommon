package com.tensquare.demo02_atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Demo4ABA {

    private static AtomicInteger ai = new AtomicInteger(100);
    private static AtomicStampedReference air = new AtomicStampedReference(100, 1);

    //ABA问题演示：
    //1. 线程1先对数据进行修改 A-B-A过程
    //2. 线程2也对数据进行修改 A-C的过程
    public static void main(String[] args) throws InterruptedException {

        // AtomicInteger可以看到不会有任何限制随便改
        // 线程2修改的时候也不可能知道要A-C 的时候，A是原来的A还是修改之后的A
        Thread at1 = new Thread(new Runnable() {
            public void run() {
                ai.compareAndSet(100, 110);
                ai.compareAndSet(110, 100);
            }
        });

        Thread at2 = new Thread(new Runnable() {
            public void run() {
                try {
                    //为了让线程1先执行完，等一会
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("AtomicInteger:" + ai.compareAndSet(100, 120));
                System.out.println("执行结果：" + ai.get());
            }
        });

        at1.start();
        at2.start();

        //顺序执行，AtomicInteger案例先执行
        at1.join();
        at2.join();

        //AtomicStampedReference可以看到每次修改都需要设置标识Stamp，相当于进行了1A-2B-3A的操作
        //线程2进行操作的时候，虽然数值都一样，但是可以根据标识很容易的知道A是以前的1A，还是现在的3A
        Thread tsf1 = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //2. 预期引用：100，更新后的引用：110，预期标识getStamp() 更新后的标识getStamp() + 1
                air.compareAndSet(100, 110, air.getStamp(), air.getStamp() + 1);
                air.compareAndSet(110, 100, air.getStamp(), air.getStamp() + 1);
            }
        });

        Thread tsf2 = new Thread(new Runnable() {
            public void run() {

                //1.tsf2先获取stamp，导致预期时间戳不一致
                int stamp = air.getStamp();//1

                try {
                    TimeUnit.MILLISECONDS.sleep(200);     //线程tsf1执行完
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //3.
                System.out.println("AtomicStampedReference:" + air.compareAndSet(100, 120, stamp, stamp + 1));
                int[] stampArr = {stamp + 1};
                System.out.println("执行结果：" + air.get(stampArr));
            }
        });

        tsf1.start();
        tsf2.start();
    }
}