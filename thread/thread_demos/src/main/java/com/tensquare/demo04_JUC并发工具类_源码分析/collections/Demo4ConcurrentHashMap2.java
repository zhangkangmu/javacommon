package com.tensquare.demo04_JUC并发工具类_源码分析.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo4ConcurrentHashMap2 {
    public static void main(String[] args) {
        //final Map<String, Integer> count = new HashMap<>();
        final Map<String, AtomicInteger> count = new ConcurrentHashMap<>();
        //final Hashtable<String, Integer> count = new Hashtable<>();
        count.put("count", new AtomicInteger());

        Runnable task = new Runnable() {
            @Override
            public void run() {
                //synchronized (count) {
                    int value;
                    for (int i = 0; i < 2000; i++) {
                        value = count.get("count").incrementAndGet();
                    }
                //}
            }
        };
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();

        try {
            Thread.sleep(1000l);
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}