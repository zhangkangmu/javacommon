package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo12_AtomicInteger类;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 彭智林
 * @date 2019/12/25 12:29
 */
public class Demo {
    public static void main(String[] args) {
        /*
            原子类:java从JDK1.5开始提供了java.util.concurrent.atomic包(简称Atomic包)，这个包中的原子操作类提供了一种用法简单，性能高效，线程安全地更新一个变量的方式。

            原子包中的类:
                AtomicInteger 原子类型的int值
                AtomicLong 原子类型的long值
                AtomicReference 原子类型的对象
                AtomicReferenceArray 原子类型的对象数组
                AtomicIntegerArray 原子类型的int数组
                AtomicLongArray 原子类型的long数组

            AtomicInteger原子类: 表示原子类型的int值
                public AtomicInteger()：	   				初始化一个默认值为0的原子型Integer
                public AtomicInteger(int initialValue)： 初始化一个指定值的原子型Integer

                int get():   			 				 获取原子对象中的int值

                int getAndIncrement():      			 以原子方式将当前值加1，注意，这里返回的是自增前的值。
                int incrementAndGet():     				 以原子方式将当前值加1，注意，这里返回的是自增后的值。

                int addAndGet(int data):				 以原子方式将输入的数值与实例中的值（AtomicInteger里的value）相加，并返回结果。
                int getAndSet(int value):   			 以原子方式设置为newValue的值，并返回旧值。
         */
        // 创建一个原子类型的int值,值为0
        AtomicInteger ai1 = new AtomicInteger();// 0
        System.out.println("ai1原子对象中的int值为:"+ai1.get());// 0


        // 创建一个原子类型的int值,值为10
        AtomicInteger ai2 = new AtomicInteger(10);// 10
        System.out.println("ai2原子对象中的int值为:"+ai2.get());// 10

        // 需求: 对ai1变量中的int值进行后++操作  变量名++
        int res1 = ai1.getAndIncrement();// 类似ai1++
        System.out.println("res1 的值为:"+res1);// 0
        System.out.println("ai1原子对象中的int值为:"+ai1.get());// 1

        // 需求: 对ai2变量中的int值进行前++操作  ++变量名
        int res2 = ai2.incrementAndGet();// 类似++ai2
        System.out.println("res2 的值为:"+res2);// 11
        System.out.println("ai2原子对象中的int值为:"+ai2.get());// 11

        System.out.println("===============================");
        // 需求:让ai1变量中的int值 加上 3
        int res3 = ai1.addAndGet(3);
        System.out.println("res3 的值为:"+res3);// 加上某个数的结果
        System.out.println("ai1原子对象中的int值为:"+ai1.get());// 4

        // 需求:修改ai2变量中的int值为 200   ai2: 200
        int res4 = ai2.getAndSet(200);
        System.out.println("res4 的值为:"+res4);// 11
        System.out.println("ai2原子对象中的int值为:"+ai2.get());// 200

    }
}
