package com.tensquare.demo04_JUC并发工具类_源码分析.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Demo4ConcurrentHashMap3 {
    public static void main(String[] args) {
        //final Map<String, Integer> count = new HashMap<>();
        //final Map<String, Integer> count = new ConcurrentHashMap<>();
        final Hashtable<String, Integer> count = new Hashtable<>();

        for (int i = 0; i < 2000; i++) {
            count.put("count" + i, 1);
        }

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500; i++) {
                    count.remove("count" + i);
                }
            }
        };
        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 1000; i < 1500; i++) {
                    count.remove("count" + i);
                }
            }
        };

        new Thread(task1).start();
        new Thread(task2).start();

        try {
            Thread.sleep(1000l);
            System.out.println(count.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}