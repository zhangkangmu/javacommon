package com.tensquare.demo02_atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Demo7AtomicIntegerArray {

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1, 2, 3, 4, 5};
        AtomicIntegerArray aia = new AtomicIntegerArray(arr);

        aia.compareAndSet(1, 3, 200);

        System.out.println(aia.toString());
    }
}