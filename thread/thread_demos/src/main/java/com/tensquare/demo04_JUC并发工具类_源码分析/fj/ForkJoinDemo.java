/**
 * Copyright (c) 2020 itheima.com, All rights reserved.
 *
 * @Author: lvyang
 */
package com.tensquare.demo04_JUC并发工具类_源码分析.fj;

import lombok.Data;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @Description:
 * @Author: lvyang
 * @Created Date: 2020年06月05日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
@Data
public class ForkJoinDemo extends RecursiveTask<Integer> {

    private Integer[] arr;

    private int threshold;//阈值，表示计算的最小的数组长度

    public ForkJoinDemo(Integer[] arr, int threshold) {
        this.arr = arr;
        this.threshold = threshold;
    }

    static Integer[] getArr(int length){
        Integer[] arr = new Integer[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(200);
        }
        return arr;
    }

    @Override
    protected Integer compute() {
        //  		1. 做粒度控制，最终希望是粒度是计算两个元素
        if(arr.length>threshold){//可以再次拆分
            int leftLen = arr.length/2;
            //  		2. 创建一个A包装分割数组，并且fork开始计算
            Integer[] leftArr = Arrays.copyOf(arr, leftLen);
            Integer[] rightArr = Arrays.copyOfRange(arr, leftLen,arr.length);
            ForkJoinDemo leftForkJoin = new ForkJoinDemo(leftArr, threshold);
            ForkJoinDemo rightForkJoin = new ForkJoinDemo(rightArr, threshold);
            leftForkJoin.fork();//计算
            rightForkJoin.fork();//计算
            return leftForkJoin.join() + rightForkJoin.join();//3. 通过join合并计算结果
        }else{
            if(arr.length==1){
                return arr[0];
            }
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            //  		4. 返回结果
            return sum;
        }

    }


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Integer[] arr = ForkJoinDemo.getArr(2000000);
        long startTime = System.currentTimeMillis();
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(arr, 2);
        forkJoinPool.submit(forkJoinDemo);

        try {
            //5. 通过get拿到结果
            System.out.println("通过fork/join框架计算结果："+forkJoinDemo.get());
            long endTime = System.currentTimeMillis();
            System.out.println("fork/join框架花费时间："+(endTime-startTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        startTime = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("计算结果："+sum);
        long endTime = System.currentTimeMillis();
        System.out.println("普通花费时间："+(endTime-startTime));

    }


}