package com.tensquare.demo02_atomic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Demo9Compare {

    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong(0L);
        LongAdder longAdder = new LongAdder();
        test(atomicLong);
        test(longAdder);
    }

    public static void test(Object obj){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000000; j++) {
                        if(obj instanceof AtomicLong){
                            ((AtomicLong)obj).incrementAndGet();
                        }else{
                            ((LongAdder)obj).increment();
                        }
                    }
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {
        }
        String name = "";
        if(obj instanceof AtomicLong){
            name = "AtomicLong";
            System.out.println(((AtomicLong) obj).get());
        }else{
            name = "LongAdder";
            System.out.println(((LongAdder) obj).longValue());
        }
        System.out.println(name+"耗时：" + (System.currentTimeMillis() - start));
    }
}