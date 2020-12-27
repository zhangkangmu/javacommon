package com.tensquare.demo04_JUC并发工具类_源码分析.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Demo4ConcurrentHashMap1 {
    public static void main(String[] args) {
        //Map<String, Integer> map = new HashMap();
        //Map<String, Integer> map = new ConcurrentHashMap<>();
        Map<String, Integer> map = new Hashtable<>();

        map.put("a", 1);
        map.put("b", 1);
        map.put("c", 1);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            map.remove(entry.getKey());
        }

        System.out.println(map.size());
    }
}