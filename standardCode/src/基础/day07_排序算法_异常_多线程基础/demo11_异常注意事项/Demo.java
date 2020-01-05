package 基础.day07_排序算法_异常_多线程基础.demo11_异常注意事项;

import java.io.IOException;
import java.text.ParseException;

/**
 * @author 彭智林
 * @date 2017/12/24 12:19
 */
public class Demo {
    public static void main(String[] args) {
        /*
            异常注意事项:
                1.运行时异常被抛出可以不处理。即不捕获也不声明抛出。
                2.如果父类的方法抛出了多个异常,子类覆盖(重写)父类方法时,只能抛出相同的异常或者是他的子集。
                3.父类方法没有抛出异常，子类覆盖父类该方法时也不可抛出异常。此时子类产生该异常，只能捕获处理，不能声明抛出
                4.在try/catch后可以追加finally代码块，其中的代码一定会被执行，通常用于资源回收。
                5.当多异常分别处理时，捕获处理，前边的类不能是后边类的父类

                多个异常使用捕获又该如何处理呢？
                    1. 多个异常分别处理。
                    2. 多个异常一次捕获，多次处理。
                    3. 多个异常一次捕获一次处理。

         */
//        System.out.println(1/0);
    }

    /**
     * 多个异常一次捕获一次处理
     * @param num
     */
    public static void method3(int num) {
        try {
            if(num == 1) {
                throw new IOException("IO异常");
            }else{
                throw new ParseException("解析异常",1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 多个异常一次捕获，多次处理。
     * @param num
     */
    public static void method2(int num) {
        try {
            if(num == 1) {
                throw new IOException("IO异常");
            }else{
                throw new ParseException("解析异常",1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 多个异常分别处理。
     * @param num
     */
    public static void method1(int num) {
        if(num == 1) {
            try {
                throw new IOException("IO异常");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                throw new ParseException("解析异常",1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
